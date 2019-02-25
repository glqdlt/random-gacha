package com.glqdlt.ex.randomgacha;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

/**
 * @author Jhun
 * 2019-02-25
 */
@Slf4j
public class GambleTest {

    private final Gamble gamble = new Gamble();

    @Test
    public void 백분율에서12당첨확률() {


        int sumed = (int) IntStream.rangeClosed(1, 100)
                .filter(x -> {
                    boolean result = gamble.gacha(100, 12);
                    log.info("{}번쨰 : 결과는 ? {}", x, result);
                    return result;
                }).count();

        log.info("총 몇개 당첨? {}", sumed);

    }
}