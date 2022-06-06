import com.company.Account;
import com.company.CheckingAccount;
import com.company.CreditAccount;
import com.company.SavingsAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    @DisplayName("Savings set balance test")
    public void setSavingsSuccess (){
        Account savings = new SavingsAccount();
        savings.setBalance(10_000);

        Assertions.assertEquals(10_000, 10_000);
    }

    @Test
    @DisplayName("Checking set balance test")
    public void setCheckingSuccess (){
        Account checking = new CheckingAccount();
        checking.setBalance(2000);

        Assertions.assertEquals(2000, checking.getBalance());
    }

    @Test
    @DisplayName("Paying from credit test")
    public void payingSuccessfulTest() {
        Account credit = new CreditAccount();
        int payment = 1000;

        credit.pay(payment);

        Assertions.assertEquals(-payment, credit.getBalance());
    }

    @Test
    @DisplayName("Adding money to credit too much money exception")
    public void addingTooMuchMoneyToCreditTest() {
        Account credit = new CreditAccount();
        int money = 450;
        try {
            credit.pay(400);
            credit.addMoney(money);
            Assertions.fail("Expected CreditAccountException");
        } catch (CreditAccount.CreditAccountException thrown) {
        Assertions.assertNotEquals("", thrown.getMessage());
        }
    }

    @Test
    @DisplayName("Credit transfer to checking")
    public void transferFromCreditToCheckingTest() throws CreditAccount.CreditAccountException {
        Account credit = new CreditAccount();
        Account checking = new CheckingAccount();
        checking.setBalance(2000);

        credit.transfer(checking, 100);

        Assertions.assertEquals(2100, checking.getBalance());
        Assertions.assertEquals(-100,credit.getBalance());
    }
}
