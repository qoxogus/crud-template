# crud-template

* 간단하게 구현해보고 싶은게 생겼을 때 사용할 (spring-data-jpa)CRUD Template 입니다.
  * CRUD 코드 작성 리소스 감소 목적


* Service, Repository를 규칙에 맞게 생성, 생성한 Service Layer 사용 시 별다른 작업 없이 CRUD 작업을 수행할 수 있습니다.
  * 표현 계층은 따로 생성 필요 (ex. Controller, DataFetcher)


* Generic 관련 정보
  * `Z` : entity class
  * `ID` : primary key type wrapper class
  * `R` : repository class


* Service Layer에 생성된 CRUD 로직은 재정의하여 사용할 수 있습니다.
