package step1;

public class LottoGame {
    public static void main(String[] args) {
        PurchaseAmount purchaseAmount = new PurchaseAmount();
        WinningNumber winningNumber = new WinningNumber();

        purchaseAmount.myLotto();

        while (true){
            winningNumber.numberConfirm();
            break;
        }
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
