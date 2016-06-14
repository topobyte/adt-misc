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

import java.util.HashMap;
import java.util.Map;

/**
 * A doubly linked list with unique entries. Uniqueness is in terms of
 * {@link Map} lookup semantic, i.e. {@link Object#hashCode()} and
 * {@link Object#equals(Object)}. This list supports insertion and removal at
 * head and tail as well as a move-to-front and move-to-tail operation. The
 * uniqueness of its elements is not explicitly enforced by the implementation,
 * i.e. you have to expect strange results if adding the same element more than
 * once. If you don't know whether an element is in the data structure because
 * of your usage pattern anyway, use the {@link #contains(Object)} method to
 * find out whether an element is already present.
 * 
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 * 
 * @param <T>
 *            type of elements in the list.
 * 
 */
public class UniqueLinkedList<T>
{

	private ListEntry<T> head = null;
	private ListEntry<T> tail = null;

	private Map<T, ListEntry<T>> entryMap = new HashMap<>();

	private int size = 0;

	ListEntry<T> getHead()
	{
		return head;
	}

	ListEntry<T> getTail()
	{
		return tail;
	}

	/**
	 * Add an element to the front of the list.
	 * 
	 * @param element
	 *            the element to add.
	 */
	public void addFirst(T element)
	{
		size += 1;
		ListEntry<T> oldHead = head;
		// create a new head to hold the element
		head = new ListEntry<>(element);
		entryMap.put(element, head);
		// organize pointers
		head.setNext(oldHead);
		if (oldHead == null) {
			// if the list was empty before
			tail = head;
		} else {
			oldHead.setPrevious(head);
		}
	}

	/**
	 * Add an element to the end of the list.
	 * 
	 * @param element
	 *            the element to add.
	 */
	public void addLast(T element)
	{
		size += 1;
		ListEntry<T> oldTail = tail;
		// create a new tail to hold the element
		tail = new ListEntry<>(element);
		entryMap.put(element, tail);
		// organize pointers
		tail.setPrevious(oldTail);
		if (oldTail == null) {
			// if the list was empty before
			head = tail;
		} else {
			oldTail.setNext(tail);
		}
	}

	/**
	 * Get the number of elements currently stored in this list.
	 * 
	 * @return the size of this list.
	 */
	public int size()
	{
		return size;
	}

	/**
	 * Find out whether the specified element is currently contained within the
	 * list.
	 * 
	 * @param element
	 *            the element to check.
	 * @return whether the element is contained within the list.
	 */
	public boolean contains(T element)
	{
		return entryMap.containsKey(element);
	}

	/**
	 * Get the first element in the list.
	 * 
	 * @return the first element.
	 */
	public T getFirst()
	{
		if (head == null) {
			return null;
		}
		return head.getElement();
	}

	/**
	 * Get the last element in the list.
	 * 
	 * @return the last element.
	 */
	public T getLast()
	{
		if (tail == null) {
			return null;
		}
		return tail.getElement();
	}

	/**
	 * Remove all elements from the list.
	 */
	public void clear()
	{
		head = null;
		tail = null;
		size = 0;
	}

	/**
	 * Remove the first element from the list.
	 * 
	 * @return the element removed.
	 */
	public T removeFirst()
	{
		if (size == 0) {
			return null;
		}
		size -= 1;
		ListEntry<T> oldHead = head;
		ListEntry<T> newHead = oldHead.getNext();
		head = newHead;
		if (newHead == null) {
			// if this was the last element
			tail = null;
		} else {
			newHead.setPrevious(null);
		}
		return oldHead.getElement();
	}

	/**
	 * Remove the last element from the list.
	 * 
	 * @return the element removed.
	 */
	public T removeLast()
	{
		if (size == 0) {
			return null;
		}
		size -= 1;
		ListEntry<T> oldTail = tail;
		ListEntry<T> newTail = oldTail.getPrevious();
		tail = newTail;
		if (newTail == null) {
			// if this was the last element
			head = null;
		} else {
			newTail.setNext(null);
		}
		return oldTail.getElement();
	}

	/**
	 * Move the denoted element to the front.
	 * 
	 * @param element
	 *            the element to move to the front.
	 */
	public void moveToFront(T element)
	{
		ListEntry<T> listEntry = entryMap.get(element);
		if (listEntry == null) {
			// element not in list
			return;
		}
		if (head == listEntry) {
			// element already at front
			return;
		}
		// previous may not be null, next may
		ListEntry<T> oldNext = listEntry.getNext();
		ListEntry<T> oldPrev = listEntry.getPrevious();
		oldPrev.setNext(oldNext);
		if (oldNext == null) {
			// element was the tail
			tail = oldPrev;
		} else {
			oldNext.setPrevious(oldPrev);
		}

		// head may not be null, we checked that before.
		ListEntry<T> oldHead = head;
		head = listEntry;
		head.setNext(oldHead);
		oldHead.setPrevious(listEntry);
		listEntry.setPrevious(null);
	}

	/**
	 * Move the denoted element to the tail.
	 * 
	 * @param element
	 *            the element to move to the tail.
	 */
	public void moveToTail(T element)
	{
		ListEntry<T> listEntry = entryMap.get(element);
		if (listEntry == null) {
			// element not in list
			return;
		}
		if (tail == listEntry) {
			// element already at tail
			return;
		}
		// next may not be null, previous may
		ListEntry<T> oldNext = listEntry.getNext();
		ListEntry<T> oldPrev = listEntry.getPrevious();
		oldNext.setPrevious(oldPrev);
		if (oldPrev == null) {
			// element was the head
			head = oldNext;
		} else {
			oldPrev.setNext(oldNext);
		}

		// head may not be null, we checked that before.
		ListEntry<T> oldTail = tail;
		tail = listEntry;
		tail.setPrevious(oldTail);
		oldTail.setNext(listEntry);
		listEntry.setNext(null);
	}

}
