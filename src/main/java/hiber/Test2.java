package hiber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test2 {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String elem;
        StringBuilder stringBuilder = new StringBuilder();
        while((elem = input.readLine()) != null){
            stringBuilder.append(elem);
        }

        String[] words =  stringBuilder.toString().trim().toLowerCase()
                .split("\\s*(\\s|,|!|\\.|\\?|-)\\s*");

        Arrays.stream(words)
                .distinct()
                .collect(Collectors.toMap(i -> i, p -> (int) Arrays.stream(words)
                        .filter(t -> t.equals(p))
                        .count()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Integer> comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .map(Map.Entry::getKey)
                .limit(10)
                .forEach(System.out::println);

    }
}
