class Helper {
    private final int larger;
    private final int smaller;

    public Helper(int x, int y){
        this.larger = Integer.max(x,y);
        this.smaller = Integer.min(x,y);
    }

    public Helper euclid() {
        return new Helper(smaller, larger%smaller);
    }

    public int smaller(){
        return this.smaller;
    }

    public int larger(){
        return this.larger;
    }

}