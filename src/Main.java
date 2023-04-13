import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    String line = "Hello world!";
    String line1 = line.replaceAll("\\W", "");
    System.out.println(sortLine(line1));

  }

  public static String sortLine(String line) {
    if (line.length() == 0) {
      return line;
    }
    String result = "";
    List<Character> arrayCharFull = convertLineToArrayChar(line);
    int mid = arrayCharFull.size() / 2;
    List<Character> arrayCharPart1 = arrayCharFull.subList(0, mid);
    List<Character> arrayCharPart2 = arrayCharFull.subList(mid, arrayCharFull.size());
    arrayCharPart1.sort(Character::compareTo);
    arrayCharPart2.sort(Character::compareTo);
    List<Character> resultSortArray = merge(arrayCharPart1, arrayCharPart2);
    result = convertArrayCharToLine(resultSortArray);
    return result;
  }

  public static List<Character> convertLineToArrayChar(String line) {
    ArrayList<Character> result = new ArrayList<>();
    for (int i = 0; i < line.length(); i++) {
      result.add(line.charAt(i));
    }
    return result;
  }

  public static List<Character> merge(List<Character> list1, List<Character> list2) {
    List<Character> result = new ArrayList<>();
    int i1 = 0;
    int i2 = 0;

    while (i1 < list1.size() && i2 < list2.size()) {
      int first = list1.get(i1);
      int second = list2.get(i2);
      if (first < second) {
        result.add((char) first);
        ++i1;
      } else {
        result.add((char) second);
        ++i2;
      }
    }
    while (i1 < list1.size()) {
      result.add(list1.get(i1));
      ++i1;
    }

    while (i2 < list2.size()) {
      result.add(list2.get(i2));
      ++i2;
    }

    return result;
  }

  public static String convertArrayCharToLine(List<Character> characterList) {
    String result = "";
    for (int i = 0; i < characterList.size(); i++) {
      result += String.valueOf(characterList.get(i));
    }
    return result;
  }
}

