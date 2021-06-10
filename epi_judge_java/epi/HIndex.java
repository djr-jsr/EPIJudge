package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
public class HIndex {
  @EpiTest(testDataFile = "h_index.tsv")
  public static int hIndex(List<Integer> citations) {
    
    var size = citations.size();
    var countMap = new int[size + 1];
    for (var i = 0; i < size; i++) {
      var x = citations.get(i);
      if (x > size)
      {
        countMap[size]++;
      }
      else
      {
        countMap[x]++;
      }
    }

    var number_of_papers = 0;
    for (var i = size; i >= 0; i--) {
      number_of_papers += countMap[i];
      if (number_of_papers >= i)
      {
        return i;
      }
    }

    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "HIndex.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
