import java.util.Arrays;
import java.util.List;

public class Main
{
  public static void main ( String[] args )
  {
    Integer [] bigdata = new Integer[75_000];
    //Integer [] bigdata = new Integer[1_000];
    
    for ( int i = 0 ; i < bigdata.length ; i ++ )
      bigdata[i] = (int)(Math.random()*10000);
    
    
    Integer [] test = {10,-20,50,-9,-15,60,30,456,454,20,-63};
    Integer [] smalldata = {10,-20,50,-9,0,0,15,25,3,6,-14,9};
    
    SortingAlgorithm<Integer> bubble   = new BubbleSort   <>(Integer::compare);
    SortingAlgorithm<Integer> oddEven  = new OddEvenSort  <>(Integer::compare);
    SortingAlgorithm<Integer> flash    = new FlashSort    <>(Integer::compare);
    SortingAlgorithm<Integer> bogo     = new BogoSort     <>(Integer::compare);
    SortingAlgorithm<Integer> shell    = new ShellSort    <>(Integer::compare);
    SortingAlgorithm<Integer> stooge   = new StoogeSort   <>(Integer::compare);
    SortingAlgorithm<Integer> patience = new PatienceSort <>(Integer::compare);
    SortingAlgorithm<Integer> quick    = new QuickSort    <>(Integer::compare,(List<Integer> l) -> l.get(l.size()/2));
    SortingAlgorithm<Integer> insert   = new InsertSort   <>(Integer::compare);
    SortingAlgorithm<Integer> shaker   = new CoctailShakerSort <>(Integer::compare);
    
    
    SortingAlgorithm<Integer> counting = new CountingSort   (0,10000);
    
    
    //SortingAlgorithm<Integer> sleep = new SleepSort();
    //Main.<Integer>timeSortingAlgorithm(shell,bigdata,"Shell",false);
    //Main.<Integer>timeSortingAlgorithm(bubble,bigdata,"Bubble",false);
    //Main.<Integer>timeSortingAlgorithm(flash,bigdata,"Flash",false);
    //Main.<Integer>timeSortingAlgorithm(oddEven,bigdata,"Odd Even",false);
    //Main.<Integer>timeSortingAlgorithm(stooge,bigdata,"Stooge",false);
    //Main.<Integer>timeSortingAlgorithm(patience,bigdata,"Patience",false);
    //Main.<Integer>timeSortingAlgorithm(quick,bigdata,"Quick",false);
    Main.<Integer>timeSortingAlgorithm(insert,smalldata,"Insert",true);
    //Main.<Integer>timeSortingAlgorithm(shaker,bigdata,"Shaker",false);
    //Main.<Integer>timeSortingAlgorithm(counting, bigdata, "Counting" , false);
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