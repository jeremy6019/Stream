package com.daum.jeremy6019.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class ReduceMain1 {

	public static void main(String[] args) {
	    
		String[] ar = 
	    	{"SES", "핑클", "원더걸스", 
	    	"소녀시대", "레드벨벳", "트와이스",
	    	"itzy","소녀시대"};
	    //배열을 이용해서 Stream생성 
		Stream<String> stream = 
				Arrays.stream(ar);
		//중복 제거
/*		
		stream.distinct().forEach(
				name -> System.out.println(name));
*/	
/*		
		stream.limit(2).forEach(
				name -> System.out.println(name));
        
		stream.skip(2).forEach(
				name -> System.out.println(name));
*/
		
		int len = ar.length/3 + 1;
		for(int i=0; i<len; i+=1) {
			Stream<String> imsi = 
					Arrays.stream(ar);
			imsi.skip(i*3).limit(3).
			        forEach(name -> 
			        System.out.println(name));	
			try {
			    Thread.sleep(3000);
			} catch(Exception e) {}
	    }
		
		
	}

}
