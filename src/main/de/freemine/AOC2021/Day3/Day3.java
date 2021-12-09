package de.freemine.AOC2021.Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Day3 {
    public static void main(String[] args) {
        try {
            List<String> collect = Files
                    .lines(Path.of(System.getProperty("user.dir"), "src", "res", "day3.txt"))
                    .collect(Collectors.toList());
            int gamma = 0;
            int epsilon = 0;
            int[] amountHighBit = new int[12];
            for (String s : collect) {
                for (int i = 0; i < 12; i++) {
                    if (s.toCharArray()[i] == '1') amountHighBit[i]++;
                }
            }
            for (int i = 0; i < 12; i++) {
                if (amountHighBit[i] < 500) epsilon += Math.pow(2, 11 - i);
                else gamma += Math.pow(2, 11 - i);
            }
            System.out.println(gamma * epsilon);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
