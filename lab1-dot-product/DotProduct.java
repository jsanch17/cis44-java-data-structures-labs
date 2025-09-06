import java.util.Arrays;
import java.util.Random;
public class DotProductlab {
    public static void main(String[] args) {
        //testing value. But it could be substituted with a scanner to make the program more scalable
        int n = 5;
        //creates new Arrays of n length
        int[] array1 = new int[n];
        int[] array2 = new int[n];
        int[] array3 = new int[n];
        //Necessary to create random integers for the arrays
        Random rand = new Random();
        //puts the random integers into the array with a limit of 0 and 10
        for (int i = 0; i < n; i++) {
            array1[i] = rand.nextInt(10);
            array2[i] = rand.nextInt(10);
        }
// Uses the formula to calculate the multiplied product of both arrays per position
        for (int i = 0; i < array1.length; i++) {
            //Formula provided
            array3[i] += array1[i]*array2[i];
        }
        //prints out the original two arrays
        System.out.println("Array1: " + Arrays.toString(array1));
        System.out.println("Array2: " + Arrays.toString(array2));
        System.out.println("The product of the two arrays is: " + Arrays.toString(array3));
    }
}

