package com.daum.jeremy6019.stream;

import java.util.Arrays;
import java.util.stream.Stream;

//컬렉션의 다양한 접근 
public class StreamMain1 {

	public static void main(String[] args) {
	/*
		List<String> list =
				new LinkedList<>();
		list.add("조조");
		list.add("원소");
		list.add("손견");
		list.add("유비");
	*/
		String []  list = 
			{"조조","원소","손견", "유비", "원술"};
		
		//일반 반복문을 이용해서 접근 
		int i = 0 ;
		int len = list.length;
		while(i < len ) {
			//데이터를 가져오기 
			String item = list[i];
			//가져온 데이터를 가지고 작업 - 출력 
			System.out.printf("%s\n", item);
			//인덱스 변수 증감 
			i += 1; 			
		}
        System.out.println("=========================");
        
        //iterator(cursor -반복자 )
        //데이터를 가져온 위치에 대기하고 있다가 
        //다음 데이터를 찾아가는 방법 
        //배열은 사용못함
        /*
        int iterator = 
        		list.iterator();
        while(iterator.hasNext()) {
        	String next = iterator.next();
        			System.out.printf("%s\n", next);
        }
        */
        System.out.println("=========================");
        
        //위의 방법은 전에 사용하던 방식 
        //최근에는 위의 방식을 개선해서
        // fast Enumeration 제공 
        //언어에 따라서 Map도 이방식이 가능 
        for(String temp : list) {
        	System.out.printf("%s\n", temp);
        }
        
        System.out.println("=========================");
        
        //위의 문장을 조금 더 간결하게 작성 
        Stream <String> stream = 
        		Arrays.stream(list);
        
        stream.forEach(
        		name -> System.out.println(name));
                
		
		
	}

}
