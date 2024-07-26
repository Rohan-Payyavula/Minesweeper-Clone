public abstract class Block {
    public int x,y;
    private CurrentStatus status;
    public int points = 0;
    public Block(int x, int y) {
        this.status = CurrentStatus.NOT_CLICKED;
        this.x = x;
        this.y = y;
    }
    public Block(int x, int y, CurrentStatus status) {
        this.status = status;
        this.x = x;
        this.y = y;
    }
    public Block(){
        this.status = CurrentStatus.NOT_CLICKED;
        this.x = 0;
        this.y = 0;
    }
    public CurrentStatus getStatus() {
        return status;
    }
    public void setStatus(CurrentStatus status) {
        this.status = status;
    }
    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
}
