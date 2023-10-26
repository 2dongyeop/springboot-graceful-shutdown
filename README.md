# practice-graceful-shutdown

Spring Boot 2.3 이후부터 제공하는 종료 옵션인, [Graceful Shutdown](https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/html/web.html#web.graceful-shutdown)에 대한 실습 코드입니다.

자세한 설명과 프로젝트를 실행하며 확인해야 부분들은 [첨부링크](https://velog.io/@dongvelop/Springboot-Graceful-Shutdown)를 통해 참고하실 수 있습니다.

<br/>

## Requirements
- JDK 17 or higher

<br/>

## Check Points
아래 나열한 부분들은 모두 API로 요청이 들어왔을 때, 30초간 sleep 상태로 들어갔을 때 종료 요청을 보내는 상황을 말합니다.
- **Graceful Shutdown 적용 전**
  - 실행중인 프로세스를 SIGKILL(`kill -9`)로 종료시키기
  - 실행중인 프로세스를 SIGTERM(`kill -15`)로 종료시키기
- **Graceful Shutdown 적용 후**
  - 실행중인 프로세스를 SIGKILL(`kill -9`)로 종료시키기
  - 실행중인 프로세스를 SIGTERM(`kill -15`)로 종료시키기
- **예외 상황 찾아보기**
  - 하필 실행중이던 요청에서 데드락이 발생한다면? (`Shutdown Lifecycle` 지정)
  - `Shutdown Lifecycle`보다 실행중인 요청의 작업 시간이 더 길 경우에는?
  - 중지 스크립트 이후에 실행 스크립트가 바로 실행된다면 `Shutdown Lifecycle`에는 종료되지 않으니, 애플리케이션이 충돌나지 않을까? 
  - `블루그린 배포 방식을 이용`하거나 `서버를 다중화` 해놓았다면 애플리케이션 종료를 신경쓰지 않아도 될까?
