
public class Process implements Comparable<Process>
{
    private String Name;
    private int BurstTime;
    private int ArrivalTime;
    private int Priority;
    private int WaitingTime;
    private int TurnaroundTime;
    private int StartTime;
    private int LastTimeAged;
    public Process() {}
    public Process(Process P) {
        Name =P.getName();
        BurstTime = P.getBurstTime();
        ArrivalTime = P.getArrivalTime();
        Priority = P.getPriority();
        StartTime = -1;
        LastTimeAged = ArrivalTime;
    }
    public void setName(String name) {
        Name = name;
    }
    public void setBurstTime(int burstTime) {
        BurstTime = burstTime;
    }
    public void setArrivalTime(int arrivalTime) {
        ArrivalTime = arrivalTime;
        LastTimeAged = ArrivalTime;
    }
    public void setPriority(int priority) {
        Priority = priority;
    }
    public void setWaitingTime(int waitingTime) {

        WaitingTime = waitingTime;
    }
    public void setTurnaroundTime(int turnaroundTime) {
        TurnaroundTime = turnaroundTime;
    }
    public String getName() {
        return Name;
    }
    public int getBurstTime() {
        return BurstTime;
    }
    public int getArrivalTime() {
        return ArrivalTime;
    }
    public int getPriority() {
        return Priority;
    }
    public int getWaitingTime() {
        return WaitingTime;
    }
    public int getTurnaroundTime() {
        return TurnaroundTime;
    }
    public int getStartTime() {
        return StartTime;
    }
    public void setStartTime(int startTime) {
        StartTime = startTime;
    }
    @Override
    public int compareTo(Process o) {
        return this.getArrivalTime() - o.getArrivalTime();
    }
    public int getLastTimeAged() {
        return LastTimeAged;
    }
    public void setLastTimeAged(int lastTimeAged) {
        LastTimeAged = lastTimeAged;
    }
}