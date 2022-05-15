import java.util.Arrays;

public class Main
{
  public static void main ( String[] args )
  {
    //Integer [] bigdata = new Integer[75_000];
    Integer [] bigdata = new Integer[5_000];
    
    for ( int i = 0 ; i < bigdata.length ; i ++ )
      bigdata[i] = (int)(Math.random()*10000);
    
    
    Integer [] test = {10,-20,50,-9,-15,60,30,456,454,20,-63};
    Integer [] smalldata = {10,-20,50,-9,0,0,15,25,3,6,-14,9};
    
    SortingAlgorithm<Integer> bubble = new BubbleSort<Integer>((Integer t1 , Integer t2) ->t1.compareTo(t2));
    SortingAlgorithm<Integer> oddEven = new OddEvenSort<Integer>((Integer t1 , Integer t2) ->t1.compareTo(t2));
    SortingAlgorithm<Integer> flash = new FlashSort<Integer>((Integer t1 , Integer t2) ->t1.compareTo(t2));
    SortingAlgorithm<Integer> bogo = new BogoSort<Integer>((Integer t1 , Integer t2) ->t1.compareTo(t2));
    SortingAlgorithm<Integer> shell = new ShellSort<Integer>((Integer t1 , Integer t2) ->t1.compareTo(t2));
    SortingAlgorithm<Integer> stooge = new StoogeSort<Integer>((Integer t1 , Integer t2) ->t1.compareTo(t2));
    SortingAlgorithm<Integer> patience = new PatienceSort<Integer>((Integer t1 , Integer t2) ->t1.compareTo(t2));
    
    //SortingAlgorithm<Integer> sleep = new SleepSort();
    
    //Main.<Integer>timeSortingAlgorithm(shell,bigdata,"Shell",false);
    Main.<Integer>timeSortingAlgorithm(bubble,bigdata,"Bubble",false);
    //Integer[] array1 = Main.<Integer>timeSortingAlgorithm(flash,bigdata,"Flash",false);
    Main.<Integer>timeSortingAlgorithm(oddEven,bigdata,"Odd Even",false);
    Main.<Integer>timeSortingAlgorithm(stooge,bigdata,"Stooge",false);
    //Integer[] array2 = Main.<Integer>timeSortingAlgorithm(patience,bigdata,"Patience",false);
    
    //Main.<Integer>timeSortingAlgorithm(sleep,bigdata,"Sleep",true);
  }
  
  private static <E extends Object> E[] timeSortingAlgorithm ( SortingAlgorithm<E> alg , E [] array , String name , boolean print )
  {
    long millis = System.currentTimeMillis();    
    array = alg . sort ( array , array );    
    millis = System.currentTimeMillis() - millis;
    
    System.out.println ( name + " sort: " + (millis / 1000d) + "s" );
    
    
    if ( print )
      printArr(array);
    
    return array;
  }
  
  public static void printArr ( Object [] arr )
  {
    System.out.println(Arrays.toString(arr));
  }
}