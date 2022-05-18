import java.util.ArrayList;
import java.util.Comparator;

public class SelectSort<E> extends SortingAlgorithm<E> 
{
	public SelectSort(Comparator<E> compare) 
	{
		super(compare);
	}

	@Override
	public E[] sort(E[] toSort,E[] sorted) 
	{
		ArrayList<E> in = new ArrayList<>();
		sorted = toSort.clone();
		int idx = 0;
		
		
		for ( E i : toSort )
			in.add(i);
		
		do
		{
		
			int smallestIdx = 0;
		
			for ( int i = 1 ; i < in.size() ; i ++ )
			{
				E t = in.get(i);
				if ( compare ( t , in.get(smallestIdx) ) < 0 )
					smallestIdx = i;
			}
			
			sorted[idx++] = in.get(smallestIdx);
			in.remove(smallestIdx);
					
		} while ( in.size() != 0 );
		
		
		return sorted; 
	}

}
