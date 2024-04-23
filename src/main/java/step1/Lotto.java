package step1;

import java.util.Random;

public class Lotto {
    private int[] numbers; //글로벌 변수,필드 변수, 인스턴트 변수, 속성값
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;

    public Lotto(int[] numbers) { // 생성자 new 로 밖에서 불릴 때 호출되는 거(로컬 변수) //함수는 초기화 용도 = 초기화는 변수에 어떤 값을 할당하는 것을 말함
        validNumbers(numbers);
        this.numbers = numbers; // this(글로벌 변수, 인스턴트 변수), 로컬에 있는 변수를 뜻함
    }
    public static Lotto random(){
        Random random = new Random();
        int[] numbers = new int[6];
        for (int i = 0; i < 6; i++) {
            numbers[i] = random.nextInt(45) + 1;
        }
        return new Lotto(numbers);
    }

    private void validNumbers(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < MINIMUM_NUMBER || numbers[i] > MAXIMUM_NUMBER){
                throw new IllegalArgumentException("1~45범위 값을 초과 했습니다.");
            }
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length ; j++) {
                if (numbers[i] == numbers[j]){
                    throw new IllegalArgumentException("중복된 값입니다.");
                }
            }
        }
        if (numbers.length != 6){
            throw new IllegalArgumentException("범위를 초과한 값입니다.");
        }
    }
    public int[] getNumbers() {
        return numbers;
    }
}
