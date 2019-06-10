package com.cwidden.models;

import com.cwidden.SVSController;

import java.util.ArrayList;

public class ShroomGame {

    private double sunPerSecond;

    private SVSController svsController = SVSController.getINSTANCE();

    public ShroomGame(int seconds) {
        new ShroomGame(seconds, 45, false);
    }

    public ShroomGame(int seconds, int maxField, boolean printEverySecond) {

        int sun = 50;
        int recharge = 0;
        ArrayList<Sunshroom> shroomList = new ArrayList<Sunshroom>();

        for (int i = 0; i < seconds; i++) {
            if (printEverySecond) {
                svsController.printShroomText("Sun: " + sun + " Sunshrooms: " + shroomList.size(), false);
            }

            while (sun >= 25 && shroomList.size() < maxField && recharge <= 0) {
                sun -= 25;
                shroomList.add(new Sunshroom());
                recharge = 7;
            }

            sunPerSecond = 0;

            for (Sunshroom sunshroom: shroomList) {
                sun += sunshroom.tick();
                sunPerSecond += sunshroom.sunPerSecond;
                //System.out.println(sunshroom);
            }

            recharge--;

        }

        svsController.printShroomText("Final efficiency: " + sunPerSecond + " sun per second", true);
    }

    private class Sunshroom {
        public double sunPerSecond = (15.0 / 24.0);
        private int seconds = 17;
        private int countdown = 120;
        private boolean isBig = false;

        public Sunshroom() {
        }

        public int tick() {
            int sun = 0;
            seconds += 1;
            countdown -= 1;


            if (countdown == 0) {
                isBig = true;
                sunPerSecond = (25.0/24.0);
            }

            if (seconds == 24) {
                seconds = 0;
                if (isBig) {
                    sun = 25;
                } else {
                    sun = 15;
                }
            }
            return sun;
        }

        @Override
        public String toString() {
            String toReturn = "Sunshroom: ";
            if (isBig) {
                toReturn += "big";
            } else {
                toReturn += "small";
            }
            toReturn += ", " + seconds + " seconds";

            return toReturn;
        }
    }
}
