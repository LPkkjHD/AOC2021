package de.freemine.AOC2021.Day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Day2 {
    public static void main(String[] args) {
        try {
            List<String> collect = Files
                    .lines(Path.of(System.getProperty("user.dir"), "src", "res", "day2.txt"))
                    .collect(Collectors.toList());
            int depth = 0, pos = 0, aim = 0;
            for (String s : collect) {
                int amount = Integer.parseInt(s.substring(s.length() - 1));
                switch (s.length()) {
                    case 9 -> {
                        pos += amount;
                        depth += aim * amount;
                    }
                    case 6 -> aim += amount;
                    default -> aim -= amount;
                }
            }
            System.out.println(pos * depth);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
