package step1;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class LottoGame {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static final int inputLength = 6;
    private static String[] INPUT_STR_WINNING_NUMBER = new String[6];

    public static void main(String[] args) {
        PurchaseAmount purchaseAmount = new PurchaseAmount();
        int randomLottoNumber[] = new int[6];

        int quantity = purchaseAmount.buyLotto();

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
//
//        while (true) {
//            System.out.println("당첨 번호를 입력해 주세요");
//            while (true) {
//                try {
//                    String inputWinningNumber = SCANNER.next();
//
//                    INPUT_STR_WINNING_NUMBER = inputWinningNumber.split(",");
//                    if (inputWinningNumber.length() != inputLength) {
//                        System.out.println("(,)로 구분하여 6개의 값을 입력해주세요.");
//                        continue;
//                    }
//                    boolean isValid = true;
//                    for (String num : INPUT_STR_WINNING_NUMBER) {
//                        int value = Integer.parseInt(num.trim());
//                        if (value < 1 || value > 45) {
//                            System.out.println("1~45 사이의 숫자를 (,)로 구분하여 6개의 값을 입력해주세요.");
//                            isValid = false;
//                            break;
//                        }
//                    }
//                    if (!isValid) {
//                        continue;
//                    }
//                    return;
//                } catch (InputMismatchException | NumberFormatException e) {
//                    System.out.println("(,)로 구분하여 6개의 값을 입력해주세요.");
//                }
//            }
////            int[] winningNumber = new int[inputLength];
////            for (int i = 0; i < inputLength; i++) {
////                winningNumber[i] = Integer.parseInt(INPUT_STR_WINNING_NUMBER[i].trim());
////            }
//
//        }
//
////        System.out.println("보너스 번호를 입력해 주세요");
////        SCANNER.nextInt();
//
////        일치 조건 문
////        for (int i = 0; i < quantity; i++) {
////            for (int j = 0; j < 6; j++) {
////
////            }
////        }


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
