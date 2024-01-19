package banking;

public class Account {
	private String accinfo;
	private String name;
	private int money;
	private int interestRate;
	public Account(String accinfo, String name, int money, int interestRate) {
		this.accinfo = accinfo;
		this.name = name;
		this.money = money;
		this.interestRate = interestRate;
	}
	public String getAccinfo() {
		return accinfo;
	}
	public void setAccinfo(String accinfo) {
		this.accinfo = accinfo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public int getInterestRate() {
		return interestRate;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	public void deposit(int amount) {
		this.money += amount;
	}
	public void withdraw(int amount) {
		this.money -= amount;
	}
	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}
	@Override
	public String toString() {
		return "계좌번호> " + accinfo +"\n"+ "고객이름> " + name +"\n"+ "총금액> " + money
				+"\n"+"기본이자>"+interestRate;
	}
}
