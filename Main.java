import java.util.LinkedList;

import dda.DDAInter;
import dda.DumbDDA;
import dda.SimpleDDA;
import p13data.Pair;
import p13mockengine.P13Mock;

public class Main {
    public static void main(String[] args) {
        Pair<Integer, Integer> tier0w = new Pair<Integer,Integer>(1, 2);
        Pair<Integer, Integer> tier1w = new Pair<Integer,Integer>(1, 3);
        Pair<Integer, Integer> tier2w = new Pair<Integer,Integer>(1, 4);
        LinkedList<Pair<Integer, Integer>> configList = new LinkedList<>();
        configList.add(tier0w);
        configList.add(tier1w);
        configList.add(tier2w);

        DDAInter theDDA;
        try {
            theDDA = new SimpleDDA(configList, 2);
            P13Mock theMock = new P13Mock(3, theDDA);
            theMock.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
