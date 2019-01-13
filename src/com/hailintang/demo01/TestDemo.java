package com.hailintang.demo01;

public class TestDemo {
	public static void main(String[] args) {
		Movie movie1 = new Movie("福尔摩斯",0);//普通片
        Movie movie2 = new Movie("雷神   ",1);//新片
        Movie movie3 = new Movie("熊出没 ",2);//儿童片
        Rental ren1 = new Rental(movie1,8);//2+(8-2)*1.5=11
        Rental ren2 = new Rental(movie2,3);//3*3
        Rental ren3 = new Rental(movie3,5);//1.5+（5-3）*1.5=4.5
        Customer cus = new Customer("hailintang");
        cus.addRental(ren1);
        cus.addRental(ren2);
        cus.addRental(ren3);
        System.out.println(cus.statement());
        
        
	}
}
