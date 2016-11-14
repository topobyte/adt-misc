package de.topobyte.adt.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple stack implementation based on {@link ArrayList}.
 * 
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 *
 * @param <T>
 *            type of elements in the stack.
 */
public class Stack<T>
{

	private List<T> list = new ArrayList<>();

	public void push(T element)
	{
		list.add(element);
	}

	public T peek()
	{
		return list.get(list.size() - 1);
	}

	public T pop()
	{
		return list.remove(list.size() - 1);
	}

	public void clear()
	{
		list.clear();
	}

	public boolean isEmpty()
	{
		return list.isEmpty();
	}

}
