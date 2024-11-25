package com.sparrow.stack_;

import com.sparrow.array_.Array;

/**
 * @Author: Sparrow
 * @Description: ArrayStack
 * @DateTime: 2024/11/24 9:18
 **/
public class ArrayStack<E> implements Stack<E> {

  Array<E> array;

  public ArrayStack(int capacity) {
    this.array = new Array<>(capacity);
  }

  public ArrayStack() {
    array = new Array<>();
  }

  @Override
  public int size() {
    return array.getSize();
  }

  @Override
  public boolean isEmpty() {
    return array.isEmpty();
  }

  @Override
  public void push(E e) {
     array.addLast(e);
  }

  @Override
  public E pop() {
    return array.removeLast();
  }

  @Override
  public E peek() {
    return array.getLast();
  }

  public int getCapacity() {
    return array.getCapacity();
  }

  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    res.append("Stack: ");
    res.append('[');
    for (int i = 0; i < array.getSize(); i++) {
      res.append(array.get(i));
      if (i != array.getSize() - 1) {
        res.append(", ");
      }
    }
    res.append("] top");
    return res.toString();
  }

  public static void main(String[] args) {
    ArrayStack<Integer> stack = new ArrayStack<>();
    for (int i = 0; i < 5; i++) {
      stack.push(i);
      System.out.println(stack);
    }
    stack.pop();
    System.out.println(stack);
  }
}
