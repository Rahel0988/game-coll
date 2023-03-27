package rahel.weldemariyam.mygame;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MyViewModel extends ViewModel {

    public static final int TIMER_GAME_ID = 1;
    public static final int RACE_GAME_ID = 2;
    public static final int CAT_HAND_GAME_ID = 3;

    private int selectedGameID;

    public int getSelectedGameID() {
        return selectedGameID;
    }

    public void setSelectedGameID(int selectedGameID) {
        this.selectedGameID = selectedGameID;
    }

    public static final int One_PLAYER_ID= 4;
    public static final int TWO_PLAYER_ID= 5;
    public static final int THREE_PLAYER_ID= 6;
    public static final int FOUR_PLAYER_ID= 7;

    private int selectedplayerID;

    public int getSelectedPlayerID() {
        return selectedplayerID;
    }

    public void setSelectedplayerID(int selectedplayerID) {
        this.selectedplayerID = selectedplayerID;
    }


}

