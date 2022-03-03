package main;

import java.util.ArrayList;
import java.util.Collections;

public class individual {
    //thong tin :
    private ArrayList<Integer> Path ;
    private int Fitness ;
    int[][] Map = information.getMap();
    //khoi tao :
    public individual(){
        this.Path  = new ArrayList<>();
        start(this.Path); //tao moi Path
        setFitness();
    }
    //phuong thuc :

    public void setPath(){
        Collections.shuffle(Path);
    }
    public void setPath(int i , int j ) {
        int c = Path.get(i);
        Path.set(i,Path.get(j));
        Path.set(j,c);
    }
    public void setPath(ArrayList<Integer> Path) {
        this.Path = Path;
    }
    public void setPath(int j,int i,int value){
        Path.set(i,value);
    }
    public void setFitness() {
        this.Fitness = tinhquangduong(Path);
    }
    public int getPath(int i){
        return Path.get(i);
    }
    public int getFitness() {
        return Fitness;
    }
    //ham :

    public void inPath(){
        System.out.print("Path : ");
        for(int i=0;i<information.getSodinh();i++){
            System.out.print(" "+Path.get(i));
        }
    }
    public void start(ArrayList<Integer> a){
        for(int i =0 ;i<information.getSodinh();i++){
            a.add(i);
        }
    }
    public int tinhquangduong(ArrayList<Integer> a){
        int sum = 0;
        for (int i = 0; i < information.getSodinh(); i++) {
            sum = sum + Map[a.get(i)][a.get((i + 1) % information.getSodinh())];
        }
        return sum;
    }
}
