import java.util.Random;

public class Map {
    private int width, height;
    private Block[][] map;
    private int bombCount;
    public Map(int width, int height, int bombCount) {
        this.width = width;
        this.height = height;
        this.map = new Block[width][height];
        this.bombCount = bombCount;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public Block[][] generateMap() {
        int chance = 0;
        Random rand = new Random();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (bombCount != 0) {
                    chance = rand.nextInt(2);
                    if (chance == 0) {
                        map[x][y] = new Bomb(x, y);
                        bombCount--;
                    } else {
                        map[x][y] = new Cell(1, x, y);
                    }
                } else {
                    map[x][y] = new Cell(1, x, y);
                }
            }
        }
        return map;
    }

    public Block[][] getMap() {
        return map;
    }
}
