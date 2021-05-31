import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = (ArrayList<String>) Stream.of("11111", "11111111", "11111111", "111"
                , "11", "111", "1111", "1111111"
                , "11111111", "111111", "11111111", "1"
                , "1", "1111111111", "1", "11111111111111").collect(Collectors.toList());

        ArrayList<ArrayList<String>> listsStr = getLists(list);
        ArrayList<Integer> maxLength = getMaxLength(listsStr);

        for (int i = 0; i < listsStr.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int j = 0; j < listsStr.get(i).size(); j++) {
                String f = getFormat(maxLength.get(j));
                String result = String.format(f, listsStr.get(i).get(j));
                stringBuilder.append(result);
            }
            System.out.println(stringBuilder.toString());
        }
    }

    private static String getFormat(int length) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("%-");
        stringBuilder.append(length);
        stringBuilder.append("." + length);
        stringBuilder.append("s\t");

        return stringBuilder.toString();
    }

    private static ArrayList<Integer> getMaxLength(ArrayList<ArrayList<String>> listsStr) {
        ArrayList<Integer> length = new ArrayList<>();
        for (int i = 0; i < listsStr.size(); i++) {
            int max = 0;
            for (ArrayList<String> list : listsStr) {
                if (max < list.get(i).length()) {
                    max = list.get(i).length();
                }
            }
            length.add(max);
        }
        return length;
    }

    private static ArrayList<ArrayList<String>> getLists(ArrayList<String> list) {
        ArrayList<ArrayList<String>> lists = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        int count = 0;
        for (String s : list) {
            count++;
            if (count == 4) {
                temp.add(s);
                lists.add(new ArrayList<>(temp));
                temp.clear();
                count = 0;
                continue;
            }
            temp.add(s);
        }
        return lists;
    }
}
