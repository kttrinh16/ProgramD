public class Request {
    private int arrivalTime;
    private int timeServed;
    private int departureTime;

    /**
     * initalizes a request
     * @param arrivalTime
     * @param timeServed
     */
    public Request(int arrivalTime, int timeServed){
        this.arrivalTime = arrivalTime;
        this.timeServed = timeServed;

    }

    /**
     * locates the time arrived
     * @return
     */
    public int getArrivalTime() {
        return arrivalTime;
    }

    /**
     * sets the current time being served
     * @param timeServed
     */
    public void setTimeServed(int timeServed){
        this.timeServed = timeServed;
    }

    /**
     * amount of time it took to process
     * @return
     */
    public int totalTime(){
        return departureTime - arrivalTime;
    }
}
