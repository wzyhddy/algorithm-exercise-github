package com.sparrow.array_;


/**
 * @Author: Sparrow
 * @Description: Array
 * @DateTime: 2024/11/23 10:31
 **/
public class Array<E> {

  private E[] data;

  private int size;

  public Array(int capacity) {
    data = (E[]) new Object[capacity];
    size = 0;
  }

  public Array() {
    this(10);
  }

  public boolean contains(E e) {
    for (int i = 0; i < size; i++) {
      if (data[i] == e) {
        return true;
      }
    }
    return false;
  }

  public int find(E e) {
    for (int i = 0; i < size; i++) {
      if (data[i] == e) {
        return i;
      }
    }
    return -1;
  }

  public E remove(int index) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("Get failed. Index is illegal.");
    }
    E ret = data[index];
    for (int i = index + 1; i < size; i++) {
      data[i - 1] = data[i];
    }
    size--;
    data[size] = null; //loitering objects 闲散的 闲逛的
    if (size == data.length / 2) {
      resize(data.length / 2);
    }
    return ret;
  }

  public E removeFirst() {
    return remove(0);
  }

  public E removeLast() {
    return remove(size - 1);
  }

  public void removeElement(E e) {
    int index = find(e);
    if (index != -1) {
      remove(index);
    }
  }

  public int getSize() {
    return size;
  }

  public int getCapacity() {
    return data.length;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void addLast(E e) {
    add(size, e);
  }

  public void addFirst(E e) {
    add(0, e);
  }

  public E get(int index) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("Get failed. Index is illegal.");
    }
    return data[index];
  }

  public E getLast() {
    return get(size - 1);
  }

  public E getFisrt() {
    return get(0);
  }

  void set(int index, E e) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("Get failed. Index is illegal.");
    }
    data[index] = e;
  }

  public void add(int index, E e) {
    if (index < 0 || index > size) {
      throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
    }
    if (size == data.length) {
      resize(2 * data.length);
    }
    for (int i = size; i > index; i--) {
      data[i] = data[i - 1];
    }
    data[index] = e;
    size++;
  }

  private void resize(int newCapacity) {
    E[] newData = (E[]) new Object[newCapacity];
    for (int i = 0; i < size; i++) {
      newData[i] = data[i];
    }
    data = newData;
  }

  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    res.append(String.format("Array: size = %d,capacity = %d\n", size, data.length));
    res.append('[');
    for (int i = 0; i < size; i++) {
      res.append(data[i]);
      if ((i != size - 1)) {
        res.append(", ");
      }
    }
    res.append(']');
    return res.toString();
  }

  public static void main(String[] args) {
    Array array = new Array(10);
    array.addLast(88);
    array.addLast(99);
    array.addLast(101);
    array.addLast(11);
    array.addLast(20);
    array.removeElement(99);
//    array.add(1,100);
    System.out.println(array.toString());
    System.out.println(array.getSize());
    System.out.println(array.getCapacity());
  }
}
