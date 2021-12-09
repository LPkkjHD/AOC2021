package de.freemine.AOC2021.Day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Day1 {
    public static void main(String[] args) {
        try {
            List<Integer> collect = Files
                    .lines(Path.of(System.getProperty("user.dir"), "src", "res", "day1.txt"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            int amountLarger = 0;
            int lastTriple = 0;
            for (int i = 0; i < collect.size() - 3; i++) {
                int newTriple = collect.get(i) + collect.get(i + 1) + collect.get(i + 2);
                if (lastTriple < newTriple) amountLarger++;
                lastTriple = newTriple;
            }
            System.out.println(amountLarger);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
