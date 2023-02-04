package p13data;

public class P13Tier {
    private int theRoof;
    private int theTier = 0;

    public int getTier() {
        return theTier;
    }
    public P13Tier(int tierCount){
        if(tierCount <= 0) throw new RuntimeException("tier cannot be lower than 1");
        this.theRoof = tierCount-1;
    }
    public void incrTier(){
        if(theTier < theRoof) theTier++;
        else System.out.println("Tier cannot higher than " + theRoof);
    }
    public void decrTier(){
        if(theTier > 0) theTier--;
        else System.out.println("Tier cannot go lower than 0");
    }
}
