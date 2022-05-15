import java.util.Comparator;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class QuickSort<E> extends SortingAlgorithm<E>
{
  @FunctionalInterface
  public static interface PivotPicker<T>
  {
    public T getPivot ( List<T> array );
  }
  
  private final PivotPicker<E> picker;
  
  public QuickSort ( Comparator<E> comparator , PivotPicker<E> picker )
  {
    super ( comparator );
    this . picker = picker;
  }
  
  public E[] sort ( E[] toSort , E [] sorted  )
  {
    sorted = toSort.clone();
    return sort (Arrays.asList(sorted)).toArray(sorted);
  }
  
  private List<E> sort ( List<E> toSort )
  {
    if ( toSort.size() < 2 )
      return toSort;
    
    if ( toSort.size() == 2 )
    {
      if ( compare(toSort.get(0),toSort.get(1)) > 0 )
      {
        toSort.add(toSort.get(0));
        toSort.remove(0);
      }
      return toSort;
    }
    
    E pivot = picker.getPivot(toSort);
    List<E> less = new ArrayList<E>();
    List<E> equal = new ArrayList<E>();
    List<E> greather = new ArrayList<E>();
    
    for ( int i = 0 ; i < toSort.size() ; i ++ )
    {
      int compare = compare ( toSort . get(i) , pivot );
      if ( compare < 0 )
      {
        less.add(toSort . get(i));
      }
      else if ( compare == 0 )
      {
        equal.add(toSort . get(i));
      }
      else
      {
        greather.add(toSort . get(i));
      }
    }
    
    List<E> sorted = sort(less);
    sorted.addAll(equal);
    sorted.addAll(sort(greather));
    
    return sorted;
  }
}