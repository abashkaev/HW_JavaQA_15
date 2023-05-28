import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {

    Game game = new Game();

    Player player1 = new Player(1, "Иван", 12);
    Player player2 = new Player(2, "Владимир", 28);
    Player player3 = new Player(3, "Денис", 18);
    Player player4 = new Player(4, "Александр", 20);
    Player player5 = new Player(5, "Максим", 20);

    Player player6 = new Player(1, "Мгер", 16);

    @BeforeEach
    public void setUp() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
    }

    @Test
    public void roundWinIsPlayer1 () {
        Assertions.assertEquals(1,game.round("Владимир", "Денис"));
    }
    @Test
    public void roundWinIsPlayer2() {
        Assertions.assertEquals(2, game.round("Иван","Александр"));
    }
    @Test
    public void roundIsDraw() {
        Assertions.assertEquals(0, game.round("Максим", "Александр"));
    }
    @Test
    public void player1IsNotRegister() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Мгер", "Иван");
        });
    }
    @Test
    public void player2IsNotRegister() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Иван", "Мгер");
        });
    }


}
