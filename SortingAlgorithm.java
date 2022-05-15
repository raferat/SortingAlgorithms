import java.util.Comparator;
import java.util.List;

public abstract class SortingAlgorithm <E>
{
  protected final Comparator<E> comparator;
  
  protected SortingAlgorithm ( Comparator<E> compare )
  {
    comparator = compare;
  }
  
  public abstract E[] sort ( E[] toSort , E [] sorted );
  
  protected int compare ( E e1 , E e2 )
  {
    return comparator.compare ( e1 , e2 );
  }
  
  protected boolean isSorted ( E[] array )
  {
    for ( int i = 0 ; i < array.length -1 ; i ++ )
    {
      if ( compare(array[i],array[i+1]) > 0 )
      {
        return false;
      }
    }
    
    return true;
  }
  
  protected boolean isSorted ( List<E> list )
  {
    for ( int i = 0 ; i < list.size() -1 ; i ++ )
    {
      if ( compare(list.get(i),list.get(i+1)) > 0 )
      {
        return false;
      }
    }
    
    return true;
  }
}