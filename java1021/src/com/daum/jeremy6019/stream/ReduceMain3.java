package com.daum.jeremy6019.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class ReduceMain3 {

	public static void main(String[] args) {
		
		String[] ar = 
			{"C&C++", "Java", "C#",
			    "JavaScript", "Python", "R",
		     	"Kotlin", "Swift", "SQL",
                "Haskell", "Closure", "Scala",
                "Ruby", "Php"
            };
		//배열을 가지고 스트림을 생성 
		Stream <String> stream =
				Arrays.stream(ar);
		//String클래스는 Comparable인터페이스를 
		//implements해서 정렬이 가능 
		/*
		stream.sorted().forEach(
				lang -> System.out.println(lang));
		*/
		
		//내림차순 정렬 
		/*
		stream.sorted(
				Comparator.reverseOrder()).forEach(
				lang -> System.out.println(lang));
		*/
		
		//Student의 배열을 생성 
		Student [] students = 
			{
				new Student(1, "아이린", "여자", 90),
				new Student(2, "김기범", "남자", 98),
				new Student(3, "정용진", "남자", 90),
				new Student(4, "이현아", "여자", 84),
				new Student(5, "조정린", "여자", 78),
				new Student(6, "장하성", "남자", 87),
				new Student(7, "박하선", "여자", 74)
			};
		//배열을 스트림으로 생성 
	    Stream<Student> st = 
		         Arrays.stream(students);
	    // 이 형태를 예외없이 사용하고자 하면 
	    //student클래스에 Comparable 인터페이스 구현
/*	    st.sorted().forEach(
	    		student -> 
	            System.out.println(student));
*/	
	    //Comparator 인터페이스를 이용한 정렬 
	    //score의 내림차순 정렬 
	    //.reversed()를 생략하면 오름차순 
	    //score가 같으면 이름의 오름차순 
    /*
	    st.sorted(Comparator.comparing(
	    		Student::getScore).reversed()
	    		.thenComparing(Student::getName))
	    .forEach(
	    		student -> 
	            System.out.println(student));
		*/
	    
	    //Comparator객체 직접 생성 
	    Comparator<Student> comp = 
	    		new Comparator<Student>() {
					@Override
					public int compare(
							Student o1, Student o2) {		
						if(o1.getScore() > o2.getScore()) {
							return 1;
						} else if(o1.getScore() == o2.getScore()) {
							return o2.getName().compareTo(o1.getName());
						} else
						return -1;
					}
	    };
	    
	    st.sorted(comp).forEach(
	    		student -> System.out.println(
	    				student));
		
	    
	    
	}

}
