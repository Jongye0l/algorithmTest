package com.Jongyeol.Alhorithm;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    private static Integer[] array;
    public static void main(String[] args) {
        array = randomints();
        long time = System.currentTimeMillis();
        sort4();
        time = System.currentTimeMillis() - time;
        System.out.println("계산 시간 : " + time + "ms");
    }
    public static Integer[] randomints() {
        ArrayList<Integer> array = new ArrayList<>();
        Random random = new Random();
            for(int i = 0; i < 10000000; i++) {
            array.add(random.nextInt(210000000));
        }
        return array.toArray(new Integer[0]);
    }
    public static void sort1() {
        for(int i=0; i<array.length-1; i++){
            int min_index = i;
            for(int j=i+1; j<array.length; j++) if(array[j]<array[min_index]) min_index = j;
            int temp = array[i];
            array[i] = array[min_index];
            array[min_index] = temp;
        }
    }
    public static void sort2() {
        final int size = array.length;
        for(int i=0; i<size; i++) {
            for(int j=i; j<size; j++) {
                if(array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    public static void sort3() {
        for(int i=1; i<array.length;i++){
            int temp=array[i];
            int j;
            for(j=i-1; j>=0;j--){
                if(temp < array[j])
                    array[j+1] = array[j];
                else break;
            }
            array[j+1] = temp;
        }
    }
    public static void sort4() {
        sort4_1(0, array.length - 1);
    }
    private static void sort4_1(int low, int high) {
        if(low >= high) return;
        int pivot = sort4_2(low, high);
        sort4_1(low, pivot - 1);
        sort4_1(pivot + 1, high);
    }
    private static int sort4_2(int left, int right) {
        int low = left;
        int high = right;
        int pivot = array[right];
        while(low < high) {
            while(array[low] < pivot && low < high) low++;
            while(array[high] >= pivot && low < high) high--;
            sort4_3(low, high);
        }
        sort4_3(right, high);
        return high;
    }
    private static void sort4_3(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
