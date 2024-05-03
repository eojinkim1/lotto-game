package step1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WinningNumber {

    private Lotto winningNumber;
    private LottoNumber bonusNumber;
    public WinningNumber(Lotto winningNumber, LottoNumber bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }
    public void printRank(List<Lotto> lottoList) {
        int[] matchCounts = new int[5]; // 각 등수별 일치하는 번호의 개수를 저장할 배열

        for (Lotto lotto : lottoList) {
            int matchedNumbers = countMatchedNumbers(lotto);
            boolean hasBonusNumber = lotto.getNumbers().contains(bonusNumber);

            switch (matchedNumbers) {
                case 6:
                    matchCounts[0]++; // 6개 일치
                    break;
                case 5:
                    if (hasBonusNumber) {
                        matchCounts[1]++; // 5개 일치 + 보너스 번호 일치
                    } else {
                        matchCounts[2]++; // 5개 일치
                    }
                    break;
                case 4:
                    matchCounts[3]++; // 4개 일치
                    break;
                case 3:
                    matchCounts[4]++; // 3개 일치
                    break;
            }
        }

        // 결과 출력
        System.out.println("당첨통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + matchCounts[4] + "개");
        System.out.println("4개 일치 (50,000원) - " + matchCounts[3] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + matchCounts[2] + "개");
        System.out.println("5개 일치 + 보너스 볼 일치 (30,000,000원) - " + matchCounts[1] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + matchCounts[0] + "개");


        double totalPrize = matchCounts[0] * 2_000_000_000L +
                            matchCounts[1] * 30_000_000L +
                            matchCounts[2] * 1_500_000L +
                            matchCounts[3] * 50_000L +
                            matchCounts[4] * 5_000L;
        double profitRate = ((totalPrize - lottoList.size() * 1_000L) / (lottoList.size() * 1_000L)) * 100;

        System.out.println("총 수익률 " + profitRate + "% 입니다.");
    }
    private int countMatchedNumbers(Lotto lotto) {
        Set<LottoNumber> lottoNumbers = lotto.getNumbers();
        Set<LottoNumber> winningNumbers = winningNumber.getNumbers();

        long sameCount = lottoNumbers.stream() //시퀀스
                .filter(winningNumbers::contains)
                .count();
        return (int) sameCount;
    }
}

