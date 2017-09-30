public class Arrays {

    // this integer array will contain 50 boxes
    private int[] theArray = new int[50];

    // here will only print the part of the array that has values
    private int arraySize  = 10;

    //generate a random number of values
    public void generateRandomArray() {

        for (int i = 0; i < arraySize; i++) {

            theArray[i] = (int)(Math.random()*10)+10;
        }
    }

    // Function to get value by its index

    public int getValueAtIndex(int index) {

        if (index < arraySize)
            return theArray[index];
        return 0;
    }

    //Function to print the array

    public void printArray() {

        System.out.println("----------");
        for (int i = 0; i < arraySize; i++) {

            System.out.print("| " + i + " | ");
            System.out.println(theArray[i] + " |");
            System.out.println("----------");
        }
    }

    public static void main(String[] args) {

        Arrays theArray = new Arrays();

        theArray.generateRandomArray();
        theArray.printArray();
        System.out.println(theArray.getValueAtIndex(0));

    }
}
