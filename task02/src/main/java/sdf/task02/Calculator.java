package sdf.task02;

public class Calculator {
    private float averageOfIntegers;
    private int individualInteger;
    private int sumOfIntegers;
    private String[] listOfNumbers;

    public float calculateAverage(String numbers) {
        listOfNumbers = numbers.split(",");
        for (int i = 0; i < listOfNumbers.length; i++) {
            individualInteger = Integer.parseInt(listOfNumbers[i]);
            sumOfIntegers += individualInteger;
        }
        return (float) sumOfIntegers / listOfNumbers.length;
    }
}
