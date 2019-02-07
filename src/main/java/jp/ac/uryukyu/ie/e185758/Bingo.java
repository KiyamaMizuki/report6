package jp.ac.uryukyu.ie.e185758;

import java.util.ArrayList;
import java.util.Collections;

/**
 * ビンゴゲームを生成するクラス
 */

public class Bingo {

    /**
     * 最初に作ったビンゴカードの値を入れる変数
     */
    private int[][] card;

    public int[][] setCard(int[][] test){
        card = test;
        return this.card;
    }
    /**
     *
     * @param min
     * @param max
     * @retur min~maxの範囲の数字をシャッフルした配列
     */

    ArrayList<Integer> rand(int min,int max) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = min; i <= max; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        return list;
    }

    /**
     * 上部で生成したrandメソッドを使用して5×5のビンゴカードを作るクラス
     * @return　5×5のビンゴカード
     */
    int[][] Bingo() {
        ArrayList new_rand_1 = rand(1,15);
        ArrayList new_rand_2 = rand(16,30);
        ArrayList new_rand_3 = rand(31,45);
        ArrayList new_rand_4 = rand(46,60);
        ArrayList new_rand_5 = rand(61,75);

        int[][] bingocard;
        bingocard = new int[5][5];
        int number = 0;
        for (int vertical = 0; vertical < 5; vertical++) {
            for (int i = 0; i < 5; i++) {

                if(i == 0){
                    bingocard[vertical][i] =  (int) new_rand_1.get(number);
                }else if(i == 1){
                    bingocard[vertical][i] =  (int) new_rand_2.get(number);
                }else if(i == 2) {
                    bingocard[vertical][i] =  (int) new_rand_3.get(number);
                }else if(i == 3) {
                    bingocard[vertical][i] =  (int) new_rand_4.get(number);
                }else {
                    bingocard[vertical][i] =  (int) new_rand_5.get(number);
                }

                int value = bingocard[vertical][i];
                System.out.print("|" + String.format("%02d", value) + "|");

            }
            System.out.println(" ");
            number++;
        }
        card = bingocard;
        return card;
    }

    /**
     * 「ビンゴボール」を生成し、ビンゴカードの数字と参照する。
     * 参照した結果を出力し、下部で書かれているBingo_lineメソッドによりゲームクリアを判定する。
     */

    void Bingo_ball(){

        boolean Judg = false;
        int number = 0;
        ArrayList rands = rand(1,75);
        int play = 1;

        while (Bingo_line()) {
            int ball = (int) rands.get(number);
            System.out.println(play + "回目の数字は" + ball + "です。");
            play++;
            for (int vertical = 0; vertical < 5; vertical++) {
                for (int i = 0; i < 5; i++) {
                    if (card[vertical][i] == ball) {
                        card[vertical][i] = 0;
                        Judg = true;
                    }
                    int value = card[vertical][i];
                    System.out.print("|" + String.format("%02d", value) + "|");
                }
                System.out.println(" ");
            }
            if (Judg) {
                System.out.println("おめでとうございます。");
            } else {
                System.out.println("該当する数字はありませんでした。");
            }
            number++;

            Bingo_line();


        }
        System.out.println("ゲーム終了です。");
    }

    /**
     *　ゲームクリアを判定するクラス
     * @return　ビンゴカードの縦、横、斜めいずれかの全てが０になった時のみfalseを返す。
     */
    boolean Bingo_line(){
        for (int i = 0; i < 5; i++) {
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (card[i][j] == 0) {
                    count++;
                    if (count == 5) {
                        return false;
                    }
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (card[j][i] == 0) {
                    count++;
                    if (count == 5) {
                        return false;
                    }
                }
            }
        }
        int j = 0;
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (card[i][j] == 0) {
                count++;
                if (count == 5) {
                   return false;
                }
            }
            j++;
        }
        int n = 4;
        int c = 0;
        for (int i = 0; i < 5; i++) {
            if (card[i][n] == 0) {
                c++;
                if (c == 5) {
                    return false;
                }
                n--;
            }
        }
        return true;
    }
}