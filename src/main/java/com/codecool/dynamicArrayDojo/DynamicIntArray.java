package com.codecool.dynamicArrayDojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class DynamicIntArray {

    private int size;
    private int[] dynamicArray;

    public DynamicIntArray() {
        this.size = 0;
    }

    public DynamicIntArray(int size) {
        this.size = size;
        this.dynamicArray = new int[this.size];
    }

    public void add(int value) {
        int[] newArray = new int[getSize() + 1];
        if (getDynamicArray() != null)
            System.arraycopy(getDynamicArray(), 0, newArray, 0, getSize());

        newArray[newArray.length - 1] = value;
        setDynamicArray(newArray);
        setSize(getSize() + 1);
    }

    public void remove(int value) throws ArrayIndexOutOfBoundsException {
        if (!IntStream.of(getDynamicArray()).anyMatch(x -> x == value))
            throw new ArrayIndexOutOfBoundsException();

        List<Integer> result = new ArrayList<>();
        for(int item : getDynamicArray())
            if(item != value)
                result.add(item);

        int[] array = result.stream().mapToInt(i->i).toArray();
        setDynamicArray(array);
        setSize(array.length);

    }

    public void insert(int index, int value) {
        if (index > getSize())
            add(value);
        else {
            int[] newArray = new int[getSize() + 1];
            for (int i = 0; i <= index; i++)
                if (i == index)
                    newArray[index] = value;
                else
                    newArray[i] = getDynamicArray()[i];

            int k = index + 1;
            for (int j=index; j < getSize(); j++)
                newArray[k++] = getDynamicArray()[j];

            setDynamicArray(newArray);
            setSize(getSize() + 1);
        }
    }

    public String toString() {
        return Arrays.toString(getDynamicArray());
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setDynamicArray(int[] dynamicArray) {
        this.dynamicArray = dynamicArray;
    }

    public int getSize() {
        return size;
    }

    public int[] getDynamicArray() {
        return dynamicArray;
    }
}
