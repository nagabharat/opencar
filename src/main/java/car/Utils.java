package car;

import java.util.*;

/**
 * Created by hadoop on 28/10/15.
 */
public class Utils {
    static Queue<Integer> emptyQueue=new PriorityQueue<>(2);
    static HashMap<String,Integer> userMap=new HashMap<>();
    static HashMap<Integer,List<LastStatistics>> lastStatistics=new HashMap<>();


   static  {
        emptyQueue.add(0);
        emptyQueue.add(1);
    }

    static ArrayList<Queue<Double>> latCar=new ArrayList<>();
    static ArrayList<Queue<Double>> longCar=new ArrayList<>();

   static Queue<Double> latCar1=new PriorityQueue<>();
   static Queue<Double> latCar2=new PriorityQueue<>();
   static Queue<Double> longCar1=new PriorityQueue<>();
    static Queue<Double> longCar2=new PriorityQueue<>();
   static ArrayList<Double> carSpeed=new ArrayList<>();


    public static ArrayList<Queue<Double>> getLatCar() {
        return latCar;
    }

    public static void setLatCar(ArrayList<Queue<Double>> latCar) {
        Utils.latCar = latCar;
    }

    public static ArrayList<Queue<Double>> getLongCar() {
        return longCar;
    }

    public static void setLongCar(ArrayList<Queue<Double>> longCar) {
        Utils.longCar = longCar;
    }

    public static Queue<Double> getLatCar1() {
        return latCar1;
    }

    public static void setLatCar1(Queue<Double> latCar1) {
        Utils.latCar1 = latCar1;
    }

    public static Queue<Double> getLatCar2() {
        return latCar2;
    }

    public static void setLatCar2(Queue<Double> latCar2) {
        Utils.latCar2 = latCar2;
    }

    public static Queue<Double> getLongCar1() {
        return longCar1;
    }

    public static void setLongCar1(Queue<Double> longCar1) {
        Utils.longCar1 = longCar1;
    }

    public static Queue<Double> getLongCar2() {
        return longCar2;
    }

    public static void setLongCar2(Queue<Double> longCar2) {
        Utils.longCar2 = longCar2;
    }

}
