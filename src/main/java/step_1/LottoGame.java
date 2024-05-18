package step_1;

import java.util.*;

public class LottoGame {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static int MINIMUN_PAYMENT = 1_000;
    private static int TICKET_PRICE = 1_000;

    public static void main(String[] args) {
        LottoStore lottoStore = new LottoStore();

        int payment = getPayment();
        int quantity = payment / TICKET_PRICE;
        System.out.println(quantity + "개를 구매했습니다.");
        List<Lotto> lottoList = lottoStore.sellLotto(payment);
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }

        Set<LottoNumber> winningNumbers = getWinningNumber();
        LottoNumber bonusNumber = getBonusNumber(winningNumbers);

        WinningNumber winningNumber = new WinningNumber(new Lotto(winningNumbers), bonusNumber);
        winningNumber.printRank(lottoList);
    }

    private static int getPayment() {
        while (true) {
            System.out.println("구입 금액을 입력해 주세요.");
            try {
                int payment = Integer.parseInt(SCANNER.next());
                if (payment < MINIMUN_PAYMENT) {
                    throw new IllegalArgumentException("1000원 이상의 값을 입력해주세요");
                }
                return payment;
            } catch (IllegalArgumentException e) {
                System.out.println("1000원 이상의 값을 입력해주세요");
            }
        }
    }
    private static Set<LottoNumber> getWinningNumber() {
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
                    LottoNumber lottoNumber = validateLottoNumber(input, winningNumbers);
                    winningNumbers.add(lottoNumber);
                }
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println("1~45의 값을 중복되지 않도록 6개 입력해주세요");
            }
        }
    }
    private static LottoNumber getBonusNumber(Set<LottoNumber> winningNumbers) {
        while (true) {
            System.out.println("보너스 번호를 입력하세요");
            try {
                String inputBonusNumber = SCANNER.next();
                LottoNumber bonusNumber = validateLottoNumber(inputBonusNumber, null);
                if (winningNumbers.contains(bonusNumber)) {
                    throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복되면 안 됩니다.");
                }
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println("1~45 사이의 숫자를 당첨 번호와 중복되지 않게 입력해주세요.");
            }
        }
    }

    private static LottoNumber validateLottoNumber(String input, Set<LottoNumber> winningNumbers) {
        int number = Integer.parseInt(input);
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("1부터 45 사이의 숫자를 입력해주세요.");
        }
        LottoNumber lottoNumber = new LottoNumber(number);
        if (winningNumbers != null && !winningNumbers.add(lottoNumber)) {
            throw new IllegalArgumentException("중복된 숫자를 입력했습니다. 중복 없이 다시 입력해주세요.");
        }
        return lottoNumber;
    }
}

