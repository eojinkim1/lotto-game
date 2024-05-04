package step_1;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private static final int PRICE = 1_000;
    public List<Lotto> sellLotto(int money) {
        if (money < PRICE) {
            throw new IllegalArgumentException("1000원 이상의 값을 입력해주세요");
        }
        int quantity = money / PRICE;

        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottoList.add(Lotto.random());
        }
        return lottoList;
    }
}
