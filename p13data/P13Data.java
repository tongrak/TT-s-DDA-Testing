package p13data;
import java.util.LinkedList;

public class P13Data {
       
    private LinkedList<Pair<Integer,Integer>> dataList;
    private int tierCount;

    public int getTierCount() {
        return tierCount;
    }
    
    public Pair<Integer,Integer> getDataInTier(int reqT){
        return this.dataList.get(reqT);
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
