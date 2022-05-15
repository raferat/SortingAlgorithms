import java.util.Comparator;

public class ShellSort<E> extends SortingAlgorithm<E>
{
  public ShellSort ( Comparator<E> comparator )
  {
    super ( comparator );
  }
  
  public E[] sort ( E[] toSort , E [] sorted  )
  {
    sorted = toSort.clone();
    
    int comparisonGab = sorted.length;
    
    do
    {
      comparisonGab = (int)Math.round(comparisonGab / 2.2);
      
      for ( int i = 0 ; i < sorted.length - comparisonGab ; i ++ )
      {
        if ( compare ( sorted[i] , sorted[i+comparisonGab] ) > 0 )
        {
          E tmp = sorted[i];
          sorted[i] = sorted[i+comparisonGab];
          sorted[i+comparisonGab] = tmp;
        }
      }
      
      
    } while ( comparisonGab != 1 );
    
    return new BubbleSort<E>(comparator).sort(sorted,sorted);
  }
}