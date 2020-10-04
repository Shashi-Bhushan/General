package in.shabhushan.algo_trials.benchmark.sort.quicksort;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static in.shabhushan.algo_trials.benchmark.sort.quicksort.QuickSort.*;

@Warmup(iterations = 3, time = 2, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 2, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Thread)
public class Benchmarks {
  /*
  @Benchmark
  public void testStartPivot(Blackhole blackhole) {
    int[] arr = getRandomArr(ARRAY_SIZE);

    quickSortStart(arr, 0, ARRAY_SIZE - 1);
  }

  @Benchmark
  public void testEndPivot(Blackhole blackhole) {
    int[] arr = getRandomArr(ARRAY_SIZE);

    quickSortEnd(arr, 0, ARRAY_SIZE - 1);
  }

  @Benchmark
  public void testRandomPivot(Blackhole blackhole) {
    int[] arr = getRandomArr(ARRAY_SIZE);

    quickSortRandom(arr, 0, ARRAY_SIZE - 1);
  }

  @Benchmark
  public void testJavaSort(Blackhole blackhole) {
    int[] arr = getRandomArr(ARRAY_SIZE);

    // Check DualArrayPivotSort.sort method for reference
    Arrays.sort(arr);
  }
  */
}
