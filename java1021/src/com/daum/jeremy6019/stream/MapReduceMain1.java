package com.daum.jeremy6019.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class MapReduceMain1 {

	public static void main(String[] args) {
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
			    Stream<Student> stream = 
				         Arrays.stream(students);
			    
			    //Map-Reduce Programming 
			    stream.filter((student) ->{
			    	return student.getGender()
			    			.equals("여자");
			    }).forEach((student)->{
			    	System.out.println(student);
	            });
			    

	}

}
