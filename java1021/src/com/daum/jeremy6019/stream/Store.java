package com.daum.jeremy6019.stream;

public class Store {
    //가게번호, 이름, 댓글 수를 저장할 변수 
	private int fcnum; 
	private String fcname;
	private int replyCnt;
	private String address;
	
	
	public Store() {
		super();
	}
	
	public Store(int fcnum, String fcname, int replyCnt, String address) {
		super();
		this.fcnum = fcnum;
		this.fcname = fcname;
		this.replyCnt = replyCnt;
		this.address = address;
	}
	public int getFcnum() {
		return fcnum;
	}
	public void setFcnum(int fcnum) {
		this.fcnum = fcnum;
	}
	public String getFcname() {
		return fcname;
	}
	public void setFcname(String fcname) {
		this.fcname = fcname;
	}
	public int getReplyCnt() {
		return replyCnt;
	}
	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Store [fcnum=" + fcnum + ", fcname=" + fcname + ", replyCnt=" + replyCnt + ", address=" + address + "]";
	}
	
	
	
}
