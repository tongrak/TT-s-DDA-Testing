package dda;

import java.util.LinkedList;

import p13data.P13Data;
import p13data.P13Tier;
import p13data.Pair;

public class SimpleDDA implements DDAInter {
    int bar = 0;
    LinkedList<Pair<Integer,Integer>> weightList;
    LinkedList<Pair<Integer,Integer>> pastState = null;


    public SimpleDDA(LinkedList<Pair<Integer,Integer>> configList, int bar) throws Exception {
        if(configList.size() != 3) 
            throw new Exception("config list isn't 3");
        else weightList = configList;
        this.bar = bar;
    }

    void keepPastState(P13Data currData){
        LinkedList<Pair<Integer,Integer>> holder = new LinkedList<>();
        for (int i=0; i < 3; i++){
            int fst = currData.getDataInTier(i).getFst();
            int snd = currData.getDataInTier(i).getSnd();
            holder.add(new Pair<Integer,Integer>(fst, snd));
        }
        this.pastState = holder;
    }

    @Override
    public DDAAct getNextAct(P13Data currData, P13Tier currTier) {

        int tier = currTier.getTier();
        Pair<Integer,Integer> currTierData = currData.getDataInTier(tier);
        Pair<Integer,Integer> currWeighPair = weightList.get(tier);
        int result = currWeighPair.getFst()*currTierData.getFst() - currWeighPair.getSnd()*currTierData.getSnd();
        
        DDAAct verdict;

        if(result < 0) {
            int corrDiff = 0;
            if(this.pastState != null) 
                corrDiff = currTierData.getFst()-pastState.get(tier).getFst();
            verdict = (corrDiff>0)?DDAAct.MAINTAIN:DDAAct.DECREASE;
        }
        else if(result < bar) verdict = DDAAct.MAINTAIN;
        else verdict = DDAAct.INCREASE;

        keepPastState(currData);

        return verdict;
    }
    
}
