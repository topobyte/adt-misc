package de.topobyte.adt.misc;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Iterables;

public class TestStack
{

	@Test
	public void test0()
	{
		Stack<Integer> stack = new Stack<>();
		Assert.assertEquals(stack.size(), 0);
		Assert.assertEquals(stack.isEmpty(), true);
		assertEqual(stack);
	}

	@Test
	public void test1()
	{
		Stack<Integer> stack = new Stack<>();
		stack.push(3);
		Assert.assertEquals(stack.size(), 1);
		Assert.assertEquals(stack.isEmpty(), false);
		assertEqual(stack, 3);
	}

	@Test
	public void test3()
	{
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(3);
		stack.push(5);
		Assert.assertEquals(stack.size(), 3);
		Assert.assertEquals(stack.isEmpty(), false);
		assertEqual(stack, 1, 3, 5);
	}

	private void assertEqual(Stack<Integer> stack, int... values)
	{
		List<Integer> list = new ArrayList<>();
		Iterables.addAll(list, stack);

		List<Integer> check = new ArrayList<>();
		for (int value : values) {
			check.add(value);
		}
		Assert.assertEquals(list, check);
	}

}
