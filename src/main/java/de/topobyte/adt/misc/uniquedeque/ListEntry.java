// Copyright 2016 Sebastian Kuerten
//
// This file is part of adt-misc.
//
// adt-misc is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// adt-misc is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with adt-misc. If not, see <http://www.gnu.org/licenses/>.

package de.topobyte.adt.misc.uniquedeque;

/**
 * A class that may be used for implementing doubly-linked list data structures.
 * 
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 * 
 * @param <T>
 *            the type of elements.
 * 
 */
class ListEntry<T>
{

	private T element;
	private ListEntry<T> prev = null;
	private ListEntry<T> next = null;

	/**
	 * Create a new ListEntry wrapping the specified element.
	 * 
	 * @param element
	 *            the element to contain.
	 */
	public ListEntry(T element)
	{
		this.element = element;
	}

	/**
	 * @return the element this entry stores.
	 */
	public T getElement()
	{
		return element;
	}

	/**
	 * @return the next entry in the list.
	 */
	public ListEntry<T> getNext()
	{
		return next;
	}

	/**
	 * @return the previous entry in the list.
	 */
	public ListEntry<T> getPrevious()
	{
		return prev;
	}

	/**
	 * Set the element of the entry.
	 * 
	 * @param element
	 *            the element this entry should contain.
	 */
	public void setElement(T element)
	{
		this.element = element;
	}

	/**
	 * Set the entry after this entry to the specified entry.
	 * 
	 * @param next
	 *            the next entry.
	 */
	public void setNext(ListEntry<T> next)
	{
		this.next = next;
	}

	/**
	 * Set the entry before this entry to the specified entry.
	 * 
	 * @param prev
	 *            the previous entry.
	 */
	public void setPrevious(ListEntry<T> prev)
	{
		this.prev = prev;
	}

}
