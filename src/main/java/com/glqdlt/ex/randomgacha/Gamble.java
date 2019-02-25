package com.glqdlt.ex.randomgacha;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Jhun
 * 2019-02-25
 * @see <a href='https://www.baeldung.com/java-thread-local-random'>https://www.baeldung.com/java-thread-local-random</a>
 */
@Service
public class Gamble {
    public boolean gacha(int bound, int per) {
        int ran = ThreadLocalRandom.current().nextInt(1, bound + 1);
        System.out.println(String.format("random numb :  %s", ran));
        return ran <= per;
    }

    public boolean gachaMath(double per) {
        double ran = Math.random();
        return ran < per;
    }
}
