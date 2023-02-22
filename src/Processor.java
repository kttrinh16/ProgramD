public class Processor {
    private int secondForProcess;
    private int processTimeLeft;

    /**
     * initialize a washer.
     * @param s
     * the number of seconds required for one wash cycle of this washer
     * @postcondition
     * this washer has been initialized so that it takes
     * seconds to complete one wash cycle
     */
    public Processor(int s){
        secondForProcess = s;
        processTimeLeft = 0;
    }

    /**
     * Determine whether this washer is currently busy.
     * @return
     * if this washer is busy
     */
    public boolean isBusy(){
        return (processTimeLeft > 0);
    }

    /**
     * Reduce the remaining time in the current wash cycle by one second.
     * @Postcondition
     * If a car is being washed, then the remaining time in the current
     * wash cycle has been reduced by one second.
     */
    public void reduceRemainingTime(){
        if (processTimeLeft > 0)
            processTimeLeft--;
    }

    /**
     * Start a wash cycle going for this washer
     * @Precondition
     * isBusy() is false
     * @Postcondition
     * This washer has started simulating one wash cycle. Therefore,
     * isbusy() will return until the required number of simulated seconds
     * have passed
     * @exception IllegalStateException
     * Indicates that this washer is busy.
     */
    public void startWashing (){
        if(processTimeLeft > 0)
            throw new IllegalStateException("Washing is busy");
        processTimeLeft = secondForProcess;
    }

    /**
     * sets the processing time
     * @Postcondition
     * finishes the processing time
     */
    public void setTimeLeft(int value){
        processTimeLeft = value;

    }
}
