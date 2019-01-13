package com.hailintang.demo;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	private String _name;
	private Vector _rentals = new Vector();
	public Customer(String _name) {
		super();
		this._name = _name;
	}
	
	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}

	public String getName() {
		return _name;
	}
	
	public String statement() {
		double totalAmount = 0;//总金额
		int frequentRenterPoints = 0;//积分点
		Enumeration rentals = _rentals.elements();//用户所有租赁列表
		String result = "Rental record for "+getName()+"\n";
		//循环遍历租赁影片，计算租赁金额
		while(rentals.hasMoreElements()) {
			double thisAmount = 0;//当前单个租赁金额
			Rental each = (Rental) rentals.nextElement();
			//租赁计费规则
			switch (each.get_movie().get_priceCode()) {
			case Movie.REGULAR://普通片，2元一天，超过2天的部分按1.5一天算
				thisAmount+=2;
				if(each.get_daysRented()>2) {
					thisAmount += (each.get_daysRented()-2)*1.5;
				}
				break;
			case Movie.NEW_RELEASE://新片，3元一天
				thisAmount+= each.get_daysRented()*3;
				break;
			case Movie.CHILDRENS://儿童片，1.5元一天；超过三天的部分按1.5元一天算
				thisAmount+=1.5;
				if(each.get_daysRented()>3) {
					thisAmount+=(each.get_daysRented()-3)*1.5;
					break;
				}
			}
			//每借一张片，加一个积分点
			frequentRenterPoints++;
			//如果是新片，并且租赁日期超过1天；就额外增加一个积分点
			if((each.get_movie().get_priceCode()==Movie.NEW_RELEASE)&&each.get_daysRented()>1) {
				frequentRenterPoints++;
			}
			//show figures for this rental
			result +="\t"+each.get_movie().get_title()+"\t"+String.valueOf(thisAmount)+"\n";
			totalAmount+=thisAmount;
		}
		//add footer lines
		result +="Amount owed is "+String.valueOf(totalAmount)+"\n";
		result +="You earned "+String.valueOf(frequentRenterPoints)+" frequent renter points";
		return result;
	}
}
