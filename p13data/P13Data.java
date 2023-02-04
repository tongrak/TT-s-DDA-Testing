package p13data;
import java.util.LinkedList;

public class P13Data {
       
    private LinkedList<Pair<Integer,Integer>> dataList;
    private int tierCount;

    public int getTierCount() {
        return tierCount;
    }
    // private boolean tierExisted(boolean errable,int reqT) {
    //     boolean result = reqT < 0 || reqT > (tierCount-1);
    //     if(errable && result) 
    //         throw new RuntimeException(reqT+" is out of tier range");
    //     return result;
    // }
    public Pair<Integer,Integer> getDataInTier(int reqT){
        // if(tierExisted(true, reqT)) 
            return this.dataList.get(reqT);
        // else return null;
    }
    public void updateData(int reqT, boolean isCorrect){
        Pair<Integer, Integer> pastData = this.getDataInTier(reqT);
        if(isCorrect) pastData.setFst(pastData.getFst() + 1);
        else  pastData.setSnd(pastData.getSnd() + 1);
    }
    public P13Data(int tierCount){
        this.dataList = new LinkedList<>();
        this.tierCount = tierCount;
        for (int i = 0; i < tierCount; i++) {
            dataList.add(new Pair<Integer,Integer>(0,0));
        }
    }
    @Override
    public String toString() {
        return "{" + dataList + "}";
    }
}
