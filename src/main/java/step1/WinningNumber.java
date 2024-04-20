package step1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WinningNumber {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int inputLength = 6;
    private static String[] INPUT_STR_WINNING_NUMBER = new String[6];

    public void numberConfirm() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요");
            try {
                String inputWinningNumber = SCANNER.next();

                INPUT_STR_WINNING_NUMBER = inputWinningNumber.split(",");
                if (inputWinningNumber.length() != inputLength) {
                    System.out.println("(,)로 구분하여 6개의 값을 입력해주세요.");
                    continue;
                }
                boolean isValid = true;
                for (String num : INPUT_STR_WINNING_NUMBER) {
                    int value = Integer.parseInt(num);
                    if (value < 1 || value > 45) {
                        System.out.println("1~45 사이의 숫자를 (,)로 구분하여 6개의 값을 입력해주세요.");
                        isValid = false;
                        break;
                    }
                }
                if (!isValid) {
                    continue;
                }
                for (int i = 0; i < inputLength - 1; i++) {
                    for (int j = 1; j < inputLength; j++) {
                        if (Integer.parseInt(INPUT_STR_WINNING_NUMBER[i]) == Integer.parseInt(INPUT_STR_WINNING_NUMBER[j])) {
                            System.out.println("중복된 번호가 있습니다. 다시 입력해주세요.");
                            break;
                        }
                    }
                }

                break;
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("(,)로 구분하여 6개의 값을 입력해주세요.");
                continue;
            }
        }
        int[] winningNumber = new int[inputLength];
        for (int i = 0; i < inputLength; i++) {
            winningNumber[i] = Integer.parseInt(INPUT_STR_WINNING_NUMBER[i].trim());
        }
    }
}

