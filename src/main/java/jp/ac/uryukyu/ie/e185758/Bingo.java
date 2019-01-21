package jp.ac.uryukyu.ie.e185758;

import java.util.ArrayList;
import java.util.Collections;

public class Bingo {
    ArrayList<Integer> rand() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        // listに値を入れる。この段階では昇順
        for (int i = 1; i <= 9; i++) {
            list.add(i);
        }
        // シャッフルして、順番を変える
        Collections.shuffle(list);
        return list;
    }

    void Bingo() {
        /*
        ArrayList<Integer> list = new ArrayList<Integer>();
        // listに値を入れる。この段階では昇順
        for (int i = 1; i <= 9; i++) {
            list.add(i);
        }
        // シャッフルして、順番を変える
        Collections.shuffle(list);
        */

        int[][] bingocard;
        bingocard = new int[3][3];
        int number = 0;
        for (int vertical = 0; vertical < 3; vertical++) {
            for (int i = 0; i < 3; i++) {
                int number_value = 1;
                number++;
                bingocard[vertical][i] = number_value;
                int value = bingocard[vertical][i];
                System.out.print("|" + String.format("%02d", value) + "|");
            }
            System.out.println(" ");
        }
    }
    void Bingo_ball(){

    }
}