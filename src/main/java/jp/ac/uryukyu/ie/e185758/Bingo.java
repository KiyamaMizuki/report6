package jp.ac.uryukyu.ie.e185758;

import java.util.ArrayList;
import java.util.Collections;

public class Bingo {
    int[][] card;

    ArrayList<Integer> rand(int min,int max) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        // listに値を入れる。この段階では昇順
        for (int i = min; i <= max; i++) {
            list.add(i);
        }
        // シャッフルして、順番を変える
        Collections.shuffle(list);
        return list;
    }

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

    void Bingo_ball(){

        boolean Judg = false;
        boolean line = true;
        int number = 0;
        ArrayList rands = rand(1,75);
        int play = 1;

        while (line) {
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
            System.out.println(number);


            //横のビンゴ
            for (int i = 0; i < 5; i++) {
                int count = 0;
                for (int j = 0; j < 5; j++) {
                    if (card[i][j] == 0) {
                        count++;
                        if (count == 5) {
                            line = false;
                        }
                    }
                }
            }
            //縦のビンゴ
            for (int i = 0; i < 5; i++) {
                int count = 0;
                for (int j = 0; j < 5; j++) {
                    if (card[j][i] == 0) {
                        count++;
                        if (count == 5) {
                            line = false;
                        }
                    }
                }
            }
            //斜めのビンゴ１
            int j = 0;
            int count = 0;
            for (int i = 0; i < 5; i++) {
                if (card[i][j] == 0) {
                    count++;
                    if (count == 5) {
                        line = false;
                    }
                }
                j++;
            }
            //斜めのビンゴ２
            int n = 4;
            int c = 0;
            for (int i = 0; i < 5; i++) {
                if (card[i][n] == 0) {
                    c++;
                    if (c == 5) {
                        line = false;
                    }
                    n--;
                }
            }
        }
        System.out.println("ゲーム終了です。");
    }
}