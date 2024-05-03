package step1;

import java.util.*;

public class LottoGame {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static int PAYMENT = 0;
    private static int PRICE = 1_000;

    public static void main(String[] args) {
        LottoStore lottoStore = new LottoStore();

        while (true) {
            System.out.println("구입 금액을 입력해 주세요.");
            try {
                PAYMENT = Integer.parseInt(SCANNER.next());
                if (PAYMENT < PRICE) {
                    throw new IllegalArgumentException("1000원 이상의 값을 입력해주세요");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("1000원 이상의 값을 입력해주세요");
            }
        }
        int quantity = PAYMENT / PRICE;
        System.out.println(quantity + "개를 구매했습니다.");
        List<Lotto> lottoList = lottoStore.sellLotto(PAYMENT);
        System.out.println(lottoList);

        while (true) {
            System.out.println("당첨 번호를 입력해주세요.");
            String[] inputNumber;
            Set<LottoNumber> winningNumbers = new HashSet<>();
            try {
                inputNumber = SCANNER.next().split(",");
                if (inputNumber.length != 6) {
                    System.out.println("잘못된 입력입니다.\n6개의 숫자를 입력해주세요.");
                    continue;
                }
                for (String input : inputNumber) {
                    int number = Integer.parseInt(input);
                    if (number < 1 || number > 45) {
                        throw new IllegalArgumentException("1부터 45 사이의 숫자를 입력해주세요.");
                    }
                    LottoNumber lottoNumber = new LottoNumber(number);
                    if (!winningNumbers.add(lottoNumber)) {
                        throw new IllegalArgumentException("중복된 숫자를 입력했습니다. 중복 없이 다시 입력해주세요.");
                    }
                    winningNumbers.add(lottoNumber);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("1~45의 값을 중복되지 않도록 6개 입력해주세요");
                continue;
            }
            Lotto winningLotto = new Lotto(winningNumbers);

            int inputBonusNumber;
            LottoNumber bonusNumber;
            while (true) {
                System.out.println("보너스 번호를 입력하세요");
                try {
                    inputBonusNumber = Integer.parseInt(SCANNER.next());
                    if (inputBonusNumber < 1 || inputBonusNumber > 45) {
                        throw new IllegalArgumentException("1~45 사이의 숫자를 입력해주세요.");
                    }
                    bonusNumber = new LottoNumber(inputBonusNumber);
                    if (winningNumbers.contains(bonusNumber)) {
                        throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복되면 안 됩니다.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("1~45 사이의 숫자를 당첨 번호와 중복되지 않게 입력해주세요.");
                    continue;
                }
                break;
            }

            WinningNumber rank = new WinningNumber(winningLotto, bonusNumber);

            int ranking = rank.rank(lottoList.get(0));
            System.out.println(ranking);

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

