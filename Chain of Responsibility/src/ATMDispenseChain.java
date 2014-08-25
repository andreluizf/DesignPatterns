import java.util.Scanner;


public class ATMDispenseChain {
	private DispenseChain c1;
	 
    public ATMDispenseChain() {
        // initialize the chain
        this.c1 = new Dollar100Dispenser();
        DispenseChain c2 = new Dollar50Dispenser();
        DispenseChain c3 = new Dollar20Dispenser();
        DispenseChain c4 = new Dollar10Dispenser();
        DispenseChain c5 = new Dollar2Dispenser();

        // set the chain of responsibility
        c1.setNextChain(c2);
        c2.setNextChain(c3);
        c3.setNextChain(c4);
        c4.setNextChain(c5);
    }
 
    public static void main(String[] args) {
        ATMDispenseChain atmDispenser = new ATMDispenseChain();
        while (true) {
            int amount = 0;
            System.out.println("Enter amount to dispense");
            Scanner input = new Scanner(System.in);
            amount = input.nextInt();
            if (amount % 2 != 0) {
                System.out.println("Amount should be in multiple of 2s.");
                return;
            }
            // process the request
            atmDispenser.c1.dispense(new Currency(amount));
        }
 
    }
}
