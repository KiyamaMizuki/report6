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
        //ArrayList<Integer> new_rand;
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
                    //new_rand_1 = rand(1,15);
                    bingocard[vertical][i] =  (int) new_rand_1.get(number);
                }else if(i == 1){
                    //new_rand_2 = rand(16,30);
                    bingocard[vertical][i] =  (int) new_rand_2.get(number);
                }else if(i == 2) {
                    //new_rand_3 = rand(31, 45);
                    bingocard[vertical][i] =  (int) new_rand_3.get(number);
                }else if(i == 3) {
                    //new_rand_4 = rand(46, 60);
                    bingocard[vertical][i] =  (int) new_rand_4.get(number);
                }else {
                    //new_rand_5 = rand(61,75);
                    bingocard[vertical][i] =  (int) new_rand_5.get(number);
                }

                //bingocard[vertical][i] =  (int) new_rand.get(number);
                //number++;
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
        int number = 0;
        ArrayList rand = rand(1,75);
        int ball = (int) rand.get(number);
        System.out.println("n回目の数字は" + ball + "です。");

        
        for (int vertical = 0; vertical < 5; vertical++) {
            for (int i = 0; i < 5; i++) {
                if(card[vertical][i] == ball) {
                    card[vertical][i] = 0;
                    Judg = true;
                }

                int value = card[vertical][i];
                System.out.print("|" + String.format("%02d", value) + "|");
            }
            System.out.println(" ");
        }
        if(Judg) {
            System.out.println("おめでとうございます。");
        }else{
            System.out.print("該当する数字はありませんでした。");
        }




    }
}