package jp.ac.uryukyu.ie.e185758;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BingoTest {
    @org.junit.jupiter.api.Test

    /**
     * 一列が全て０のビンゴカードを生成するメソッド
     */
    void Bingo_line(){
    int card[][];
    card = new int[5][5];
        Bingo bingo = new Bingo();
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 5; i++) {
                card[i][j] = 0;
            }
        }
        bingo.setCard(card);
        assertFalse(bingo.Bingo_line());
    }
}