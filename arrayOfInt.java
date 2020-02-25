import java.util.Random;

public class arrayOfInt {

  public int[] getRandomArray(int n) {
    Random r = new Random();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++ )  {
      arr[i] = r.nextInt();
      //System.out.println(arr[i]);
      //will scan the filled array
      for(int j = n-1; j > i; j-- ) {
        //if found decrement i and make it overwrite the value it just generated with a new value
          if(arr[i] == arr[j]) {
            i--;
          }
        }
      }
    return arr;
  }

  public int[] getSortedArray(int n) {
    int[] arr = new int[n+1];
    //starts at n and goes till 0
    for(int i = n; i > -1; i-- ) {
      //fills starting at 0 and goes till n
      arr[n-i] = i;
      //System.out.println(arr[n-i]);
    }
    return arr;
  }
}