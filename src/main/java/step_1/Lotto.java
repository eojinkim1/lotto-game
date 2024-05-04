package step_1;

import java.util.*;

public class Lotto {
    private Set<LottoNumber> numbers;//글로벌 변수,필드 변수, 인스턴트 변수, 속성값

    public Lotto(Set<LottoNumber> numbers) { // 생성자 new 로 밖에서 불릴 때 호출되는 거(로컬 변수) //함수는 초기화 용도 = 초기화는 변수에 어떤 값을 할당하는 것을 말함
        this.numbers = new HashSet<>(numbers); // this(글로벌 변수, 인스턴트 변수), 로컬에 있는 변수를 뜻함
    }

    public static Lotto random() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (int i = 0; i < 6; i++) {
            LottoNumber number = new LottoNumber(numbers.get(i));
            lottoNumbers.add(number);
        }
        return new Lotto(lottoNumbers);
    }

    public Set<LottoNumber> getNumbers() {
        return new HashSet<>(numbers);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (LottoNumber number : numbers) {
            result.append(number.getNumber()).append(", ");
        }
        if (!numbers.isEmpty()) {
            result.setLength(result.length() - 2); // 마지막 쉼표와 공백 제거
        }
        result.append("]");
        return result.toString();
    }
}

