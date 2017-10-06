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

    //Linear Search to find all matches inside the array

    public String linearSearchForValue(int value) {

        boolean valueInArray = false;

        String indexWithValue = "";

        System.out.println("The Value was found in the following index(s) ");

        for (int i = 0; i < arraySize; i++) {

            if (theArray[i] == value) {

                valueInArray = true;

                System.out.print(i + " ");

                indexWithValue += i + " ";
            }
        }

        if (!valueInArray) {

            indexWithValue = "None";

            System.out.print(indexWithValue);
        }

        return indexWithValue;
    }

    // Function to swap values

    public void swapValue(int indexOne, int indexTwo) {

        int temp = theArray[indexOne];
        theArray[indexOne] = theArray[indexTwo];
        theArray[indexTwo] = temp;
    }

    //Bubble Sort Algorithm

    public void bubbleSort() {

        for (int i = arraySize - 1; i > 1; i-- ) {

            for (int j = 0; j < i; j++) {

                if (theArray[j] > theArray[j + 1]) {

                    swapValue(j, j+1);
                }
            }
        }
    }

    //Selection Sort Algorithm

    public void selectionSort() {

        for (int x = 0; x < arraySize; x++) {

            int minimum = x;

            for (int y = x; y < arraySize; y++) {

                if (theArray[minimum] > theArray[y]) {

                    minimum = y;
                }
            }

            swapValue(x, minimum);
        }
    }


    //Binary search

    public void binarySearchForValue(int value){

        int lowIndex = 0;
        int highIndex = arraySize - 1;

        while (lowIndex <= highIndex) {

            int middleIndex = (lowIndex + highIndex) / 2;

            if (theArray[middleIndex] < value)
                lowIndex = middleIndex + 1;
            else if (theArray[middleIndex] > value)
                highIndex = middleIndex - 1;

            else {

                System.out.println("found a match for " + value + " at index " + middleIndex);

                lowIndex = highIndex + 1;
            }

        }

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
        //theArray.printArray();
        System.out.println(theArray.getValueAtIndex(0));
        System.out.println(theArray.doesArrayContainThisValue(18));
        theArray.deleteIndex(3);
        //theArray.printArray();
        theArray.insertValue(55);
        theArray.selectionSort();
        theArray.binarySearchForValue(11);
        theArray.printArray();
        theArray.linearSearchForValue(12);
    }
}
