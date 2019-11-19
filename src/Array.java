package com.company;


public class Array {

    int[] array1;

    // Default constructor

    public Array() {
    }

    // Constructor that accepts array values

    public Array(int[] array1) {
        this.array1 = array1;
    }

    // Method for creating and filling an array

    public void setArray(int k) {
        this.array1 = new int[k];
        System.out.print("Array is filled by next numbers: ");
        for (int i = 0; i < k; i++) {
            array1[i] = i;
            System.out.print(array1[i] + ", ");
        }
        System.out.println("");
    }

    //Method for determining MAX value in array

    public void maximum() {

        int max = array1[0];
        for (int i : array1) {
            if (i > max) {
                max = i;
            }
        }
        System.out.println("Maximum value is: " + max);
    }

    // Method for determining MIN value in array

    public void minimum() {

        int min = array1[0];
        for (int i : array1) {
            if (i < min) {
                min = i;
            }
        }
        System.out.println("Minimum value is: " + min);
    }

    // Method for determining Avarage value in array

    public void averageArray() {
        int len = array1.length;
        int sum = 0;
        for (int i : array1) {
            sum += i;
        }
        System.out.println("Average value is: " + sum / len);
    }

    // Method for creating new array which contain even numbers

    public void moduloEven() {
        System.out.print("All even numbers are added to new array: {");

        int count = 0;

        for (int i = 0; i < array1.length; i++) {

            if (array1[i] % 2 == 0) {
                count += 1;
                System.out.print(array1[i] + ", " );
            }
        }


        int[] array2 = new int[count];
        int j = 0;
        for (int i = 0; i < array1.length; i++) {

            if (array1[i] % 2 == 0) {
                array2[j] = array1[i];
                j += 1;

            }
        }
        System.out.println("}");
    }

    // Method for creating new array which contain odd numbers

    public void moduloOdd() {
        System.out.print("All odd numbers are added to new array: {");

        int count = 0;

        for (int i = 0; i < array1.length; i++) {

            if (array1[i] % 2 != 0) {
                count += 1;
                System.out.print(array1[i] + ", ");
            }
        }


        int[] array2 = new int[count];
        int j = 0;
        for (int i = 0; i < array1.length; i++) {

            if (array1[i] % 2 != 0) {
                array2[j] = array1[i];
                j += 1;
            }
        }
        System.out.println("}");

    }

    // Method that lead out keys of even numbers

    public void evenKeys() {
        System.out.print("Keys list for 'even' numbers: ");

        //int count = 0;

        for (int i = 0; i < array1.length; i++) {

            if (array1[i] % 2 == 0) {
                //count += 1;
                System.out.print("[" + i + "]" + " " + "- is a key for number " + array1[i] + ", ");
            }
        }
        System.out.println(" ");
    }

    // Method that lead out array

    public void printAllArray() {
        System.out.print("All numbers in given array: ");
        System.out.print("{");
        for (int i : array1) {
            System.out.print(i + ", ");
        }
        System.out.println("}");
    }
}