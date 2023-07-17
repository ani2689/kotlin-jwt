# kotlin-jwt
⛓ `코틀린`과 `JWT`를 활용한 로그인 로직 구현하기

##### [🌱 인프런 강의](https://www.inflearn.com/course/%EC%BD%94%ED%8B%80%EB%A6%B0%EA%B3%BC-spring-security-jwt-%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85%EB%A7%8C%EB%93%A4%EA%B8%B0/dashboard)

---

<br>

### 🔔 질의응답
##### 궁금한 게 생기면 적고 생각해보기

<br>

#### 🔖 chapter 2-2
###### Q. 강사님은 Entity를 만들 때 LocalDate에 @Temporal(TemporalType.DATE) 어노테이션을 붙여도 잘 실행되었다. 그러나 내가 실행했을 때는 오류가 발생했다. 버전의 문제일까?

##### A. @Temporal(TemporalType.DATE) 어노테이션은 LocalDate에 사용할 때는 생략이 가능하다. 아마 사용하는 JDBC 드라이버가 달라서 그런 듯 하다!

###### Q. @Table 어노테이션은 그동안 테이블 이름만 작성하는 줄 알았는데, 아래처럼도 사용된다. 무슨 의미을 가지고 있는걸까?

```kotlin
    @Table(
        uniqueConstraints = [UniqueConstraint(name = "uk_member_login_id", columnNames = ["loginId"])]
    )
```

##### A. "uk_member_login_id" 라는 이름으로 loginId 컬럼의 고유 제약 조건(중복된 값 비허용)을 정의한다. 나중에 조건을 참조하거나 변경할 때 정의된 이름을 사용할 수 있다.
 
###### Q. 어떤 프로젝트에서는 JpaRepository를, 어떤 프로젝트에서는 CrudRepository를 상속받는다. 두 레포지토리는 어떤 차이점이 있을까?

##### A. 단순히 CRUD 작업만 한다면 CrudRepository를, 그에 더해 페이징이나 sort등의 기능을 사용한다면 JpaRepository를 사용한다.

<br>

#### 🔖 chapter 2-3
###### Q. 어노테이션을 만드는 이유는 뭘까?

###### Q. 아래 코드에 사용되는 어노테이션과 클래스는 무슨 의미를 가지고 있는걸까? 처음보는 문법도 정리해보자.
```kotlin
    @Target(AnnotationTarget.FIELD)
    @Retention(AnnotationRetention.RUNTIME)
    @MustBeDocumented
    @Constraint(validatedBy = [VaildEnumVaildator])
    annotation class VaildEnum(
        val message: String  = "Invalid enum value",
        val groups: Array<KClass<*>> = [],
        val payload: Array<KClass<out Payload>> = [],
        val enumClass: KClass<out Enum<*>>
    )

```

##### A. @Target은 어노테이션이 적용할 수 있는 타겟을 지정하는 어노테이션이다. 많은 종류가 있으나 이 코드에 적용된 AnnotationTarget.FIELD는 필드에 대한 어노테이션이라는 뜻이다. 

##### A. @Retention은 어노테이션의 유지기간을 정의한다. 이 코드에 적용된 AnnotationRetention.RUNTIME은 컴파일된 클래스파일에 포함되며 런타임에 사용할 수 있다고 정의한다. 리플렉션을 통해 실행 중 어노테이션 정보에 접근 할 수 있다. 

##### A. @MustBeDocumented는 Generated 문서에 해당 어노테이션도 포함될 수 있는지를 나타낸다. 

##### A. @Constraint은 제약 조건을 확인할 클래스를 직접 정의한다.

##### A. KClass는 코틀린에서 클래스의 런타임 메타데이터에 접근하기 위해 사용되는 클래스이다. 클래스에 대한 정보를 동적으로 얻는데에서 활용된다. KClass<*>는 코틀린의 런타임 메타데이터를 나타내는 클래스이며 <>안의 *은 와일드 카드타입으로 모든 타입을 허용한다는 뜻이다. out키워드는 공변성을 나타내며, out 뒤에 오는 클래스의 하위 클래스를 허용한다는 뜻이다.

###### Q. ConstraintValidator클래스는 어떤 역할을 하길래 상속받는걸까?

##### A. ConstraintValidator는 Bean Validation API에서 제공하는 인터페이스로 커스텀한 유효성 검사 로직을 작성할 수 있다. initialize 메서드는 초기화 로직을 실행하며, isValid 메서드는 유효성 검사 로직을 실행한다.

<br>

#### 🔖 chapter 2-4

###### Q. 데이터 클래스에서 \<T\>라고 선언하는 건 무슨 의미일까?

##### A. 데이터 클래스가 제네릭 타입 매개변수를 가진다는 뜻이다. 

