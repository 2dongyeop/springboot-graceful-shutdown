package com.songareeit.gracefulshutdown;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;

/**
 * @author 이동엽(Dongyeop, Lee)
 * @date 2023. 10. 26
 * @description Graceful Shutdown을 테스트하기 위한 Endpoint
 * @history <pre>
 *  -----------------------------------------------------------------
 *      변경일          작성자                    변경내용
 *  --------------- ---------- --------------------------------------
 *   2023. 10. 26     이동엽                    최초 작성
 *
 *
 *  </pre>
 */
@RestController
public class TestEndpoint {

    private final Logger logger =  LoggerFactory.getLogger(this.getClass());


    /**
     * shutdown life cycle이 2초인 설정에서
     * 30초간 Sleep하는 동안 정상 종료(kill -15) 요청이 발생할 경우, 작업 실패 로그가 어떻게 나오는지 확인
     */
    @GetMapping("/test")
    public void test() throws InterruptedException {

        logger.warn("start");

        // 30초간 sleep
        Thread.sleep(30000);

        logger.warn("finish");
    }
}
