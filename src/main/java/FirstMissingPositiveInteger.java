import java.util.Arrays;

public class FirstMissingPositiveInteger {

    public static int firstMissingPositiveInteger(int[] arr) {
        int m; //Storing maximum value
        m = Arrays.stream(arr).max().getAsInt();
        if (m < 1) // In case all values in our array are negative
        {
            return 1;
        }
        if (arr.length == 1) {

            //If it contains only one element
            if (arr[0] == 1) {
                return 2;
            } else {
                return 1;
            }
        }
        int i = 0;
        int[] l = new int[m];
        for (i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                if (l[arr[i] - 1] != 1) //Changing the value status at the index of our list
                {
                    l[arr[i] - 1] = 1;
                }
            }
        }
        for (i = 0; i < l.length; i++) //Encountering first 0, i.e, the element with least value
        {
            if (l[i] == 0) {
                return i + 1;
            }
        }
        //In case all values are filled between 1 and m
        return i+2;
    }


    public static void main(String[] args) {
        int arr[] = {10,-3,-5,9,1,3};
        int missing = firstMissingPositiveInteger(arr);
        System.out.println(missing);
    }
}
