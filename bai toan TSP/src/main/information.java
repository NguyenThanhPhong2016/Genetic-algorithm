package main;

public class information {
    //thong tin:

    private static final int Sodinh = 17;
    private static final int[][] Map = new int[Sodinh][Sodinh];
    private static final int Max = 2000; // so phan tu toi da cua 1 quan the
    private static final int Sothehe = 100;
    private static final int tiledotbien = 50 ; // don vi : %
    private static final int tilelai = 90 ;    // don vi : %
    //khoi tao :

    public information(){
    }
    //phuong thuc :


    public static int getTilelai() {
        return tilelai;
    }
    public static int getTiledotbien() {
        return tiledotbien;
    }
    public static void setMap(int i, int j , int x){
        Map[i][j]=x;
    }
    public static int getSodinh() {
        return Sodinh;
    }
    public static int[][] getMap() {
        return Map;
    }
    public static int getMax() {
        return Max;
    }
    public static int getSothehe() {
        return Sothehe;
    }
    //ham :

    public static void inMap(){
        for(int i=-1;i<Sodinh;i++){
            System.out.printf("%5d  ",i);
        }
        for(int i=0;i<Sodinh;i++){
            System.out.println();
            System.out.printf("%5d  ",i);
            for(int j=0;j<Sodinh;j++){
                System.out.printf("%5d  ", Map[i][j] );
            }
        }
    }
}
