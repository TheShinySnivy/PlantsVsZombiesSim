package com.cwidden.models;

import java.util.ArrayList;

public class SunGame {

    private double sunPerSecond;

    public SunGame (int seconds) {
        new SunGame(seconds, 45, false);
    }

    public SunGame(int seconds, int maxField, boolean printEverySecond) {
        int sun = 50;
        int recharge = 0;
        ArrayList<Sunflower> shroomList = new ArrayList<Sunflower>();

        for (int i = 0; i < seconds; i++) {
            if (printEverySecond) {
                System.out.println("Sun: " + sun + " Sunflowers: " + shroomList.size());
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
                //System.out.println(Sunflower);
            }

            recharge--;

        }

        System.out.println("Final efficiency: " + sunPerSecond + " sun per second");
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
