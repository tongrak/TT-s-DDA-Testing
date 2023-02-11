package p13mockengine;

import java.util.Scanner;

import dda.DDAInter;
import dda.DumbDDA;
import p13data.P13Data;
import p13data.P13Tier;

public class P13Mock {

    private Scanner scan = new Scanner(System.in);
    // private static P13Mock selfObj;
    private boolean isRunning = true;
    private P13Data gameData;
    private DDAInter theDDA;
    private P13Tier currLayer;
    
    public P13Mock(int tierCount, DDAInter theDDA){
        this.gameData = new P13Data(tierCount);
        this.currLayer = new P13Tier(tierCount);
        this.theDDA = theDDA;
    }

    private String getConsoleInput(String text){
        System.out.print(text);
        return this.scan.nextLine();
    }

    private void printStatus(P13Data theData){
        System.out.println("Current Status: " + theData);
        System.out.println("Current Tier: " + currLayer.getTier());
    }

    private void performDDAact(){
        switch (theDDA.getNextAct(gameData, currLayer)) {
            case INCREASE:
                this.currLayer.incrTier();
                break;
            case MAINTAIN:
                break;
            case DECREASE:
                this.currLayer.decrTier();
                break;
        }
    }

    private void runDDA(){
        boolean isDone = false;
        do {
            printStatus(this.gameData);
            String inp = getConsoleInput("is Correct? (yes or no)>").toUpperCase();
            if(inp.equals("YES") || inp.equals("NO")){
                this.gameData.updateData(this.currLayer.getTier(), 
                    inp.equals("YES"));
                performDDAact();
            }else if(inp.equals("END")){
                isDone = true;
            }else System.out.println("Invalid command");          
        } while (!isDone);
    }

    public void run(){
        System.out.println("P13's DDA testing (type END to quit)");
        System.out.println("type BEGIN to start testing DDA");        
        do {
            String inp = getConsoleInput(">");

            if(inp.toUpperCase().equals("END")) 
                this.isRunning = false;
            else if(inp.toUpperCase().equals("BEGIN")) 
                runDDA();

        } while (isRunning);
    }
}
