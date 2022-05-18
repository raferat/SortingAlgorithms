import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;

public class InsertSort<E> extends SortingAlgorithm<E> 
{
	
	

	public InsertSort(Comparator<E> compare) 
	{
		super(compare);
	}

	@Override
	public E[] sort(E[] toSort,E[] sorted) 
	{
		SortingAlgorithm<E> sorting = new BubbleSort<>(this::compare);
		
		ArrayList<E> in = new ArrayList<>();
		List<E> partiallySorted = new ArrayList<>();
		
		
		for ( E i : toSort )
			in.add(i);
		
		do
		{
			E next = in.get(0);
			
			if ( partiallySorted . size() == 0 )
			{
				partiallySorted.add(0, next);
				continue;
			}
			
			if ( compare( next , partiallySorted.get(0)) < 0 )
			{
				partiallySorted.add(0, next);
				in.remove(0);
			}
			else if ( compare(next , partiallySorted.get(partiallySorted.size()-1)) > 0 )
			{
				partiallySorted.add(next);
				in.remove(0);
			}
			else
			{
				E bigger = partiallySorted.get(partiallySorted.size()-1);
				in.remove(0);
				in.add(0,bigger);
				partiallySorted.remove(partiallySorted.size()-1);
				partiallySorted.add(next);
				E[] coctailSorted = sorting.sort((E[])partiallySorted.toArray(),sorted);
				partiallySorted.clear();
				for ( E e : coctailSorted )
					partiallySorted.add(e);
			}
					
		} while ( in.size() != 0 );
		
		
		return partiallySorted.toArray(sorted.clone());
	}
	
}
