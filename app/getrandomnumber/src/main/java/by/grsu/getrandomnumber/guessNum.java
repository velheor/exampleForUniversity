package by.grsu.getrandomnumber;

import java.util.Random;

public class guessNum {
    static public int getRandomNumber() {
        int min = 10;
        int max = 99;
        int diff = max - min;
        Random random = new Random();
        return random.nextInt(diff + 1) + min;
    }
}
