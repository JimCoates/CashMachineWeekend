package rocks.zipcode.atm.bank;

import rocks.zipcode.atm.ActionResult;

import java.util.HashMap;
import java.util.Map;

import static rocks.zipcode.atm.bank.AlertBox.*;

/**
 * @author ZipCodeWilmington
 */
public class Bank {

    private Map<Integer, Account> accounts = new HashMap<>();

    public Bank() {
        accounts.put(1000, new BasicAccount(new AccountData(
                1000, "Example 1", "example1@gmail.com", 500.00
        )));

        accounts.put(2000, new BasicAccount(new AccountData(
                2000, "Example 2", "example2@gmail.com", 200.00
        )));

        accounts.put(3000, new PremiumAccount(new AccountData(
                3000, "Example 3", "example1@gmail.com", 300.00
        )));

        accounts.put(4000, new PremiumAccount(new AccountData(
                4000, "Example 4", "example2@gmail.com", 400.00
        )));
    }

    public ActionResult<AccountData> getAccountById(int id) {
        Account account = accounts.get(id);

        if (account != null) {
            return ActionResult.success(account.getAccountData());
        } else {
            return ActionResult.fail("No account with id: " + id + "\nTry account 1000 or 2000");
        }
    }

    public ActionResult<AccountData> deposit(AccountData accountData, Double amount) {
        Account account = accounts.get(accountData.getId());
        account.deposit(amount);

        return ActionResult.success(account.getAccountData());
    }

    public ActionResult<AccountData> withdraw(AccountData accountData, Double amount) {
        Account account = accounts.get(accountData.getId());
        boolean ok = account.withdraw(amount);

        if (ok) {
            return ActionResult.success(account.getAccountData());
        } else {
            AlertBox.display("Your account is overdrawn", "Please deposit additional funds or lower your withdrawl amount");
            return ActionResult.fail("Withdraw failed: " + amount + ". Account has: " + account.getBalance());

        }
    }
}
