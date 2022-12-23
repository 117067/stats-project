import java.util.Random;

class Simulation {
  public static void main(String[] args) {
    //edit the result values as necessary
    int smallerResult = 16;
    int largerResult = 20;
    int trials = 1000000;
    Random random = new Random();
    int sum = smallerResult + largerResult;
    int successes = 0;
    for (int i = 0; i < trials; i ++) {
      int result = 0;
      for (int j = 0; j < sum; j ++) {
        if (random.nextBoolean()) result ++;
      }
      if (result <= smallerResult) successes ++;
    }
    System.out.println(((double) successes) / ((double) trials));
  }
}
