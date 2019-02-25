package com.glqdlt.ex.randomgacha;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.core.task.support.ExecutorServiceAdapter;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Collectors;
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

    @Test
    public void 백복율에서12당첨확률Math() {
        //12% = 0.12
        //1% = 0.01
        //17.17 = 0.1717
        final double per = 0.88;
        long result = IntStream.rangeClosed(1, 100)
                .filter(x -> {
                    boolean asd = gamble.gachaMath(per);
//                    log.info("{}번쨰 : 결과는 ? {}", x, asd);
                    return asd;
                }).count();
        log.info("총 몇개 당첨? {}", result);
    }

    @Test
    public void 멀티스레드() {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        final double per = 0.205;
        List<Integer> asdasd = IntStream.rangeClosed(1, 100).boxed()
                .collect(Collectors.toList());

        List<Future<Boolean>> fa = asdasd.stream()
                .map(x -> executorService.submit(new GachaCallable(per)))
                .collect(Collectors.toList());

        long result = fa.stream()
                .filter(x -> {
                    try {
                        return x.get();
                    } catch (InterruptedException | ExecutionException e) {
                        log.error(e.getMessage(), e);
                        return false;
                    }
                }).count();

        log.info("result : {}",result);

    }

    @Test
    public void name() {
        Random random = new Random(100);
        long re = IntStream.rangeClosed(1, 100)
                .filter(x -> {
                    int ran = random.nextInt();
                    log.info("{}번째 random : {}", x, ran);
                    return ran < 12;
                }).count();

        log.info("결과 : {}", re);
    }
}