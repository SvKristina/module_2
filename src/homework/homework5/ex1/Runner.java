package homework.homework5.ex1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class Runner {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor <Bank> bankConstructor = Bank.class.getDeclaredConstructor(BigDecimal.class);
        bankConstructor.setAccessible(true);
        Bank bank = bankConstructor.newInstance(new BigDecimal(1500));

        Constructor <Thief> thiefConstructor = Thief.class.getDeclaredConstructor();
        thiefConstructor.setAccessible(true);
        Thief thief = thiefConstructor.newInstance();

        Method stealMoneyMethod = Thief.class.getDeclaredMethod("stealMoney", Bank.class);
        stealMoneyMethod.setAccessible(true);
        stealMoneyMethod.invoke(thief, bank);

        System.out.println(thief);
        System.out.println(bank);
    }
}
