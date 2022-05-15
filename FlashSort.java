import java.util.Comparator;

public class FlashSort<E> extends SortingAlgorithm<E>
{
  public FlashSort ( Comparator<E> comparator )
  {
    super ( comparator );
  }
  
  public E[] sort ( E[] toSort , E[] sorted )
  {
    sorted = toSort.clone();
    
    //int pend = 0;
    
    
    for ( int j = 0 ; j < sorted.length /*- pend*/ ; j ++ )
    {
      int smallest = j;
      //int biggest  = j;
      
      for ( int i = j + 1 ; i < sorted.length /*- pend*/ ; i ++ )
      {
/*        if ( compare ( sorted[i] , sorted[biggest] ) > 0 )
        {
          biggest = i;
        }*/
        
        if ( compare ( sorted[i] , sorted[smallest] ) < 0 )
        {
          smallest = i;
        }
      }
      
      //sorted = swapElements ( sorted , biggest , sorted.length - pend - 1 );
      sorted = swapElements ( sorted , smallest , j );
      
      //pend ++;
      
    }
    
    return sorted;
  }
  
  private E[] swapElements ( E [] arr , int idx1 , int idx2 )
  {
    E tmp = arr[idx1];
    arr[idx1] = arr[idx2];
    arr[idx2] = tmp;
    
    return arr;
  }
}