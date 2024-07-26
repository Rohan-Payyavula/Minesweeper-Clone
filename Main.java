import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Game game = new Game(10,10,10);
        int x,y;
        Scanner sc = new Scanner(System.in);
        game.printGame();
        do{
            x = sc.nextInt();
            y  = sc.nextInt();
            game.clickedBlock(x,y);
            game.printGame();
        }while(game.status == GameStatus.RUNNING);
    }
}