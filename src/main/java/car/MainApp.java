package car;
import java.lang.Math.*;
/**
 * Created by hadoop on 28/10/15.
 */
public class MainApp {
   public static boolean getReply() {
        double s1=0, s2=0, lon[][], lat[][], lat1, lat2, lon1, lon2;
        double dlon, dlat, i1, i2, i3, i4, i5, i6, a, b, c, d;
        int i, j;
       boolean alert=false;

        lon = new double[2][2];
        lat = new double[2][2];
       if(Utils.getLatCar().size()==2&& Utils.getLatCar().get(0).size()==2 && Utils.getLatCar().get(1).size()==2){
           lat[0][0]=Utils.getLatCar().get(0).poll();
           lat[0][1]=Utils.getLatCar().get(0).poll();
           lat[1][0]=Utils.getLatCar().get(1).poll();
           lat[1][1]=Utils.getLatCar().get(1).poll();
           lon[0][0]=Utils.getLongCar().get(0).poll();
           lon[0][1]=Utils.getLongCar().get(0).poll();
           lon[1][0]=Utils.getLongCar().get(1).poll();
           lon[1][1]=Utils.getLongCar().get(1).poll();
           s1=Utils.carSpeed.get(0);
           s2=Utils.carSpeed.get(1);
           System.out.println("test");
       }

     //   printf("\n enter speed of a and b");              //enter speed
      //  scanf("%lf %lf", & s1,&s2);
        for (j = 0; j < 2; j++) {
        //    printf("\nenter longitude vales for car %d", j);   //enter longitude values
            for (i = 0; i < 2; i++) {
            //    printf("\nenter lon %d", i);               //for carA two longitude values and for carB two longitude values
          //      scanf("%lf", & lon[j][i]);
            }
        }
        j = 0;
        i = 0;
        for (j = 0; j < 2; j++) {
          //  printf("\nenter latitude vales for car %d", j);  //enter latitude values
            for (i = 0; i < 2; i++) {
            //    printf("\nenter lat %d", i);            //for car A two latitude and for car B two longitude values
             //   scanf("%lf", & lat[j][i]);
            }
        }


        for (j = 0; j < 2; j++) {
            for (i = 0; i < 2; i++)                  //convert lat and long in decimals to radians
            {
                lat[i][j] = lat[i][j] * (3.14 / 180);
//lat2=lat2*(3.14/180);
                lon[i][j] = lon[i][j] * (3.14 / 180);
            }
        }
        lat1 = lat[0][0];
        lat2 = lat[1][0];                    //taking only the first latitude and longitude values of car A and car B
        lon1 = lon[0][0];
        lon2 = lon[1][0];
//lon2=lon2*(3.14/180);

        dlat = lat2 - lat1;
        dlon = lon2 - lon1;
        i1 = Math.sin(dlat / 2);                   //calculating distance between two cars using lat and long values
        i2 = Math.sin(dlon / 2);
        i3 = Math.pow(i1, 2);
        i4 = Math.pow(i2, 2);
        a = i3 + ((Math.cos(lat1)) * (Math.cos(lat2)) * i4);
        i5 = Math.sqrt(a);
        i6 = Math.sqrt((1 - a));
        b = Math.atan2(i5, i6);
        c = 2 * b;
        d = (6373.0 * c) * 1000;
        //printf("\ndistance between a and b= %lf meters", d);
        i = 0;
        j = 1;
        if (d < 100.0 && s2 > s1)                    //condition will happen only if dist between two cars is less than 100m and speed of car behind is greater than car in the front
        {
            if (((lat[i][j] - lat[i][i]) > 0 && (lat[j][j] - lat[j][i]) > 0) ||

                    ((lat[i][j] - lat[i][i]) < 0 && (lat[j][j] - lat[j][i]) < 0) ||         // to check whether both the cars are moving in the same direction

                    ((lat[i][j] - lat[i][i]) > 0 && (lat[j][j] - lat[j][i]) > 0)) {
                if (((lon[i][j] - lon[i][i]) > 0 && (lon[j][j] - lon[j][i]) > 0) || ((lon[i][j] - lon[i][i]) < 0 && (lon[j][j] - lon[j][i]) < 0) || ((lon[i][j] - lon[i][i]) > 0 && (lon[j][j] - lon[j][i]) > 0)) {
                  alert=true;
                   // printf("\nHello A, the car behind may overtake you");             // warning message to car A
                  //  printf("\nHello B, your speed is more than the car before you.. either slowdown or overtake");  //warning message to car B
                }
            }
        }

       return alert;
    }



}
