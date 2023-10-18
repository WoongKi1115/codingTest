# CodingTest
## 1. 알고리즘 문제
### 실행 방법
1. intellij를 활용해서 algo 프로젝트를 엽니다.
2. src 폴더 안에 LookAndSay 또는 LookAndSayDP를 실행시킵니다.
3. 테스트할 값을 입력해주고 결과를 확인합니다.


## 2. API 만들기
### 실행 방법
1. mysql에 sakak 이라는 db를 생성합니다.
2. 이메일에 동봉된 application.yml을 프로젝트 안에 src/main/resources 안에 넣어줍니다.
3. application.yml에서 username과 password를 가입한 것과 동일하게 변경합니다.
4. intellij를 활용해서 restfulApi 프로젝트를 엽니다.
5. 빌드가 완료되면 restfulapiApplication을 실행시킵니다.
6. postman을 활용해서 api를 테스트합니다.
  5-1. database에 data를 삽입하기 위해 post 방식으로 http://localhost:8071/foods로 요청을 보냅니다.
  5-2. 요청이 완료되면 데이터 저장 완료 결과가 출력됩니다.
  5-3. database에서 필요한 데이터를 출력하기 위해 post 방식으로 http://localhost:8071/foods/nutritions로 요청을 보냅니다.
       요청을 보낼 때 body에 데이터를 담아주어야 하는데 postman 안에 body -> raw를 입력하고 아래의 data를 넣어줍니다.
  ```
   {
    "foodName":"더덕구이",
    "researchYear": "2019",
    "makerName": "전국(대표)",
    "foodCode":"D000010"
  }
```
  5-4. 요청이 성공하면 필요한 데이터가 출력됩니다.

## 참고
#### memoization(알고리즘)
https://loosie.tistory.com/150

#### poi(엑셀 파일 읽기)
https://dailylifecoding.tistory.com/entry/apache-POI-%EA%B0%84%EB%8B%A8-%EC%82%AC%EC%9A%A9%EB%B2%95-1

#### restfulApi
https://velog.io/@seokkitdo/Network-REST%EB%9E%80-REST-API%EB%9E%80-RESTful%EC%9D%B4%EB%9E%80
