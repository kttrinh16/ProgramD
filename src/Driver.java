import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Driver {

    public static void main(String args[]){

        int queProcessTime = 0;
        int staProcessTime = 0;
        int currentIndex = 0;
        int currentSecond;
        int current;
        int next;
        int index = 0;
        int count = 0;
        int incomplete = 0;
        Queue<Request> que = new LinkedList<>();
        Stack<Request> st = new Stack<Request>();
        LinkedQueue queue = new LinkedQueue();
        LinkedStack stack = new LinkedStack();
        Processor process = new Processor(queProcessTime);
        Processor stackProcess = new Processor(staProcessTime);
        Averager a = new Averager();
        Averager stackStat = new Averager();

        File inputFile;
        PrintWriter outputFile;
        String inputFileName;
        String outputFileName;
        System.out.println("Working directory = " + System.getProperty("user.dir"));


        try {

            //file scanner
            Scanner s = new Scanner(System.in);
            System.out.println("Please enter a File name from the working directory: ");
            inputFileName = s.next();
            inputFile = new File(inputFileName);
            Scanner fileScanner = new Scanner(inputFile);

            //puts everything that got scan into an array
            ArrayList<Integer> arr = new ArrayList<>();
            int n = fileScanner.nextInt();
            while (fileScanner.hasNextInt()) {
                arr.add(Integer.valueOf(n));
                n = fileScanner.nextInt();

            }
            arr.add(n);

            //checking to see if everything got put in the array properly
            System.out.println("\nFile read array\n" + arr.size());


            //ticker loop
            for(currentSecond = 0; currentSecond < 1000; currentSecond++) {

                //processing the queue line
                if (currentIndex < arr.size()) {
                    if (arr.get(currentIndex) == currentSecond) {
                        int spot = arr.get(currentIndex);
                        Request currentRequest = new Request(spot, -1);
                        que.add(currentRequest);
                        currentIndex++;
                    }
                }

                if (!process.isBusy() && !que.isEmpty()) {
                    current = que.remove().getArrivalTime();
                    int waitTime = currentSecond - current;
                    if (waitTime >= 30) {
                        process.setTimeLeft(3);
                        incomplete++;
                    } else {
                        a.addNumber((double) waitTime);
                        process.setTimeLeft(5);
                    }
                }
                if (process.isBusy()) {
                    process.reduceRemainingTime();
                }

                //processing the stack line
                if (index < arr.size()) {
                    if (arr.get(index) == currentSecond) {
                        int stackSpot = arr.get(index);
                        Request currentRequest = new Request(stackSpot, -1);
                        st.push(currentRequest);
                        index++;
                    }
                }

                if (!stackProcess.isBusy() && !st.isEmpty()) {
                    next = st.pop().getArrivalTime();
                    int sTime = currentSecond - next;
                    if (sTime >= 30) {
                        stackProcess.setTimeLeft(3);
                        count++;
                    } else {
                        stackStat.addNumber((double) sTime);
                        stackProcess.setTimeLeft(5);
                    }
                }
                if (stackProcess.isBusy()) {
                    stackProcess.reduceRemainingTime();
                }

            }

            System.out.println("\nFIFO");
            System.out.println("Numbers that got processed: " + a.howManyNumbers());
            System.out.println("Average wait time:" + a.average());
            System.out.println("Incompleted: " + incomplete);
            System.out.println("\nLIFO");
            System.out.println("Numbers that got processed: " + stackStat.howManyNumbers());
            System.out.println("Average: " + stackStat.average());
            System.out.println("Incompleted: " + count);


            s.close();
            fileScanner.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }

    }

}

///Users/kevintrinh/ProgramD/C-light.txt
///Users/kevintrinh/ProgramD/C-medium.txt
///Users/kevintrinh/ProgramD/C-heavy.txt
