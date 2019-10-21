package definition;

public class Stream {

/*
  
 **Java1.8부터의 스트림 
1.java.io패키지에서 다루던 입출력 관련 스트림  
 =>외부와 통신을 하기 위해서 만든 통로 
 =>입출력 스트림과 바이트 또는 문자단위 스트림을 분류해서 사용 
 
2. java.util.stream 패키지에서 다루는 스트림 
=>데이터의 집합을 효율적으로 다루기 위해서 JDK1.8추가 된 API 
데이터의 집합: 스트림을 시행하는 기준 
=>기존 API에서는 Collection의 데이터를 다루고자 하는 경우에 반복문을 만들어서 
데이터를 하나씩 꺼낸후 작업을 수행하는 메소드에 대입하는 구조입니다. 
=>stream api에서는 데이터를 꺼내서 작업을 수행하는 코드를 하나로 묶어서 사용할 수 
있도록 해줍니다. 

ex)기존 컬렉션을 다루는 방식과의 차이점을 확인하기 위한 코드 
StreamMain1 


** 스트림의 특징 
1. 스트림은 데이터의 원본을 변경하지 않습니다. 
중간결과를 배열이나 리스트를 이용해서 저장할 수는 있습니다. 

2. 스트림은 일회용
=>한번 사용하고 나면 다음에 사용할 때는 재생성을 해서 사용 

3. 스트림은 내부적으로 반복문을 만들어서 처리 
		
4.다양한 중간연산(데이터 전처리 - 변환, 필터링, 정렬)과 최종연산(집계 - 반복수행,
개수, 평균,합계, 최대,최소)을 제공 

5. 지연된 연산 
=>중간 연산의 경우 호출할 때 수행하는 것이 아니고 최종연산을 하기 직전에 수행 

6.병렬 처리를 쉽게 구현 

**스트림의 종류 
Stream: Generic사용, intStream, LongStream, DoubleStream  

** 스트림 생성 
1.컬렉션을 이용: stream()이라는 메소드만 호출하면 리턴 

2.배열을 이용: Arrays.stream(배열) 

3.랜덤한 스트림 생성:Random.doubles(), Random.int(), Random.longs()

4.정수 범위를 이용한 생성: IntStream.range(int, int), LongStream.range(long,
 long) 
 
5.파일 경로를 이용한 생성: Files.list(Path)  

** 중간 연산 
=>데이터 전처리를 위한 연산 
=>데이터를 줄인다고 해서 Reduction 이라고도 합니다. 
(Map - Reduce라고 할 때 Reduce)
=>변환, 필터링, 정렬, 그룹화 등이 여기에 해당됩니다. 
=>중간 연산 매소드는 여러 번 연속해서 사용가능 
=>최종 연산 메소드가 나와야 결과는 확인이 가능 

1.필터링 
1)skip(long n): n개만큼 건너뛰는 메소드  
2)limit(long n):n개만큼만 추출하는 메소드 
3)distinct(): 중복을 제거하는 메소드인데 equals메소드륽 이용 
4)filter(매개변수가 1개이고 boolean을 리턴하는 람다식):람다식에 모든 데이터 
를 하나씩 대입해서 true가 리턴되는 데이터만 추출 

 ex1) 필터링 관련 메소드 사용 
 reduceMain1 참고 
 
ex2) DTO클래스를 생성해서 스트림의 필터링 메소드 사용 
=>DTO클래스생성(Store) 

=>main메소드를 소유한 클래스를 생성해서 테스트 
filter메소드의 매개변수는 매개변수가 1개이고 boolean을 리턴하는 람다식 
(매개변수이름) ->{
    작업 
    return true 또는 false;
}

매개변수는 스트림의 요소가 순서대로 대입됩니다. 

StoreMain클래스 참고 

=>데이터 정렬 (sort)
데이터를 정렬을 하려면 크기 비교가 가능해야 합니다. 
>,>=,<,<=와 같은 연산자를 이용해서 비교가능하거나 뺄셈을 할 수 있어야 합니다. 
숫자데이터는 크기 비교도 가능하고 뺄셈도 가능하기 때문에 정렬을 할 수 있습니다. 

숫자 이외의 데이터는 크기 비교연산이나 뺄셈이 안되기 때문에 정렬이 안됩니다. 
프로그래밍언어의 종류에 따라 되는 경우도 있습니다. 

숫자가 아닌 경우는 크기 비교를 할수 있는 메소드를 만들어 주어야 합니다. 
java에서는 클래스 안에 Comparable인터페이스를 구현하고 int compareTo(<T>
other)라는 메소드를 오버라이딩해서 크기 비교를 할 수 있도록 할 수 있습니다. 
이 메소드를 오버라이딩할 때는 양수가 리턴되면 비교하는 객체가 크다는 의미이고 
음수를 리턴하면 매개변수로 대입된 비교당하는 객체가 크다라는 의미입니다. 

Comparator인터페이스를 구현한 클래스를 생성하고 메소드를 구현해 주면 됩니다. 
이 때 메소드는 매개변수가 2개이고 양수를 리턴하면 첫번째 매개변수로 대입된 데이터가
크다는 의미이고 음수를 리턴하면 두번째 데이터가 크다는 의미입니다. 

Stream에서 Comparable인터페이스를 implements한 객체인 경우에는 sorted()를 
호출하면 오름차순 정렬을 해주고 매개변수로 Comparator.reversOrder()를 대입하면 내림
차순 정렬을 해줍니다. 

Comparable인터페이스를 implements하지 않은 객체의 경우에는 sorted메소드에 
Comparator인터페이스를 구현한 객체를 대입해야 합니다. 

ex3)스트림을 이용한 정렬 
실습을 위해 사용할 DTO클래스를 생성 
- 번호: 정수로 num 
- 이름: 문자열로 name 
- 성별:문자열로 남자 또는 여자 갖는데 gender(이렇게 특정한 값만을 갖는 자료형
을 범주형이라고도 합니다.
- 점수: 정수로 score 

Exception in thread "main" java.lang.ClassCastException: com.daum.jeremy6019.stream.
Student cannot be cast to java.lang.Comparable
=>이런 형태의 예외 메시지가 발생하면 형 변환 예외 메세지인데 가장 마지막에 나온 
인터페이스를 구현하지 않았다는 에러메세지 
 package com.daum.jeremy6019.stream;

public class Student implements Comparable{

	private int num;
	private String name;
	private String gender; 
	private int score;
		
	public Student() {
		super();		
	}
	
	public Student(int num, String name, String gender, int score) {
		super();
		this.num = num;
		this.name = name;
		this.gender = gender;
		this.score = score;
	}


	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	} 
	
	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", gender=" + gender + ", score=" + score + "]";
	}

	@Override
	public int compareTo(Object o) {
        //매개변수는 자신의 자료형으로 형 변환해서 사용 
		Student other = (Student)o;
		
	//	return other.score - this.score;   //숫자기준 
		return this.name.compareTo(other.name);   //문자기준 
	}
	
}

=>단순하게 Comparable인터페이스를 구현하는 형태를 이용하는 방법은 1가지 
기준으로만 정렬이 가능합니다. 
동적으로 정렬 기준을 변경하려면 Comparable 인터페이스를 이용하는 것이 아니고 
sorted()메소드에 정렬기준으로 동적으로 대입하면 됩니다. 

하나의 방법은 Comparator.comparing(클래스이름::비교할메소드 이름)을 대입하고 
내림차순으로 하고자 하면 뒤에 .reversed()를 연속해서 호출 
동일한 값일때 다른기준으로 추가하고자 하면 .thenComparing(클래스이름::메소드이름)을 
호출하면 됩니다. 
이 때 연속해서 reversed()를 적용할 수 없습니다. 
이 때는 thenComparing에 다시 Comparator.comparing()을 만들어서 대입해야 합니다. 

다른 하나의 방법은 Comparator인터페이스를 구현한 객체를 직접 대입하는 것입니다. 
public class ReduceMain3 {

ReduceMain3참고 

=>map중간 연산 
mapping의 약자로 데이터를 변환해주는 연산 
mapTo자료형(메소드)를 설저하면 원래의 데이터가 메소드가 반환하는 값으로 변경됩니다. 
만일 Student를score값만 사용하는 경우가 발생했을 떄 student에서 score만 꺼내서 
다른 배열이나 List에 저장하는 것은 자원의 낭비가 될 수 있습니다 
필요하다면 Student의 데이터 중에서 score에만 접근해서 작업을 수행하도록 해주면 
메모리 낭비를 줄일 수 있습니다. 

mapToInt(student::getScore) 

 ReduceMain4참고 

=>중간 연산에서 중요한 연산 - 데이터 가공 또는 전처리 
map: 데이터 변환 
filter: 데이터를 골라내는 것 
sort:데이터를 정렬하는 것 
skip:데이터를 건너뛰는 것 
limit:원하는 개수만큼 골라내는 것 

중간 연산은 연속해서 수행이 가능합니다. 
일반적으로 skip과 limit가 마지막이 될 가능성이 높습니다. 

** 최종 연산 
=>중간 연산된 결과를 가지고 결과를 만들어 내는 연산 
=> 한 번만 수행가능 
1.종류 
1)매칭이 되는지 확인해 주는 메소드 
boolean allMatch(함수): 함수를 수행한 결과가 모두 true인 경우 true  
boolean anyMatch(함수) "함수를 수행한 결과 중 1개라도 true라면 true 
boolean noneMatch(함수) : 함수를 수행한 결과중 1개라도 true라면 false 

2)집계관련 메소드 
long count() 
OptionalXXX findFirst(): 첫번째 데이터 
OptionalXXX max() : 가장 큰 데이터 
OptionalXXX min(): 가장 작은 데이터 
OptionalDouble average() : 평균 
OptionalXXX reduce(): 함수를 수행한 결과 
int, long, double sum(): 합계   

3)하나씩 순차적으로 함수를 수행 
void forEach(매개변수가 1개인 함수)

4) 결과를 다른 형태로 저장 
R collect()

2.Optional
=>nullPointException의 발생을 줄이기 위해서 등장한 자료형 
=>참조형은 null을 저장할 수 있는데 참조형변수가  자신의 속성이나 메소드를
호출하는 문장을 사용하면 컴파일  할때는 문법만 검사하기때문에 참조형 변수에 
null이 있더라도 에러가 발생하지 않고 실행할 때 문제가 생깁니다. 
프로그래밍에서는 이러한 예외를 방지하기 위해서 참조형데이터의 경우는 null
체크를 해서 사용했습니다. 
=>애초에 null을 저장할 수 있는 참조형과 null을 저장할 수 없는 자료형을 구분해서 
사용하기 위해서 등장한 것이 Optional입니다.  
 =>Optional타입에서 데이터를 가져올 때는 아래 메소드 중에 하나를 사용 
 T get():무조건 가져오는데 null이면 예외 발생 
 T orElse(T 기본값): null이면 기본값으로 설정 
 boolean isPresent(): null이면 false null이 아니면 true 
 
=>swift와 kotlin에서 데이터 타입부분이 가장 크게 바뀐 부분 

3.forEach 
=>스트림의 모든 요소에게 매개변수로 대입된 함수를 실행시키는 최종연산입니다. 
=>매개변수로 대입된 함수는 1개의 매개변수를 가지고 리턴을 하지 않아야 합니다. 
=>이때 대입되는 매개변수는 스트림의 각 요소들이 순차적으로 대입됩니다. 
=>함수는 Consumer 인터페이스를 implements한 클래스의 객체를 대입해도 되고 
(자료형 매개변수) -> {수행할 내용;} 형태의 람다식을 대입해도 됩니다. 
람다를 사용할 때 매개변수의 자료형은 생략이 가능하고 매개변수가 1개인 경우는 
()을 생략하고 매개변수이름만 기재해도 됩니다. 
수행할 내용을 작성할 때 수행할 내용이 1줄이면 {}를 생략해도 되고 ;도 생략이 가능
합니다. 

MapReduceMain1	참고 

=>안드로이드와 IOS의 swift에서 람다를 많이 사용하기때문에 람다를 읽을 수 있어야 합니다.
안드로이드는 이벤트처리를 대부분 람다를 이용해서 작성합니다.
swift에서는 콜백메소드들을 람다로 작성하는 경우가 종종있습니다. 

 ip:포트번호/데이터베이스이름 
 
  아이디, 비밀번호 
  
  
  
  
  
  
  

 */
}
