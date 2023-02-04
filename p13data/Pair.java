package p13data;
public class Pair<T,Y>{
    private T fst;
    private Y snd;
    // public Pair(){}
    public Pair(T fst, Y snd){
        this.fst = fst;
        this.snd = snd;
    }
    public T getFst(){
        return this.fst;
    }
    public void setFst(T fst){
        this.fst = fst;
    }
    public Y getSnd(){
        return this.snd;
    }
    public void setSnd(Y snd){
        this.snd = snd;
    }
    @Override
    public String toString() {
        return "(" + fst + "," + snd + ")";
    }
}
