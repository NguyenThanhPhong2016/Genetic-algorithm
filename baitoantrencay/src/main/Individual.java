package main;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Individual {
    //thong tin :

    private int[] Edges ;
    private int Fitness ;
    private ArrayList<ArrayList<Integer> > Listcon ;
    private int[] Bac;
    private int[] Des;
//    private ArrayList<ArrayList<Integer> > Listbac ; // cai nay de kiem tra
    // khoi tao :

    public Individual() {
        Edges = new int[Information.getSonut()] ;
        for(int i= 0; i < Information.getSonut();i++){
            Edges[i] = -1 ;
        }
        Edges[0]=0;
    }
    // phuong thuc :

    ArrayList<ArrayList<Integer> > ListBaccha = Information.getListBaccha() ;
    ArrayList<ArrayList<Integer> > ListEdge   = Information.getListEdge()   ;
    Random random = new Random() ;
    public void setEdges(){
        Bac = new int[Information.getSonut()] ;
        Bac[0] = 0 ;
        int x =0 ;
        while(x==0){
            x=1 ;
            for(int i = 0 ;i< Information.getSonut();i++){
                if(Edges[i] ==-1 ){
                    for(int j = 0; j < ListEdge.get(i).size();j++){
//                        if( Edges[ListEdge.get(i).get(j)]  != -1 && random.nextInt(100)> (100 - (int) 100 / (Bac[ListEdge.get(i).get(j)] + 1) ) ){
//                            Edges[i] = ListEdge.get(i).get(j) ;
//                            Bac[i] = Bac[ListEdge.get(i).get(j)] +1 ;
//                            break;
//                        }
                        if( Edges[ListEdge.get(i).get(j)]  != -1 && random.nextInt(100)> 50 ){
                            Edges[i] = ListEdge.get(i).get(j) ;
                            Bac[i] = Bac[ListEdge.get(i).get(j)] +1 ;
                            break;
                        }
                    }
                    if(Edges[i] == -1 ) x=0;
                }
            }
        }
    }
    public void setBac(){
        Bac = new int[Information.getSonut()] ;
        Bac[0] = 0 ;
        int[] E = new int[Information.getSonut()];
        for(int i =0  ; i < Information.getSonut() ; i++){
            E[i] = -1 ;
            Bac[i] = -1 ;
        }
        E[0] = 0 ;
        Bac[0] = 0 ;
        int x = 0 ;
        while(x==0 ) {

            x = 1;
            for (int i = 0; i < Information.getSonut(); i++) {
                if (Bac[i] == -1) {
                    if( Bac[ Edges[i] ] != -1 ){
                        Bac[i] = Bac[ Edges[i] ] + 1;
                    }
                    else x= 0 ;
                }
            }
        }
    }
    public void setListcon(){
        Listcon = new ArrayList<>() ;
        for(int i = 0 ; i < Information.getSonut();i++){
            ArrayList<Integer> x = new ArrayList<>() ;
            Listcon.add(x);
        }
        for(int i = 1 ; i< Information.getSonut() ; i++) {
            int x = i;
            while (x != 0) {
                Listcon.get(Edges[x]).add(i);
                x = Edges[x];
            }
        }
    }
    public void setEdges(int i , int value){
        Edges[i] = value ;
    }
//    public void setListbac() {
//        Listbac = new ArrayList<>();
//        for (int i = 0; i < Information.getSonut(); i++) {
//            ArrayList<Integer> x = new ArrayList<>();
//            Listbac.add(x);
//        }
//        Listbac.get(0).add(0);
//        for (int i = 1; i < Information.getSonut(); i++) {
//            if (Listbac.get(i - 1).size() == 0) break;
//            for (int j = 0; j < Listbac.get(i - 1).size(); j++) {
//                int h = Listbac.get(i - 1).get(j);
//                for (int k = 0; k < Listcon.get(h).size(); k++) {
//                    Listbac.get(i).add(Listcon.get(h).get(k));
//                }
//            }
//        }
//        for(int i = 1 ; i< Information.getSonut() ; i++){
//            if(Listbac.get(i-1).size()==0) break ;
//            Listbac.get(i).sort(Integer::compareTo);
//        }
//    }
//    public void setListcon(){
//        Listcon = new ArrayList<>() ;
//        for(int i = 0 ; i< Information.getSonut() ; i++ ){
//            ArrayList<Integer> x = new ArrayList<>() ;
//            Listcon.add(x) ;
//        }
//        for(int i = 1 ; i< Information.getSonut(); i++ ){
//            Listcon.get(Edges[i]).add(i) ;
//        }
//    }
    public void setDes(int n){
        for(int i = 0;i < Listcon.get(n).size();i++){
            Des[n] = Des[n] + Des[Listcon.get(n).get(i)];
        }
        setDes(7);
    }
    public void setFitness(){
        Des = new int[Information.getSonut()] ;
        for(int i = 0 ;  i< Information.getSonut() ; i++){
            Des[i] = Information.getReportsize(i);
        }
        int[] Des1 = new int[Information.getSonut()] ;
        for(int i = 0 ;  i< Information.getSonut() ; i++){
            Des1[i] = Information.getReportsize(i);
        }
        for(int i = 1 ; i< Information.getSonut() ; i++) {
            int x = i;
            while (x != 0) {
                Des[Edges[x]] = Des1[i] + Des[Edges[x]];
                x = Edges[x];
            }
        }
        int sum = 0 ;
        for(int i = 1 ;  i < Information.getSonut() ;  i++ ){
            if(Des[i] % Information.getTiletonghop() ==0) sum = sum + Des[i] / Information.getTiletonghop();
            else sum = sum + ((int) Des[i] / Information.getTiletonghop() )+1 ;
        }
        Fitness = sum * ( Information.getRx() + Information.getTx()) ;
    }
    public int getFitness() {
        return Fitness;
    }
    public int getEdges(int i){
        return  Edges[i];
    }
    public int getBac(int i ){
        return Bac[i] ;
    }
    public ArrayList<Integer> getListcon(int i){
        return Listcon.get(i);
    }
    //ham :
    public void inEdges(){
        System.out.println("inEdges : ");
        for(int i = 0; i< Information.getSonut();i++){
            System.out.print(  Edges[i] + " ");
        }
        System.out.println();
    }
    public void inEdges1(){

    }

//    public void inListcon(){
//        System.out.println();
//        System.out.println("inListcon : ");
//        for(int i = 0 ; i< Listcon.size() ; i++ ) {
//            if(Listcon.get(i).size() ==0 ) continue;
//            System.out.print("dinh " + i + " : ");
//            for (int j = 0; j < Listcon.get(i).size(); j++) {
//                System.out.print(" " + Listcon.get(i).get(j));
//            }
//            System.out.println();
//        }
//    }
//    public void inListbac(){
//        System.out.println();
//        System.out.println("inListbac : ");
//        for(int i = 0 ; i< Listcon.size() ; i++ ) {
//            if(Listbac.get(i).size() ==0 ) continue;
//            System.out.print("bac " + i + " : ");
//            for (int j = 0; j < Listbac.get(i).size(); j++) {
//                System.out.print(" " + Listbac.get(i).get(j));
//            }
//            System.out.println();
//        }
//    }
}
