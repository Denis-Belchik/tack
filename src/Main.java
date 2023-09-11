import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        String[] array = new String[1_000_000];
        for (int i = 0; i < array.length / 2; i++) {
            array[i] = "" + i;
        }
        for (int i = 0; i < array.length / 2; i++) {
            array[i + array.length / 2] = i + "";
        }

//        String[] array = {"Qwe", "Asd", "Zxc", "Asd", "Ert", "Qwe", "Iop", "Zxc"};

    }

    public static String tack1(String[] array1) {
        return Arrays.stream(array1).distinct().collect(Collectors.joining());
    }

    public static String tack2(String[] array1) {
        String[] array = array1.clone();
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] != null && array[i] != null && array[i].equals(array[j])) {
                    array[j] = null;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (String s : array) {
            if (s != null)
                builder.append(s);
        }
        return builder.toString();
    }

    public static String tack3(String[] array1) {
        Set<String> set = new LinkedHashSet<>(List.of(array1));
        StringBuilder builder = new StringBuilder();
        for (String s1 : set) {
            builder.append(s1);
        }
        return builder.toString();
    }

}