public class Game {
    private Map map;
    private Block[][] dashboard;
    public GameStatus status = GameStatus.RUNNING;
    public Game(int width, int height,int bombCount){
        map = new Map(width,height,bombCount);
        dashboard = map.generateMap();
    }
    public void clickedBlock(int x, int y){
        dashboard[x][y].setStatus(CurrentStatus.CLICKED);
        if(dashboard[x][y].getClass() == Bomb.class){
            status = GameStatus.LOSE;
        }else{
            revealBlock(x, y);
            checkWin();
        }
    }

    private GameStatus checkWin() {
        for(Block[]i: dashboard){
            for(Block j: i){
                if(j.getClass() != Bomb.class && (j.getStatus() != CurrentStatus.REVEALED && j.getStatus() != CurrentStatus.CLICKED)){
                    return GameStatus.RUNNING;
                }
            }
        }
        return GameStatus.WIN;
    }

    private void revealBlock(int x, int y) {
        if(x == 0){
            if(y == dashboard[0].length-1){
                checkReveal(x,y-1);
                checkReveal(x+1,y);
                checkReveal(x+1,y-1);
            }else if(y == 0){
                checkReveal(x,y+1);
                checkReveal(x+1,y);
                checkReveal(x,y+1);
            }else{
                checkReveal(x,y-1);
                checkReveal(x+1,y);
                checkReveal(x+1,y+1);
                checkReveal(x,y+1);
                checkReveal(x+1,y-1);
            }
        }else if(x == dashboard.length-1){
            if(y == dashboard[0].length-1){
                checkReveal(x,y-1);
                checkReveal(x-1,y);
                checkReveal(x-1,y-1);
            }else if(y == 0){
                checkReveal(x,y+1);
                checkReveal(x-1,y);
                checkReveal(x-1,y+1);
            }else{
                checkReveal(x,y-1);
                checkReveal(x-1,y);
                checkReveal(x-1,y+1);
                checkReveal(x,y+1);
                checkReveal(x-1,y-1);
            }
        }else{
            if(y == dashboard[0].length-1){
                checkReveal(x,y-1);
                checkReveal(x-1,y);
                checkReveal(x-1,y-1);
                checkReveal(x+1,y);
                checkReveal(x+1,y-1);
            }else if(y == 0){
                checkReveal(x,y+1);
                checkReveal(x-1,y);
                checkReveal(x-1,y+1);
                checkReveal(x+1,y+1);
                checkReveal(x+1,y);
            }else{
                checkReveal(x,y-1);
                checkReveal(x-1,y);
                checkReveal(x-1,y+1);
                checkReveal(x,y+1);
                checkReveal(x-1,y-1);
                checkReveal(x+1,y-1);
                checkReveal(x+1,y);
                checkReveal(x+1,y+1);
            }
        }
    }

    private void checkReveal(int x, int i) {
        if(dashboard[x][i].getClass() != Bomb.class && (dashboard[x][i].getStatus() != CurrentStatus.REVEALED && dashboard[x][i].getStatus() != CurrentStatus.CLICKED)){
            dashboard[x][i].setStatus(CurrentStatus.REVEALED);
        }
    }

    public void printGame() {
        System.out.println("Points: " + points);
        for(Block[] i: dashboard){
            for(Block j: i){
                if(j.getStatus() != CurrentStatus.NOT_CLICKED && j.getClass() ==Bomb.class) {
                    System.out.print("B");
                }else if(j.getStatus() != CurrentStatus.NOT_CLICKED){
                    System.out.print("1");
                }else{
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}
