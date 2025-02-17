package cs271.lab.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPerformance {

  // Testing with increasing sizes to observe performance trends
  private final int[] SIZES = {10, 100, 1000, 10000, 100000}; // Adjust as needed
  private final int REPS = 1000000; // Choose a reasonable number of repetitions

  private List<Integer> arrayList;
  private List<Integer> linkedList;

  @Before
  public void setUp() throws Exception {
    arrayList = new ArrayList<>();
    linkedList = new LinkedList<>();
  }

  @After
  public void tearDown() throws Exception {
    arrayList = null;
    linkedList = null;
  }

  private void fillLists(int size) {
    arrayList.clear();
    linkedList.clear();
    for (int i = 0; i < size; i++) {
      arrayList.add(i);
      linkedList.add(i);
    }
  }

  @Test
  public void testPerformance() {
    for (int size : SIZES) {
      System.out.println("\nTesting with SIZE = " + size);
      fillLists(size);

      measurePerformance("ArrayList Add/Remove", () -> testAddRemove(arrayList));
      measurePerformance("LinkedList Add/Remove", () -> testAddRemove(linkedList));

      measurePerformance("ArrayList Access", () -> testAccess(arrayList, size));
      measurePerformance("LinkedList Access", () -> testAccess(linkedList, size));
    }
  }

  private void testAddRemove(List<Integer> list) {
    for (int r = 0; r < REPS / list.size(); r++) { // Scale REPS based on size
      list.add(0, 77);
      list.remove(0);
    }
  }

  private void testAccess(List<Integer> list, int size) {
    long sum = 0;
    for (int r = 0; r < REPS / size; r++) { // Scale REPS based on size
      sum += list.get(r % size);
    }
  }

  private void measurePerformance(String testName, Runnable test) {
    long startTime = System.nanoTime();
    test.run();
    long endTime = System.nanoTime();
    long elapsedTime = (endTime - startTime) / 1_000_000; // Convert to milliseconds
    System.out.println(testName + " took " + elapsedTime + " ms");
  }
}