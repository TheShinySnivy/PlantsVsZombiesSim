package com.cwidden;

import com.cwidden.gui.PVZGui;
import com.cwidden.models.ShroomGame;
import com.cwidden.models.SunGame;

public class SVSController {

    private static SVSController INSTANCE = new SVSController();

    private PVZGui pvzGui;

    public static SVSController getINSTANCE() {
        return INSTANCE;
    }

    private SVSController() {

    }

    public void buildGui() {
        pvzGui = new PVZGui();
        pvzGui.setVisible(true);
    }

    public void runGame(int fieldSize, int gameLength, boolean printExtraInformation) {
        printShroomText("New game: Field size " + fieldSize + ", Game length " + gameLength + " seconds.", false);
        new ShroomGame(gameLength, fieldSize, printExtraInformation);
        printSunflowerText("New game: Field size " + fieldSize + ", Game length " + gameLength + " seconds.", false);
        new SunGame(gameLength, fieldSize, printExtraInformation);
    }

    public void printSunflowerText(String text, boolean highlight) {
        pvzGui.printSunflowerLine(text, highlight);
    }

    public void printShroomText(String text, boolean highlight) {
        pvzGui.printShroomLine(text, highlight);
    }
}
