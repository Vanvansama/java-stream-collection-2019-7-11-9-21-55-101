package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        if (leftBorder > rightBorder) {
            leftBorder = leftBorder + rightBorder;
            rightBorder = leftBorder - rightBorder;
            leftBorder = leftBorder - rightBorder;
        }
        return IntStream.rangeClosed(leftBorder, rightBorder).filter(number -> number % 2 == 0).sum();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        if (leftBorder > rightBorder) {
            leftBorder = leftBorder + rightBorder;
            rightBorder = leftBorder - rightBorder;
            leftBorder = leftBorder - rightBorder;
        }
        return IntStream.rangeClosed(leftBorder, rightBorder).filter(number -> number % 2 != 0).sum();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(number -> number * 3 + 2).reduce(Integer::sum).get();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(number -> {
            if (number % 2 != 0) {
                return number * 3 + 2;
            }
            return number;
        }).collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

//    public double getMedianOfEven(List<Integer> arrayList) {
//        throw new NotImplementedException();
//    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream().filter(number -> number % 2 == 0).collect(Collectors.averagingDouble(number -> number));
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        throw new NotImplementedException();
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(number -> number%2==0).collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> even= arrayList.stream().filter(number -> number%2==0).sorted().collect(Collectors.toList());
        List<Integer> odd= arrayList.stream().filter(number -> number%2!=0).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        even.addAll(odd);
        return even;
    }

//    public List<Integer> getProcessedList(List<Integer> arrayList) {
//        throw new NotImplementedException();
//    }
}
