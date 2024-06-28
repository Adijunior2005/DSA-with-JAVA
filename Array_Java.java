import java.util.*;

public class Array_Java{
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int size=scanner.nextInt();
        int arr[]= new int[size];
        //storing  values  in array
        for (int i=0; i<5; i++){
            System.out.println("enter the "+(i+1)+" value:");
            arr[i]=scanner.nextInt();
        }
        // printing the values in array
        System.out.println("Values in the array are as follows:");
        for (int i=0; i<5; i++){
            System.out.println(arr[i]);
        }

    }
}