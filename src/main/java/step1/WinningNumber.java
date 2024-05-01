package step1;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    private Lotto winningNumber;
    private LottoNumber bonusNumber;
    public WinningNumber(Lotto winningNumber, LottoNumber bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }
    public int rank(Lotto lotto){
        List<LottoNumber> lottoNumbers = new ArrayList<>(lotto.getNumbers());
        List<LottoNumber> winningNumbers = new ArrayList<>(winningNumber.getNumbers());

        long sameCount = lottoNumbers.stream() //시퀀스
                .filter(winningNumbers::contains)
                .count();

        boolean isSameBonusNumber = lottoNumbers.contains(bonusNumber);

        if (sameCount == 6) {
            return 1;
        } else if (sameCount == 5 && isSameBonusNumber) {
            return 2;
        } else if (sameCount == 5) {
            return 3;
        } else if (sameCount == 4) {
            return 4;
        } else if (sameCount == 3) {
            return 5;
        }
        return 6;
    }
}

