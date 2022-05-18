import java.util.Comparator;

public class CoctailShakerSort<E> extends SortingAlgorithm<E> 
{
	public CoctailShakerSort ( Comparator<E> comp ) 
	{
		super(comp);
	}
	

	@Override
	public E[] sort(E[] toSort,E[] sorted) 
	{
		sorted = toSort.clone();
		
		int cycles = 0;
		
		System.out.println(comparator);
		
		int start = 0 , end = sorted.length -1;
		
		do 
		{
			cycles = 0;
			
			for ( int i = start ; i < end ; i ++ )
			{
				if ( compare(sorted [i] , sorted[i+1])>0 )
				{
					E tmp = sorted[i];
					sorted[i] = sorted[i+1];
					sorted[i+1] = tmp;
					cycles++;
				}
			}
			
			end--;
			
			for ( int i = end ; i > start ; i -- )
			{
				if ( compare(sorted [i] , sorted[i-1]) < 0 )
				{
					E tmp = sorted[i];
					sorted[i] = sorted[i-1];
					sorted[i-1] = tmp;
					cycles++;
				}
			}
			
			start ++;
			
		} while ( cycles != 0 );
		
		return sorted;
		
	}

}
