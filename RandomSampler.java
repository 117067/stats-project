import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomSampler {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a file path: ");
    File file = new File(scanner.next());
    scanner.close();
    List<String> names = new ArrayList<>();
    int size = 0;
    try {
      BufferedReader reader = new BufferedReader(new FileReader(file));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] values = line.split(",");
        String name = values[1] + " " + values[0];
        if (name.equals("Kai Imani") || name.equals("Michael Perelstein") || name.equals("Charles DeLisa")
            || name.equals("FirstName LastName"))
          continue;
        names.add(name);
        size++;
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    Random random = new Random();
    List<Integer> selected = new ArrayList<>();
    int count = 0;
    while (count < 600) {
      int next = random.nextInt(size);
      if (!selected.contains(next)) {
        selected.add(next);
        count++;
      }
    }
    for (int group = 0; group < 6; group++) {
      List<String> inGroup = new ArrayList<>();
      System.out.println("Group " + Integer.toString(group + 1) + ":");
      System.out.println("----------");
      for (int i = 0; i < 100; i++)
        inGroup.add(names.get(selected.get(group * 100 + i)));
      Collections.sort(inGroup);
      for (String name : inGroup)
        System.out.println(name);
      System.out.println("----------");
    }
  }
}
