package competitive_programming;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Main r = new Main();
        r.run();
    }

    public void run() throws IOException{
        System.out.println(willUWin());
    }

    public String willUWin() throws IOException{
        String yes = "YES";
        String no = "NO";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numberOfAlpacas = Integer.parseInt(st.nextToken());
        long trackLength = Long.parseLong(st.nextToken());
        int deviceUsage = Integer.parseInt(st.nextToken());
        int speedReductionX = Integer.parseInt(st.nextToken());

        long[] speedOfLama = new long[numberOfAlpacas];
        double[] timeOfLama = new double[numberOfAlpacas];
        for(int i = 0; i < numberOfAlpacas; i++){
            st = new StringTokenizer(br.readLine());
            speedOfLama[i] = Long.parseLong(st.nextToken());
            timeOfLama[i] = (double)trackLength/speedOfLama[i];
        }
        st = new StringTokenizer(br.readLine());
        long myLamaSpeed = Long.parseLong(st.nextToken());
        double myLamaTime = (double)trackLength/myLamaSpeed;
        
        for(int i = 0; i < numberOfAlpacas; i++){
                while (timeOfLama[i] <= myLamaTime) {
                    deviceUsage--;
                    speedOfLama[i] = speedOfLama[i]*(100-speedReductionX)/100;
                    timeOfLama[i] = (double)trackLength/speedOfLama[i];
                    if(deviceUsage < 0){
                        return no;
                    }
                }
        }

        return yes;

    }
}