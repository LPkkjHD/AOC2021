package de.freemine.AOC2021.Day6;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    private static final String OUTPUT_TEXT = "Fish after %s days: %s \n";

    public static void main(String[] args) {
        List<Integer> input = Arrays.stream(args[0].split(",")).map(Integer::parseInt).collect(Collectors.toList());
        Map<Integer, Integer> collect = input
                .stream()
                .collect(Collectors.groupingBy(Integer::intValue))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().size()));

        long[] eachState = new long[9];
        for (int i = 0; i < 9; i++) {
            if (collect.get(i) != null)
                eachState[i] = collect.get(i);
        }

        for (int i = 0; i < 256; i++) {
            long tmp = eachState[0];
            System.arraycopy(eachState, 1, eachState, 0, 8);
            eachState[8] = tmp;
            eachState[6] += tmp;
            if (i == 79) System.out.printf(OUTPUT_TEXT, 80, fishInTheSea(eachState));
        }
        System.out.printf(OUTPUT_TEXT, 256, fishInTheSea(eachState));
    }

    private static long fishInTheSea(long[] array) {
        long res = 0;
        for (int i = 0; i < 9; i++) {
            res += array[i];
        }
        return res;
    }
}
