package banking3;

public abstract class Account {
	String accNumber;
	String accName;
	int balance;
	
	public Account(String accNumber,String accName,int balance) {
		this.accNumber = accNumber;
		this.accName = accName;
		this.balance = balance;
	}
	public String getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	public void deposit(double amount) {
		this.balance += amount;
	}
	public void withdraw(int amount) {
		this.balance -= amount;
	}
	public void withdrawAll(int amount) {
		this.balance -= balance;
	}
	@Override
	public String toString() {
		return "계좌번호> " + accNumber +
				"\n고객이름> " + accName +
				"\n잔고> " + balance;
	}
}
