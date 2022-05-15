import java.util.Comparator;

public class StoogeSort<E> extends SortingAlgorithm<E>
{
  public StoogeSort ( Comparator<E> comparator )
  {
    super ( comparator );
  }
  
  public E[] sort ( E[] toSort , E [] sorted  )
  {
    sorted = toSort.clone();
    
    return stoogeSort(sorted);
  }
  
  private E[] stoogeSort ( E [] toSort )
  {
    int i = 0;
    int j = toSort.length - 1;
    
    if ( compare ( toSort[i] , toSort [j] ) > 0 )
      swap(toSort,i,j);
    
    if ( j - i + 1 > 2 )
    {
      int t = (int)Math.round((j - i + 1d) / 3d);
      stoogeSort ( toSort , i     , j - t );
      stoogeSort ( toSort , i + t , j     );
      stoogeSort ( toSort , i     , j - t );
    }
    
    return toSort;
  }
  
  private void stoogeSort ( E [] toSort , int i , int j )
  {
    if ( compare ( toSort[i] , toSort [j] ) > 0 )
      swap(toSort,i,j);
    
    if ( j - i + 1 > 2 )
    {
      int t = (int)Math.round((j - i + 1d) / 3d);
      stoogeSort ( toSort , i     , j - t );
      stoogeSort ( toSort , i + t , j     );
      stoogeSort ( toSort , i     , j - t );
    }
  }
  
  
  private void swap ( E[] arr , int idx1 , int idx2 )
  {
    E tmp = arr[idx1];
    arr[idx1] = arr[idx2];
    arr[idx2] = tmp;
  }
}