package Common.Level2;


//숫자 야구게임
//        요구사항
//
//        기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
//
//        같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고,
//        그 힌트를 이용해서 먼저 상대방의 수를 맞추면 승리한다.
//
//        [예] 상대방의 수가 425일 때,
//        123을 제시한 경우 : 1 스트라이크
//        456을 제시한 경우 : 1 스트라이크 1볼
//        789를 제시한 경우 : 낫싱
//
//        위 숫자 야구게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다.
//        게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
//
//        이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
//
//        게임 진행 결과는 다음과 같다.
//
//        숫자를 입력해주세요 ex)123 : 123
//        1 스트라이크 1볼
//        숫자를 입력해주세요 ex)123 : 145
//        1볼
//        숫자를 입력해주세요 ex)123 : 671
//        2볼
//        숫자를 입력해주세요 ex)123 : 216
//        1 스트라이크
//        숫자를 입력해주세요 ex)123 : 713
//        3 스트라이크
//        3개의 숫자를 모두 맞히셨습니다! 게임 종료
//
//        프로그래밍 구현 제약사항
//
//        함수(또는 메소드) 하나의 크기가 최대 10라인을 넘지 않도록 구현한다.
//        함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.
//        indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
//        예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
//        전역 변수를 사용하지 않는다.
//
//        힌트
//
//        컴퓨터가 3개의 값을 선택할 때 각 언어별 random 함수(또는 메소드) 또는 shuffle 함수(또는 메소드)를 이용하면 편한다.
//        반복문을 2중(반복문 안의 반복문)으로 사용하면 한번에 고려할 부분이 많다. 2중 반복문을 1중 반복문 2개로 나누어 처리하는 방법은 없는지 고려해 본다.
//        indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {

        // 컴퓨터의 랜덤 수를 생성하기 위한
        Random random = new Random();
        long seed = System.currentTimeMillis();
        int targetInteger =  random.nextInt(999);
        String targetString = String.valueOf(targetInteger);
        // 컴퓨터의 랜덤 수를 생성하기 위한

        boolean token = true;

        while (token == true) {
            token = iterator(refereeJudgement(targetString));
        }

    }

    public static String refereeJudgement(String targetString) throws IOException {

        System.out.print("숫자를 입력해주세요 : ");

        // 사용자 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputInteger = Integer.parseInt(br.readLine());
        String inputString = String.valueOf(inputInteger);

        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < 3; i++) {
            //일치하면 스트라이크 카운트 + 1
            if (targetString.charAt(i) == inputString.charAt(i)) {
                strikeCount ++;
            } 
            //자리까지 일치하진 않지만 포한된다면 볼카운트 + 1
            else if (targetString.contains(inputString)) {
                ballCount ++;
            }

        }

        // 3개 다 맞았을 경우
        if (strikeCount >= 3) {
            return "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }

        // 스트라이크, 볼 모두 포함된 경우
        if (strikeCount > 0 && ballCount > 0) {
            System.out.println(" 스트라이크 " + ballCount + " 볼");
            return strikeCount + " 스트라이크 " + ballCount + " 볼";
        }

        // 스트라이크만 포함된 경우
        if (strikeCount > 0 && ballCount == 0) {
            System.out.println(strikeCount + " 스트라이크");
            return strikeCount + " 스트라이크";
        }

        // 볼만 포함된 경우
        if (ballCount > 0 && strikeCount == 0) {
            System.out.println(ballCount + " 볼");
            return ballCount + " 볼";
        }

        // 위 4가지의 조건문에 부합되지 않으면 아무것도 맞춘게 없는것
        System.out.println("낫싱");
        return "낫싱";
    }

    public static boolean iterator(String message) {
        if (message.equals("3개의 숫자를 모두 맞히셨습니다! 게임 종료")) {
            System.out.println(message);
            return false;
        }

        return true;
    }
}
