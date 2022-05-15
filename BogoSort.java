import java.util.Comparator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BogoSort<E> extends SortingAlgorithm<E>
{
  public BogoSort ( Comparator<E> comparator )
  {
    super ( comparator );
  }
  
  public E[] sort ( E[] toSort , E [] sorted  )
  {
    List<E> list = Arrays.<E>asList(toSort);
    
    while ( !isSorted ( list ) )
    {
      Collections.shuffle(list);
    }
    
    return list.toArray(sorted);
  }
}