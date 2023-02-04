package dda;

import p13data.P13Data;
import p13data.P13Tier;
import p13data.Pair;

public class DumbDDA implements DDAInter {
    
    public DumbDDA() {
    }

    @Override
    public DDAAct getNextAct(P13Data currData, P13Tier pt) {
        int totalDiff = 0;
        for (int i = 0; i < currData.getTierCount(); i++) {
            Pair<Integer, Integer> pii =  currData.getDataInTier(i);
            if((pii.getFst()-pii.getSnd()) < 0) return DDAAct.DECREASE;
            totalDiff += pii.getFst()-pii.getSnd();
        }
        if(totalDiff == 0) return DDAAct.MAINTAIN;
        else return DDAAct.INCREASE;
    }
    
}
