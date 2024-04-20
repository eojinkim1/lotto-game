package step1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PurchaseAmount {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int PRICE = 1_000;
    private int payment = 0;

    public int buyLotto() {
        while (true) {
            System.out.println("구입 금액을 입력해 주세요.");
            try {
                payment = Integer.parseInt(SCANNER.next());
                payment /= PRICE;
                if (payment >= 1) {
                    break;
                } else {
                    System.out.println("로또를 사기엔 돈이 부족합니다.");
                    System.out.println("로또 1장 = 1000원");
                }
            } catch (InputMismatchException | IllegalArgumentException e) {
                System.out.println("잘못된 입력입니다.");
            }
        }
        return payment;
    }
}
