package step1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WinningNumber {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int INPUT_LENGTH = 6;
    private static String[] inputStrWinningNumber = new String[6];

//    public static void main(String[] args) {
//        numberConfirm();
//    }
    public void numberConfirm() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요");
            try {
                String inputWinningNumber = SCANNER.next();
                inputStrWinningNumber = inputWinningNumber.split(",");

                if (!isValidInput(inputStrWinningNumber)) {
                    continue;
                }
                if (!isValidRange(inputStrWinningNumber)) {
                    continue;
                }
                if (!deduplication(inputStrWinningNumber)) {
                    continue;
                }
                break;
            } catch (InputMismatchException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("1~45 사이의 숫자를 (,)로 구분하여 6개의 값을 입력해주세요.#4");
            }
        }
        int[] winningNumber = new int[INPUT_LENGTH];
        for (int i = 0; i < INPUT_LENGTH; i++) {
            winningNumber[i] = Integer.parseInt(inputStrWinningNumber[i].trim());
        }
//        for (int number : winningNumber) { 당첨번호 확인
//            System.out.print(number);
//        }
        int bonusNumber = inputBonusNumber();
        while (deduplication(winningNumber, bonusNumber)){
            System.out.println("보너스 번호가 당첨 번호와 중복됩니다. 다시 입력해주세요.");
            bonusNumber = inputBonusNumber();
        }
//        System.out.println(bonusNumber); 보너스 번호 확인
    }

    private static boolean deduplication(int[] winningNumbers, int bonusNumber){
        for (int number : winningNumbers) {
            if (number == bonusNumber){
                return true;
            }
        }
        return false;
    }

    private static int inputBonusNumber() {
        while (true){
            System.out.println("보너스 번호를 입력해 주세요.");
            int inputBonusNumber = SCANNER.nextInt();
            if (inputBonusNumber < 1 || inputBonusNumber > 45){
                System.out.println("1~45 사이의 숫자를 1개 입력해주세요.");
                continue;
            }
            return inputBonusNumber;
        }
    }

    private static boolean deduplication(String[] inputNumbers) {
        for (int i = 0; i < INPUT_LENGTH - 1; i++) {
            for (int j = i + 1; j < INPUT_LENGTH; j++) {
                if (Integer.parseInt(inputNumbers[i]) == Integer.parseInt(inputNumbers[j])) {
                    System.out.println("중복된 번호가 있습니다. 다시 입력해주세요.");
                    System.out.println("1~45 사이의 숫자를 (,)로 구분하여 6개의 값을 입력해주세요.#3");
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidRange(String[] inputNumbers) {
        for (String validNumber : inputNumbers) {
            int value = Integer.parseInt(validNumber.trim());
            if (value < 1 || value > 45) {
                System.out.println("1~45 사이의 숫자를 (,)로 구분하여 6개의 값을 입력해주세요.#2");
                return false;
            }
        }
        return true;
    }

    private static boolean isValidInput(String[] inputNumbers) {
        if (inputNumbers.length != INPUT_LENGTH) {
            System.out.println("1~45 사이의 숫자를 (,)로 구분하여 6개의 값을 입력해주세요.#1");
            return false;
        }
        return true;
    }
}

