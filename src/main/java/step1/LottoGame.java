package step1;

import java.util.Scanner;

public class LottoGame {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        LottoStore lottoStore = new LottoStore();
        WinningNumber winningNumber = new WinningNumber();

        while (true) {
            System.out.println("구입 금액을 입력해 주세요.");
            try {
                int payment = Integer.parseInt(SCANNER.next());
                System.out.println(lottoStore.sellLotto(payment));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            break;
        }
        while (true) {
            winningNumber.numberConfirm();
            break;
        }

        System.out.println("당첨통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + "변수" + "개");
        System.out.println("4개 일치 (50,000원) - " + "변수" + "개");
        System.out.println("5개 일치 (1,500,000원) - " + "변수" + "개");
        System.out.println("5개 일치 (30,000,000원) - " + "변수" + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + "변수" + "개");
        System.out.println("총 수익률은 " + "" + "% 입니다.");
    }
}

