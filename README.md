# kotlin-jwt
⛓ `코틀린`과 `JWT`를 활용한 로그인 로직 구현하기

##### [🌱 인프런 강의](https://www.inflearn.com/course/%EC%BD%94%ED%8B%80%EB%A6%B0%EA%B3%BC-spring-security-jwt-%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85%EB%A7%8C%EB%93%A4%EA%B8%B0/dashboard)

---

### 🔔 질의응답
##### 궁금한 게 생기면 적고 생각해보기

<br>

#### 🔖 chapter 2-2
###### Q. 강사님은 Entity를 만들 때 LocalDate에 @Temporal 어노테이션을 붙여도 잘 실행되었다. 그러나 내가 실행했을 때는 오류가 발생했다. 버전의 문제일까?

###### Q. @Table 어노테이션은 그동안 테이블 이름만 작성하는 줄 알았는데, 아래처럼도 사용된다. 무슨 뜻을 가지고 있는걸까?
```kotlin
@Table(
    uniqueConstraints = [UniqueConstraint(name = "uk_member_login_id", columnNames = ["loginId"])]
)
```

###### Q. 어떤 프로젝트에서는 JpaRepository를, 어떤 프로젝트에서는 CrudRepository를 상속받는다. 두 레포지토리는 어떤 차이점이 있을까?
