package org.thermoweb.aoc.days;

import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.Optional;
import org.thermoweb.aoc.Day;
import org.thermoweb.aoc.DaySolver;

@DaySolver(1)
public class Day1 implements Day {
    @Override
    public Optional<BigInteger> partOne(String input) {
        int currentPos = 50;

        long zeroCount = 0;
        String[] split = input.split("\\n");
        for(String s : split) {
            char direction = s.charAt(0);
            int clicks = Integer.parseInt(s.substring(1));

            if(direction == 'L') {
                currentPos -= clicks;

                currentPos = currentPos % 100;
                if (currentPos < 0) {
                    currentPos = 100 + currentPos;
                }
            } else if (direction == 'R') {
                currentPos += clicks;

                currentPos = currentPos % 100;
            }

            if(currentPos == 0) {
                zeroCount++;
            }
        }

        return Optional.of(BigInteger.valueOf(zeroCount));
    }

    @Override
    public Optional<BigInteger> partTwo(String input) {
        int currentPos = 50;

        long zeroCount = 0;
        String[] split = input.split("\\n");
        for(String s : split) {
            char direction = s.charAt(0);
            int clicks = Integer.parseInt(s.substring(1));

            int numberOfRotations = clicks / 100;
            int remainingClicks = clicks % 100;

            int prevCount = currentPos;

            if(numberOfRotations > 0) {
                zeroCount += numberOfRotations;
            }

            if(direction == 'L') {
                currentPos -= remainingClicks;

                if(currentPos < 0 && prevCount > 0) {
                    zeroCount++;
                }

                if (currentPos < 0) {
                    currentPos = 100 + currentPos;
                }
            } else if (direction == 'R') {
                currentPos += remainingClicks;


                if(currentPos > 100) {
                    zeroCount++;
                }

                currentPos = currentPos % 100;
            }


            if(currentPos == 0) {
                zeroCount++;
            }
        }

        return Optional.of(BigInteger.valueOf(zeroCount));
    }
}
