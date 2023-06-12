/*
 * ユーザーに二桁の数字を入力してもらって数を充てるゲームを作りたい
 * 当たったら当たりを表示する
 * 外れたら設定された数字より大きいか小さいかを表示する
 * 20以上の差があるとその旨を表示する
 * ユーザーは五回まで入力できる
 * 五回以内に当てられなかったらゲームオーバーと表示して政界の数を表示する
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class kazuate {
    int count = 0; // カウント用変数
    Random rand; // 乱数生成用変数
    int ans; // 正解用変数
    int num; // 入力用変数

    public void asknumber() {
        System.out.println("10~99の数字を入力してください");
        num = inputNumber();
    }

    // 数字を入力するための関数
    public int inputNumber() {
        int number;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = br.readLine();
            number = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            System.err.println("フォーマット例外です．もう一度．");
            number = inputNumber(); // 再帰呼び出し
        } catch (IOException e) {
            System.err.println("入出力例外です．もう一度．");
            number = inputNumber(); // 再帰呼び出し
        }

        return number;
    }

    // 数字を判定するための関数
    public void judge(int num, int ans) {
        if (num == ans) {
            System.out.println("当たりです");
        } else if (num > ans) {
            System.out.println("もっと小さいです");
        } else if (num < ans) {
            System.out.println("もっと大きいです");
        }
    }

    // 20以上の差があるとその旨を表示する
    public void diff(int num, int ans) {
        if (Math.abs(num - ans) >= 20) {
            System.out.println("20以上の差があります");
        }
    }

    // メイン関数
    public static void main(String[] args) {
        kazuate k = new kazuate();
        k.rand = new Random();
        k.ans = k.rand.nextInt(90) + 10; // 10~99の乱数を生成

        while (k.count < 5) {
            k.count++;
            k.asknumber(); // 数字を入力する
            k.judge(k.num, k.ans); // 数字を判定する
            k.diff(k.num, k.ans); // 20以上の差があるとその旨を表示する
            System.out.println("あと" + (5 - k.count) + "回です");
        }
    }

}
