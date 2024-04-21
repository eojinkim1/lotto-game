package step1;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class PurchaseAmount {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

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
    public void myLotto(){
        int randomLottoNumber[] = new int[6];
        int quantity = buyLotto();

        System.out.println(quantity + "개를 구매했습니다.");
        for (int i = 0; i < quantity; i++) {
            for (int j = 0; j < randomLottoNumber.length; j++) {
                int lottoNumber = RANDOM.nextInt(45) + 1;
                randomLottoNumber[j] = lottoNumber;
                for (int k = 0; k < j; k++) {
                    if (randomLottoNumber[j] == randomLottoNumber[k]) {
                        j--;
                        break;
                    }
                }
            }
            System.out.println(Arrays.toString(randomLottoNumber));
        }
    }
}
