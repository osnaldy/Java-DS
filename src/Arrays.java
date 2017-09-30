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

    //Function to delete a index and move the others values up

    public void deleteIndex(int index) {

        if (index < arraySize) {

            for (int i = index; i < (arraySize - 1); i++) {

                theArray[i] = theArray[i + 1];
            }

            arraySize --;
        }
    }

    //Function to insert a value at the end of the array

    public void insertValue(int value) {

        if (arraySize < 50) {

            theArray[arraySize] = value;

            arraySize ++;
        }
    }

    //Function to check if array contains a value

    public boolean doesArrayContainThisValue(int searchValue) {

        boolean valueInArray = false;

        for (int i = 0; i < arraySize; i++) {

            if (theArray[i] == searchValue) {

                valueInArray = true;
            }
        }
        return valueInArray;
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
        System.out.println(theArray.doesArrayContainThisValue(18));
        theArray.deleteIndex(3);
        theArray.printArray();
        theArray.insertValue(55);
        theArray.printArray();
    }
}
