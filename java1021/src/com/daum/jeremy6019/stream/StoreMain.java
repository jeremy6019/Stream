package com.daum.jeremy6019.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class StoreMain {

	public static void main(String[] args) {
		//Store객체 4개를 저장할 수 있는 배열이 생성 		
		Store [] ar = new Store[4];
		ar[0] = new Store(1, "광저우", 48, "서울시 강동구 역삼동");
		ar[1] = new Store(2, "샹하이", 23, "강남구 역삼동");
		ar[2] = new Store(3, "시앤", 75, "강동구 둔촌동");
		ar[3] = new Store(4, "베이징", 17, "강남구 논현동");
		//배열을 가지고 스트림 생성 
		Stream<Store> stream = 
				Arrays.stream(ar);
		
		stream.filter((store)->{
//			return store.getReplyCnt() < 30;
//			return store.getFcnum() > 1;
//			return store.getAddress().substring(0,3).equals("강동구");
//			return store.getAddress().substring(4,7).equals("둔촌동");
			// 공백을 기준으로 분할 , 분류로 사용할 것들은 
			// 직접 입력 않하게 하는 것이 좋음 
	        String [] ad = 
	        		store.getAddress().split(" ")	;
	        
	        if(ad[1].equals("역삼동")) {
	        	return true;
	        }	        
	        return false;	        
/*	       for(String imsi : ad) {
	    	        if(imsi.equals("역삼동")) {
	    	        	return true;
	                }
	        }
	        return false;
*/
	        
		}).forEach(
				store -> System.out.println(store));
		
		
	}
	
	
}
