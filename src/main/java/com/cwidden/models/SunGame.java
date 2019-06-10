package com.cwidden.models;

import com.cwidden.SVSController;

import java.util.ArrayList;

public class SunGame {

    private double sunPerSecond;

    private SVSController svsController = SVSController.getINSTANCE();

    public SunGame (int seconds) {
        new SunGame(seconds, 45, false);
    }

    public SunGame(int seconds, int maxField, boolean printEverySecond) {
        int sun = 50;
        int recharge = 0;
        ArrayList<Sunflower> shroomList = new ArrayList<Sunflower>();

        for (int i = 0; i < seconds; i++) {
            if (printEverySecond) {
                svsController.printSunflowerText("Sun: " + sun + " Sunflowers: " + shroomList.size(), false);
            }

            while (sun >= 50 && shroomList.size() < maxField && recharge <= 0) {
                sun -= 50;
                shroomList.add(new Sunflower());
                recharge = 7;
            }

            sunPerSecond = 0;

            for (Sunflower Sunflower: shroomList) {
                sun += Sunflower.tick();
                sunPerSecond += Sunflower.sunPerSecond;
            }

            recharge--;

        }

        svsController.printSunflowerText("Final efficiency: " + sunPerSecond + " sun per second", true);
    }

    private class Sunflower {
        public double sunPerSecond = (25.0 / 24.0);
        private int seconds = 17;

        public Sunflower() {
        }

        public int tick() {
            int sun = 0;
            seconds += 1;

            if (seconds == 24) {
                seconds = 0;
                sun = 25;
            }
            return sun;
        }

        @Override
        public String toString() {
            String toReturn = "Sunflower: ";

            toReturn += ", " + seconds + " seconds";

            return toReturn;
        }
    }
}
