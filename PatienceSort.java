import java.util.Comparator;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class PatienceSort<E> extends SortingAlgorithm<E>
{
  public PatienceSort ( Comparator<E> comparator )
  {
    super ( comparator );
  }
  
  public E[] sort ( E[] toSort , E [] sorted  )
  {
    sorted = toSort.clone();
    
    ArrayList<LinkedList<E>> preSorted = new ArrayList<LinkedList<E>> ();
    
    for ( E s : toSort )
    {
      boolean added = false;
      linkedLists: for ( LinkedList<E> l : preSorted )
      {
        if ( compare ( l . getFirst () , s ) >= 0 )
        {
          l.addFirst(s);
          added = true;
          break linkedLists;
        }
      }
      
      if ( ! added )
      {
        LinkedList<E> l = new LinkedList<>();
        l.addFirst(s);
        preSorted . add ( l );
      }
    }
    
    Comparator<LinkedList<E>> c = (LinkedList<E> l1 , LinkedList<E> l2 ) ->
    {
      E e1 = l1.getFirst ();
      E e2 = l2.getFirst ();      
      return compare ( e1 , e2 );
    };
    
    for ( int i = 0 ; i < sorted.length ; i ++ )
    {
      preSorted.sort(c);
      
      LinkedList<E> l = preSorted.get(0);
      if ( l == null )
        break;
      
      sorted[i]=l.removeFirst();
      
      if ( l.size () == 0 )
        preSorted . remove ( l );
    }
    
    return sorted;
  }
}