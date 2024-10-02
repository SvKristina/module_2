package homework.homework5.ex1;

import java.lang.reflect.Field;
import java.math.BigDecimal;

/**
 * Вор
 */
public class Thief {
    private BigDecimal money;

    private Thief() {
        this.money = BigDecimal.ZERO;
    }

    private void stealMoney(Bank bank) throws NoSuchFieldException, IllegalAccessException {
        Field fieldMoneyBank = Bank.class.getDeclaredField("money");
        fieldMoneyBank.setAccessible(true);
        BigDecimal bankMoney = (BigDecimal) fieldMoneyBank.get(bank);
        this.money = this.money.add(bankMoney);
        fieldMoneyBank.set(bank, BigDecimal.ZERO);
    }

    @Override
    public String toString() {
        return "Thief{" +
                "money=" + money +
                '}';
    }
}
