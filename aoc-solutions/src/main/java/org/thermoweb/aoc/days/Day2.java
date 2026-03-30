package org.thermoweb.aoc.days;

import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.Optional;
import org.thermoweb.aoc.Day;
import org.thermoweb.aoc.DaySolver;

@DaySolver(2)
public class Day2 implements Day {

    private boolean isInvalidId(String input) {

        if(input.length() % 2 != 0) {
            return false;
        }

        int halfPoint = input.length() / 2;
        String firstHalf = input.substring(0, halfPoint);
        String secondHalf = input.substring(halfPoint);


        return firstHalf.equals(secondHalf);
    }

    @Override
    public Optional<BigInteger> partOne(String input) {
        String[] ranges = input.split(",");

        long result = 0;
        for(String r : ranges) {
            String[] range = r.split("-");

            if(range[0].startsWith("0")) {
                continue;
            }
            for(long id = Long.parseLong(range[0]); id <= Long.parseLong(range[1]); id++) {
                if(isInvalidId(String.valueOf(id))) {
                    result += id;
                }
            }
        }

        return Optional.of(BigInteger.valueOf(result));
    }

    private boolean isInvalidIDPart2(String input) {
        for(int i = 1; i <= input.length() / 2; i++) {

            if(input.length() % i != 0) continue;

            int reps = input.length() / i;
            if(reps < 2) continue;

            String pattern = input.substring(0, i);
            boolean isValid = true;

            for(int j = 0; j < input.length(); j++) {
                if(input.charAt(j) != pattern.charAt(j % i)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) return true;
        }

        return false;
    }
    @Override
    public Optional<BigInteger> partTwo(String input) {
        String[] ranges = input.split(",");

        long result = 0;
        for(String r : ranges) {
            String[] range = r.split("-");

            for(long id = Long.parseLong(range[0]); id <= Long.parseLong(range[1]); id++) {
                if(isInvalidIDPart2(String.valueOf(id))) {
                    result += id;
                }
            }
        }

        return Optional.of(BigInteger.valueOf(result));
    }
}
