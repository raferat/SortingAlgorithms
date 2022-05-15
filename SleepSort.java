import java.util.Comparator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.List;

public class SleepSort extends SortingAlgorithm<Integer>
{
  private final Timer timer;
  
  private static class AddToList extends TimerTask
  {
    private final List<Integer> list;
    private final int a;
    
    
    private AddToList ( int a , List<Integer> list )
    {
      this . list = list;
      this . a = a;
    }
    
    public void run ()
    {
      list.add(a);
      cancel();
    }
  }
  
  
  @Deprecated
  public SleepSort ()
  {
    super ( (Integer t1 , Integer t2) -> t1.compareTo(t2) );
    
    timer = new Timer ();
  }
  
  @Deprecated
  public Integer[] sort ( Integer [] toSort , Integer [] sorted  )
  {
    Integer biggest = toSort[0];
    Integer smallest = toSort[0];
    for ( Integer i : toSort )
    {
      if ( i > biggest )
        biggest = i;
      else if ( i < smallest )
        smallest = i;
    }
    
    ArrayList<Integer> list = new ArrayList<>();
    
    for ( Integer i : toSort )
    {
      timer . schedule ( new AddToList(i,list) , i.longValue()-smallest.longValue() );
    }
    
    try
    {
      Thread . sleep ( biggest.longValue() - smallest.longValue() + 10 );
      System.err.println("After sleep");
    }
    catch ( InterruptedException ex )
    {
      ex.printStackTrace();
    }
    
    return list.toArray(sorted);
  }
}