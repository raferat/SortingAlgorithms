import java.util.Comparator;

public class OddEvenSort<E> extends SortingAlgorithm<E>
{
  public OddEvenSort ( Comparator<E> comparator )
  {
    super ( comparator );
  }
  
  public E [] sort ( E [] toSort , E [] sorted  )
  {
    sorted = toSort.clone();
    
    int cycles = 0;
    
    do
    {
      cycles = 0;
      for ( int i = 0 ; i < sorted.length - 1 ; i += 2 )
      {
        if ( compare ( sorted[i] , sorted[i+1] ) > 0 )
        {
          E tmp = sorted[i];
          sorted[i] = sorted[i+1];
          sorted[i+1] = tmp;
          
          cycles ++;
        }
      }
      
      for ( int i = 1 ; i < sorted.length - 1 ; i += 2 )
      {
        if ( compare ( sorted[i] , sorted[i+1] ) > 0 )
        {
          E tmp = sorted[i];
          sorted[i] = sorted[i+1];
          sorted[i+1] = tmp;
          
          cycles ++;
        }
      }
      
      
    } while ( cycles != 0 );
    
    return sorted;
  }
}