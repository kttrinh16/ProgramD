public class Averager {
    private int count;
    private double sum;


    /**
     * initialize the class and sets variables to 0
     */
    public Averager(){
        count = 0;
        sum = 0;
    }

    /**
     * reads in a new number
     * @param value
     * @Postcondition
     * adds number to the total sum and how many numbers to the count
     */
    public void addNumber(double value){
        if(count == Integer.MAX_VALUE)
            throw new IllegalStateException("Too Many Number");
        count++;
        sum+= value;
    }

    /**
     * calculates the average
     * @return
     */
    public double average(){
        if(count == 0 ){
            return Double.NaN;

        }
        else{
            return sum/count;
        }
    }

    /**
     * calculates the total amount of numbers
     * @return
     * @Postcondition
     * total number of count
     */
    public int howManyNumbers(){
        return count;
    }



}
