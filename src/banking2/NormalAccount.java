package banking2;

public class NormalAccount extends Account {
	
    private double interestRate;

    public NormalAccount(String accNumber, String accName, int balance, double interestRate) {
        super(accNumber, accName, balance);
        this.interestRate = interestRate / 100;
    }
    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        applyInterest();
    }
    private void applyInterest() {
        double interestAmount = balance * interestRate;
        balance += interestAmount;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n기본이자>" + Math.round(interestRate * 100) + "%";
    }
}