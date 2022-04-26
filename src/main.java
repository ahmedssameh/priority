import java.util.ArrayList;
import java.util.Scanner;

public class main {

    static public void main (String[] arg)
    {
        int numberofProcesses;
        ArrayList<Process> Processes = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        System.out.println("Enter n of processes :");
        numberofProcesses = input.nextInt();
        // Read Processes
        for(int i = 0; i < numberofProcesses; i++)
        {
            input = new Scanner(System.in);
            Process p = new Process();
            System.out.println( (i+1) + " Enter Process Name :");
            p.setName(input.nextLine());

            System.out.println("Enter Process Burst Time :");
            p.setBurstTime(input.nextInt())  ;

            System.out.println("Enter Process Arraival Time :");
            p.setArrivalTime(input.nextInt()) ;

            System.out.println("Enter Process prority :");
            p.setPriority(input.nextInt());

            Processes.add(p);
        }
            Priority pScheduling = new Priority(Processes);
            pScheduling.Execution();
            System.out.println( "\nAverage Waiting Time :  " + pScheduling.CalculateAverageWaiting());
            System.out.println("Average Turnaround Time :" + pScheduling.CalculateAverageTurnAround() + "\n");


    }

}