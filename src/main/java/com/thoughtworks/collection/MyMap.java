package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return array.stream().map((number) -> number * 3).collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        return array.stream().map(number -> String.valueOf((char) (number + 96))).collect(Collectors.toList());
    }

    public List<String> mapLetters() {
        return array.stream().map((number) -> {
            String string = "";
            for (; number > 26; number %= 26) {
                if (number % 26 == 0) {
                    string += (char) (number / 27 + 96);
                } else {
                    string += (char) (number / 26 + 96);
                }

            }
            if (number < 26) {
                if (number == 0) {
                    string += (char) (number +26 + 96);
                }else {
                    string += (char) (number + 96);
                }

            }
            return string;
        }).collect(Collectors.toList());
    }

    public List<Integer> sortFromBig() {
        return array.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {
        return array.stream().sorted().collect(Collectors.toList());
    }
}
