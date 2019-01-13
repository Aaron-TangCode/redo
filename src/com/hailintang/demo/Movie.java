package com.hailintang.demo;

public class Movie {
	public static final int CHILDRENS = 2;//儿童片
	public static final int REGULAR = 0;//普通片
	public static final int NEW_RELEASE = 1;//新片
	
	private String _title;//影片名
	private int _priceCode;//价格码
	
	public Movie(String title,int priceCode) {
		_title = title;
		_priceCode = priceCode;
	}
	public String get_title() {
		return _title;
	}
	
	public int get_priceCode() {
		return _priceCode;
	}
	public void set_priceCode(int _priceCode) {
		this._priceCode = _priceCode;
	}
	
	
}
