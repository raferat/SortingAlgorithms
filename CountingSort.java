import java.util.ArrayList;

public class CountingSort extends SortingAlgorithm<Integer>
{

	private final int biggest,smallest;
	
	public CountingSort(int smallest,int biggest)
	{
		super(Integer::compare);
		this.smallest = smallest;
		this.biggest = biggest;
	}

	@Override
	public Integer[] sort(Integer[] toSort, Integer[] sorted) 
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for ( int i = smallest ; i <= biggest ; i ++ )
		{
			for ( int j : toSort )
				if ( j == i )
					list.add(j);
		}
		
		return list.toArray(sorted.clone());
	}

}
