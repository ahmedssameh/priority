import java.util.ArrayList;
public class Priority{
    ArrayList<Process> WaitingQueue = new ArrayList<>();
    ArrayList<Process> ReadyQueue = new ArrayList<>();
    ArrayList<Process> Done = new ArrayList<>();
    //ArrayList<Process> copy ;
    int CurrentTime = 0 ;
    int agingValue = 5 ;

    Priority(ArrayList<Process> Q){
        for(Process i : Q)
        {
            WaitingQueue.add(new Process(i));
        }
        //copy = new ArrayList<Process>(WaitingQueue);

        WaitingQueue.sort(null);
        CurrentTime = WaitingQueue.get(0).getArrivalTime();
        AddInWaitingQueue(CurrentTime);

    }
    public void Execution() {
        Process currentProcess = new Process();
        while(WaitingQueue.size() > 0 ) {
            if(GetMaxPriority()==null) {
                CurrentTime++;

                AddInWaitingQueue(CurrentTime);
            }
            else {
                currentProcess = GetMaxPriority();
                currentProcess.setStartTime(CurrentTime);
                CurrentTime += currentProcess.getBurstTime();

                currentProcess.setWaitingTime( currentProcess.getStartTime() - currentProcess.getArrivalTime());
                currentProcess.setTurnaroundTime(currentProcess.getWaitingTime() + currentProcess.getBurstTime() );

                Done.add(currentProcess);
                WaitingQueue.remove(currentProcess);

                AddInWaitingQueue(CurrentTime);
                Starvation(agingValue);
                System.out.println( "Process " + currentProcess.getName() );

            }
        }
    }

    public double CalculateAverageWaiting() {
        double sum = 0.0;
        for(Process p : Done) {
            sum +=p.getWaitingTime();
        }
        return sum / Done.size();
    }
    public double CalculateAverageTurnAround() {
        double sum = 0.0;
        for(Process p : Done) {
            sum +=p.getTurnaroundTime();
        }
        return sum / Done.size();
    }
    private Process GetMaxPriority() {
        Process max= null;
        if(ReadyQueue.size()>0) {
            max = ReadyQueue.get(0);
            for(int i = 1; i< ReadyQueue.size() ; i++) {
                if(max.getPriority() >= ReadyQueue.get(i).getPriority()) {
                    if(max.getPriority() == ReadyQueue.get(i).getPriority())
                        max =(max.getArrivalTime() > ReadyQueue.get(i).getArrivalTime() ? ReadyQueue.get(i) :max);
                    else
                        max = ReadyQueue.get(i);
                }
            }
        }
        return max ;
    }

    private void AddInWaitingQueue(int currentTime) {
        ReadyQueue = new ArrayList<Process>();
        for(int i = 0; i < WaitingQueue.size() ; i++ )
            if(WaitingQueue.get(i).getArrivalTime() <= currentTime) {
                ReadyQueue.add(WaitingQueue.get(i));
            }
            else break;
    }

    private void Starvation(int time) {
        Process p;
        for(int i = 0; i < ReadyQueue.size() ; i++ ) {
            p = ReadyQueue.get(i);
            if(p.getPriority() > 0 && p!= GetMaxPriority()) {
                int increases_Prioroty = (CurrentTime - p.getLastTimeAged()) / time;

                increases_Prioroty = (Math.max(increases_Prioroty, 0));

                p.setPriority(p.getPriority() - increases_Prioroty);
                p.setLastTimeAged(CurrentTime + ((CurrentTime - p.getLastTimeAged()) % time));
            }
        }
    }

}