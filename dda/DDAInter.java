package dda;
import p13data.P13Data;
import p13data.P13Tier;

public interface DDAInter {
    DDAAct getNextAct(P13Data currData, P13Tier currTier);
}
