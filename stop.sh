# 앱 이름
APP_NAME=GracefulshutdownApplication

# 프로세스 아이디
APP_PID=$(ps -ef | grep $APP_NAME | awk '{print $2}' | head -n 1)

if [ -z "$APP_PID" ]; then
    # PID가 없으면~ 실행중이지 않음을 알려주기
    echo "GracefulshutdownApplication is not started"
else
	  echo "GracefulshutdownApplication stop processId[$APP_PID]"
    kill -15 $APP_PID
fi

echo "finally execute echo!"
