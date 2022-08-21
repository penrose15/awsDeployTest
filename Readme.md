### gitActions를 이용한 aws 자동배포

간단한 회원 관리 시스템을 gitActions를 이용하여 aws서버에 자동배포 하도록 만듦

#### githubActions를 통한 배포 flow

![image](https://user-images.githubusercontent.com/96187152/185793536-8387bc22-7d32-442e-a9e8-2ed1d6876a16.png)


사전에 해야하는 것들

- S3 버킷 생성(+ 접근 설정)
- IAM 계정 사용시 권한 부여(S3FullAccess, CodeDeploy관련 설정)
- codeDeploy Agent 설치
- ec2에 환경변수 전달을 위한 파라미터 설정

1. git actions생성(Java with gradle)
2. gradle.yml 추가
  - 만약 gradlew permission denied 에러시 
  - `- name: Run chmod to make gradlew executable`
      `run: chmod +x ./gradlew` 추가
3. 시크릿 키 추가
4. gradle.yml에 시크릿 키 관련 코드 추가
5. S3에 압축파일 올라갔는지 확인

6. codeDeploy, codeDeploy group 생성
7. appspec.yml 추가
8. deploy.sh 추가
