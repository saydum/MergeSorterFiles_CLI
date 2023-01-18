package ru.saydum.sorter;

import ru.saydum.Main;

import java.util.List;

public class Sorter {
    public Sorter(int[] readLineData) {
            mergeIntSort(readLineData);
            for (int i = 0; i < readLineData.length; i++) {
                Main.sortedIntLine.add(readLineData[i]);
            }
    }

    private static void mergeIntSort(int[] arr) {

        int arrLength = arr.length;
        if (arrLength == 1) return;

        int mid = arrLength / 2;

        int[] left = new int[mid];
        int[] right = new int[arrLength - mid];

        for (int i = 0; i < mid; i++)
            left[i] = arr[i];

        for (int i = mid; i < arrLength; i++)
            right[i - mid] = arr[i];

        mergeIntSort(left);
        mergeIntSort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int idx = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <  right[j]) {
                arr[idx] = left[i];
                i++;
                idx++;
            } else {
                arr[idx] = right[j];
                j++;
                idx++;
            }
        }

        for (int ll = i; ll < left.length; ll++) {
            arr[idx++] = left[ll];
        }

        for (int rr = j; rr < right.length; rr++) {
            arr[idx++] = right[rr];
        }
    }

    private void StrSorter(List<String> readLineData) {
    }


}
