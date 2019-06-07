package com.cwidden;

import com.cwidden.models.ShroomGame;
import com.cwidden.models.SunGame;

public class SunVsShroom {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            runGames(30 * i);
        }

    }

    public static void runGames(int seconds) {
        System.out.println(seconds + " seconds:");
        System.out.print("\tSun-shroom game: ");
        new ShroomGame(seconds, 10, false);
        System.out.print("\tSunflower game: ");
        new SunGame(seconds, 10, false);
    }



}
