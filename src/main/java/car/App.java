package car;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by hadoop on 28/10/15.
 */
@Path("/position")
public class App {

    private final static String NUM="NUM";

    @GET
    @Path("/{email}")
    @Produces({MediaType.APPLICATION_JSON})
    public Reply getMessage(@QueryParam("latitude") double latitude,
                            @QueryParam("longitude") double longitude,
                            @QueryParam("speed") double speed,
                            @PathParam("email") String email,
                            @Context HttpServletRequest request){
        Reply reply=new Reply();

        int num=0;
        if(request.getSession().isNew()){
            if (Utils.emptyQueue.peek()!=null) {
                num= Utils.emptyQueue.poll();
                request.getSession().setAttribute(NUM,num);
                Utils.userMap.put(email, num);
                ArrayList<LastStatistics> lastStatisticses=new ArrayList<>();
                LastStatistics lastStatistics=new LastStatistics();
                lastStatistics.setLatitude(latitude);
                lastStatistics.setLongitude(longitude);
                lastStatistics.setSpeed(speed);
                lastStatisticses.add(lastStatistics);
                Utils.lastStatistics.put(num,lastStatisticses);
            }

            Utils.latCar.add(num,new PriorityQueue<Double>());
            Utils.longCar.add(num,new PriorityQueue<Double>());





        }
        else {
            num=(int)request.getSession().getAttribute(NUM);
            LastStatistics lastStatistics=new LastStatistics();
            lastStatistics.setLatitude(latitude);
            lastStatistics.setLongitude(longitude);
            lastStatistics.setSpeed(speed);
            Utils.lastStatistics.get(num).add(lastStatistics);


        }
        Queue<Double> latQueue=Utils.latCar.get(num);
        Queue<Double> longQueue=Utils.longCar.get(num);
        latQueue.add(latitude);
        longQueue.add(longitude);
        Utils.carSpeed.add(num,speed);
        if(MainApp.getReply()){
            if(num==0){
                reply.setMessage("car "+(num+1)+" is going to overtake you...");
            }
            else {
                reply.setMessage("your speed is more than the car before you ...");
            }

        }
        else {
            reply.setMessage("safe");
        }



        return reply;
    }

    /**
     * deletes data of that car
     * @param request
     */
    @DELETE
    public void remove(@Context HttpServletRequest request){

        if(request.getSession().getAttribute(NUM)!=null){
            Utils.emptyQueue.add((Integer)request.getSession().getAttribute(NUM));
        }

        request.getSession().invalidate();

    }

    /**
     * checks out last data of car
     * @param request
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<LastStatistics> getStatistics(@Context HttpServletRequest request){

        int num=num=(int)request.getSession().getAttribute(NUM);

        return Utils.lastStatistics.get(num);
    }

}
