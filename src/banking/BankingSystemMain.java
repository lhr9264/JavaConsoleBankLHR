package banking;

import java.util.ArrayList;
import java.util.Scanner;

class Bank {
	String accinfo;
	String name;
	int money;
	public Bank(String accinfo, String name, int money) {
		this.accinfo = accinfo;
		this.name = name;
		this.money = money;
	}
}


public class BankingSystemMain {

	public static void showMenu() {
		System.out.println("-----Menu-----");
		System.out.println("1.계좌개설");
		System.out.println("2.입  금");
		System.out.println("3.출  금");
		System.out.println("4.계좌정보출력");
		System.out.println("5.프로그램종료");
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ShowAccInfoHandler handler = 
				new ShowAccInfoHandler(100);
		
		while(true) {
			showMenu
		}
		
	}////main 끝
	

}////class 끝

class ShowAccInfoHandler {
	ArrayList<Bank> lists;
	
	public ShowAccInfoHandler(int num) {
		lists = new ArrayList<Bank>();
	}
	
	public void makeAccount(int choice) {
		Scanner scan = new Scanner(System.in);
		String bAcc,bname,
	}
}
