import java.lang.reflect.Array;
import java.util.ArrayList;

public class Game {

    ArrayList<Player> playersIsRegister = new ArrayList<Player>();

    public void register(Player player) {
        playersIsRegister.add(player);
    }

    public int round(String playerName1, String playerName2) {
        if (isPlayerRegister(playerName1) == false) {
            NotRegisteredException e = new NotRegisteredException(
                    "Игрок " + playerName1 + " не зарегистрирован!"
            );
            throw e;
        }
        if (isPlayerRegister(playerName2) == false) {
            NotRegisteredException e = new NotRegisteredException(
                    "Игрок " + playerName2 + " не зарегистрирован!"
            );
            throw e;
        }
        if (showStrangeByName(playerName1) > showStrangeByName(playerName2)) {
            return 1;
        } else if (showStrangeByName(playerName1) < showStrangeByName(playerName2)) {
            return 2;
        } else {
            return 0;
        }
    }

    public boolean isPlayerRegister(String name) {
        for (Player player : playersIsRegister) {
            if (player.getName() == name) {
                return true;
            }
        }
        return false;
    }

    public int showStrangeByName(String name) {
        int strength = -1;
        for (Player player : playersIsRegister) {
            if (player.getName() == name) {
                strength = player.getStrength();
            }
        }
        return strength;
    }


}