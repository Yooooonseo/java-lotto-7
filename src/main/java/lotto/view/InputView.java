package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    // 로또 구입 금액을 입력받는 메서드
    public int readPurchaseAmount() {
        System.out.println("로또 구입 금액을 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine();
                int amount = Integer.parseInt(input);
                validatePurchaseAmount(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    // 당첨 번호를 입력받는 메서드
    public Lotto readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine();
                String[] numberStrings = input.split(",");
                List<Integer> winningNumbers = new ArrayList<>();

                for (String numberString : numberStrings) {
                    winningNumbers.add(Integer.parseInt(numberString.trim()));
                }

                // Lotto 클래스의 생성자를 통해 유효성 검사를 수행
                return new Lotto(winningNumbers);

            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            } catch (Exception e) { // 추가된 부분
                System.out.println("[ERROR] 입력된 번호가 유효하지 않습니다."); // 추가된 부분
            }
        }
    }

    // 보너스 번호를 입력받는 메서드
    public int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine();
                int bonusNumber = Integer.parseInt(input);
                validateBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    // 로또 구입 금액 유효성 검증
    private void validatePurchaseAmount(int amount) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    // 보너스 번호 유효성 검증
    private void validateBonusNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}