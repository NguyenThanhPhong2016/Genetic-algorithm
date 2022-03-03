package main;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Information {
    //thong tin :

    private static int Tiletonghop ; // so goi toi da gui trong 1 lan
    private static int Tx          ; // nang luong de
    private static int Rx          ; // nang luong de nhan
    private static int Sonut       ;
    private static int[] Reportsize; // kich co bao cao cua tung nut\
    private static int Socanh      ;
    private static ArrayList< ArrayList<Integer> >  ListEdge ;
    private static int[][]                          ArrayEdge ;
    private static ArrayList< ArrayList<Integer> >  ListBac ;
    private static ArrayList< ArrayList<Integer> >  ListBaccha ;

    private static final int Max = 1000; // so phan tu toi da cua 1 quan the
    private static final int Sothehe = 1000;
    private static final int tiledotbien = 100 ; // don vi : %
    private static final int tilelai = 70 ;    // don vi : %
     //khoi tao :

    public Information() {
    }

    //phuong thuc :

    public static int getMax() {
        return Max;
    }

    public static int getSothehe() {
        return Sothehe;
    }

    public static int getTiledotbien() {
        return tiledotbien;
    }

    public static int getTilelai() {
        return tilelai;
    }

    public static void setSocanh(int socanh) {
        Socanh = socanh;
    }
    public static void setListEdge(int i,int j){
        ListEdge.get(i).add(j) ;
    }
    public static void setTx(int tx) {
        Tx = tx;
    }
    public static void setRx(int rx) {
        Rx = rx;
    }
    public static void setSonut(int sonut) {
        Sonut = sonut;
        Reportsize = new int[Sonut] ;
        ArrayEdge  = new int[Sonut][Sonut] ;
        ListEdge   = new ArrayList<>();
        for(int i =0  ; i < Sonut ; i++ ){
            ArrayList<Integer> x = new ArrayList<>() ;
            ListEdge.add(x) ;
        }
    }
    public static void setReportsize(int x, int y) {
        Reportsize[x] = y ;
    }
    public static void setTiletonghop(int tiletonghop) {
        Tiletonghop = tiletonghop;
    }
    public static void setArrayEdge(int i ,int j ){
        ArrayEdge[i][j] = 1  ;
    }

    public static void setListBac() {
        ListBac    = new ArrayList<>();
        ListBaccha = new ArrayList<>();
        for(int i = 0 ; i < Sonut ; i ++ ){
            ArrayList<Integer> x = new ArrayList<>()  ;
            ListBaccha.add(x) ;
        }
        int[] a = new int[Sonut];
        for (int i = 0; i < Sonut; i++) {
            a[i] = 0;
        }
        a[0] = 1;
        ArrayList<Integer> y = new ArrayList<>();
        y.add(0);
        ListBac.add(y);
        for (int i = 1; i < Sonut; i++) {
            ArrayList<Integer> x = new ArrayList<>();
            for (int j = 0; j < ListBac.get(i - 1).size(); j++) {
                int l = ListBac.get(i - 1).get(j);
                for(int k = 0;k <  ListEdge.get(l).size(); k++) {
                    if (a[ListEdge.get(l).get(k)] == 0) {
                        x.add(ListEdge.get(l).get(k));
                        a[ListEdge.get(l).get(k)] = 1;
                        ListBaccha.get(ListEdge.get(l).get(k)).add(l) ;
                    }
                }
            }
            ListBac.add(x);
        }
        for(int i = 0 ; i< ListBac.size();i++){
            ListBac.get(i).sort(Integer::compareTo) ;
            ListBaccha.get(i).sort(Integer::compareTo);
        }
    }
    public static int getArrayEdge(int i,int j){
        return ArrayEdge[i][j];
    }
    public static int getTiletonghop() {
        return Tiletonghop;
    }
    public static int getTx() {
        return Tx;
    }
    public static int getRx() {
        return Rx;
    }
    public static int getSonut() {
        return Sonut;
    }
    public static int getReportsize(int i ) {
        return Reportsize[i];
    }
    public static int getSocanh() {
        return Socanh;
    }
    public static ArrayList<ArrayList<Integer>> getListBaccha() {
        return ListBaccha;
    }
    public static ArrayList<ArrayList<Integer>> getListEdge() {
        return ListEdge;
    }

    // ham :

    public static void inReportsize(){
        System.out.println("inReportsize : ");
        for(int i = 0 ; i< Sonut ;i ++){
            System.out.println("Reportsize  " +i+  " "+Reportsize[i]);
        }
    }
    public static void inListEdge(){
        System.out.println("inListEdge :");
        for(int i=0;i<Sonut ;i++){
            if(ListEdge.get(i).size() ==0 ) continue;
            System.out.print("dinh "+ i + " : ");
            for(int j=0;j< ListEdge.get(i).size();j++){
                System.out.print( " "+ ListEdge.get(i).get(j));
            }
            System.out.println();
        }
    }
    public static void inListBac(){
        System.out.println("In ra ListBac : ");
        for(int i=0;i<Sonut ;i++){
            if(ListBac.get(i).size() ==0 ) continue;
            System.out.print("bac "+ i + " : ");
            for(int j=0;j< ListBac.get(i).size();j++){
                System.out.print( " "+ ListBac.get(i).get(j));
            }
            System.out.println();
        }
    }
    public static void inListBaccha(){
        System.out.println("In ra ListBaccha : ");
        for(int i=0;i<Sonut ;i++){
            if(ListBaccha.get(i).size() ==0 ) continue;
            System.out.print("bac "+ i + " : ");
            for(int j=0;j< ListBaccha.get(i).size();j++){
                System.out.print( " "+ ListBaccha.get(i).get(j));
            }
            System.out.println();
        }
    }
}
