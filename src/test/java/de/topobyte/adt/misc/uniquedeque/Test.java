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
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 * 
 *         A simple test for the UniqueLinkedList data structure.
 */
public class Test
{

	public static void main(String[] args)
	{
		UniqueLinkedList<Integer> list = new UniqueLinkedList<>();
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		list.addFirst(4);
		list.addFirst(5);
		list.addFirst(6);
		print(list);
		list.moveToFront(4);
		print(list);
		list.moveToFront(1);
		print(list);
		list.moveToFront(2);
		print(list);
		list.removeLast();
		print(list);
		list.removeFirst();
		print(list);
		list.removeFirst();
		print(list);
		list.addLast(7);
		print(list);
		list.addLast(8);
		print(list);
		list.addLast(9);
		print(list);
		list.moveToTail(5);
		print(list);
		list.moveToTail(5);
		print(list);
		list.moveToTail(6);
		print(list);
		list.moveToTail(4);
		print(list);
	}

	private static void print(UniqueLinkedList<Integer> list)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("list: ");

		ListEntry<Integer> iter = list.getHead();
		while (iter != null) {
			int num = iter.getElement();
			buffer.append(num + ", ");
			iter = iter.getNext();
		}

		Integer first = list.getFirst();
		Integer last = list.getLast();

		buffer.append("first: ");
		buffer.append(first == null ? "null" : first);
		buffer.append(", last: ");
		buffer.append(last == null ? "null" : last);

		System.out.println(buffer);
	}

}
