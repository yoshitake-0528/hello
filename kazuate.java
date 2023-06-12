/*
 * ユーザーに二桁の数字を入力してもらって数を充てるゲームを作りたい
 * 当たったら当たりを表示する
 * 外れたら設定された数字より大きいか小さいかを表示する
 * 20以上の差があるとその旨を表示する
 * ユーザーは五回まで入力できる
 */

import java.util.Random;
import java.util.Scanner;

public class kazuate {
    int count = 0; // カウント用変数
    Random rand; // 乱数生成用変数
    int ans; // 正解用変数
    int num; // 入力用変数

    public int asknumber() {

        System.out.println("二桁の数字を入力してください");
        try{
            Scanner sc = new Scanner(System.in);
        }
        catch
        num = sc.nextInt();
        return num;
    }

    public void judge(int num) {
        if (num == ans) {
            System.out.println("当たりです");
        } else if (num > ans) {
            System.out.println("もっと小さいです");
        } else if (num < ans) {
            System.out.println("もっと大きいです");
        }
    }

    // カウント用変数をインクリメントする
    public void count() {
        count++;
        if (count == 5) {
            System.out.println("ゲームオーバーです");
        }
    }

    // 20以上の差があるとその旨を表示する
    public void diff() {
        if (num - ans >= 20) {
            System.out.println("20以上の差があります");
        }
    }

    public static void main(String[] args) {
        kazuate k = new kazuate();
        k.rand = new Random();
        k.ans = k.rand.nextInt(90) + 10; // 10~99の乱数を生成
        while (k.count < 5) {
            k.asknumber();
            k.judge(k.num);
            k.count();
            k.diff();
        }

    }
}