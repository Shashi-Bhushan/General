package in.shabhushan.algo_trials.algorithms.chapter1.section1.exercise;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Exercise39 {
  public static int[] mainExperiment(int n) {
    int n1 = (int) Math.pow(10, 3);
    int n2 = (int) Math.pow(10, 4);
    int n3 = (int) Math.pow(10, 5);
    int n4 = (int) Math.pow(10, 6);

    int[] results = new int[4];

    for (int i = 0; i < n; i++) {
      results[0] += experiment(n1);
      results[1] += experiment(n2);
      results[2] += experiment(n3);
      results[3] += experiment(n4);
    }

    return results;
  }

  private static int experiment(int n) {
    int[] array1 = new int[n];
    int[] array2 = new int[n];

    for (int i = 0; i < n; i++) {
      array1[i] = StdRandom.uniform(100000, 1000000); //6 digit random value - StdRandom uniform is [a, b)
      array2[i] = StdRandom.uniform(100000, 1000000);
    }

    Arrays.sort(array1);
    Arrays.sort(array2);

    int numbersInBothArrays = 0;

    for (int i = 0; i < n; i++) {

      if (binarySearch(array1[i], array2, 0, array2.length -1)) {
        numbersInBothArrays++;
      }

    }

    return numbersInBothArrays;
  }

  private static boolean binarySearch(int key, int[] arr, int lo, int hi) {

    boolean found = false;

    if (lo <= hi) {
      int mid = lo + (hi - lo) / 2;

      if (key < arr[mid]) {
        binarySearch(key, arr, lo, mid - 1);
      } else if (key > arr[mid]) {
        binarySearch(key, arr, mid + 1, hi);
      } else {
        found = true;
      }
    }

    return found;
  }
}
