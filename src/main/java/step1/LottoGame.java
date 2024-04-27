package step1;

import java.util.*;

public class LottoGame {
    private static final Scanner SCANNER = new Scanner(System.in);

    private static int PAYMENT = 0;

    public static void main(String[] args) {
        LottoStore lottoStore = new LottoStore();

        while (true) {
            System.out.println("구입 금액을 입력해 주세요.");
            try {
                PAYMENT = Integer.parseInt(SCANNER.next());
                if (PAYMENT < 1000) {
                    throw new IllegalArgumentException("1000원 이상의 값을 입력해주세요");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("올바른 형식의 숫자를 입력하세요.");
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        List<Lotto> lottoList = lottoStore.sellLotto(PAYMENT);
        System.out.println(lottoList);

        while (true) {
            System.out.println("당첨 번호를 입력해주세요.");
//            try {
                String[] inputNumber = SCANNER.next().split(",");
                if (inputNumber.length != 6) {
                    System.out.println("숫자 생성 범위를 초과하였습니다.\n6개의 숫자를 입력해주세요.");
                    continue;
                }
//                break;
//            } catch (IllegalArgumentException e) {
//                System.out.println(e.getMessage());
//            }

            Set<LottoNumber> winningNumbers = new HashSet<>();
            for (String input : inputNumber) {
                int number = Integer.parseInt(input);
                LottoNumber lottoNumber = new LottoNumber(number);
                winningNumbers.add(lottoNumber);
            }
            Lotto winningLotto = new Lotto(winningNumbers);
//            System.out.println(winningLotto);

            System.out.println("보너스 번호를 입력하세요");
            int inputBonusNumber = SCANNER.nextInt();
            LottoNumber bonusNumber = new LottoNumber(inputBonusNumber);

            WinningNumber rank = new WinningNumber(winningLotto, bonusNumber);
            System.out.println("당첨통계");
            System.out.println("---");
            System.out.println("3개 일치 (5,000원) - " + "변수" + "개");
            System.out.println("4개 일치 (50,000원) - " + "변수" + "개");
            System.out.println("5개 일치 (1,500,000원) - " + "변수" + "개");
            System.out.println("5개 일치 (30,000,000원) - " + "변수" + "개");
            System.out.println("6개 일치 (2,000,000,000원) - " + "변수" + "개");
            System.out.println("총 수익률은 " + "" + "% 입니다.");
            break;
        }
    }
}

