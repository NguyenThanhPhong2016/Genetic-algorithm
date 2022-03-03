package main;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;
import java.util.SplittableRandom;

public class population {
    //thong tin :

    private ArrayList<individual> Individuals ;

    //khoi tao :

    public population(){
    }

    //phuong thuc :

    public void setIndividuals() {
        Individuals = new ArrayList<>();
        for(int i = 0; i< information.getMax(); i++){
            Individuals.add(new individual());
        }
        quicksort(Individuals,0, information.getMax()-1);
    }
//    public void setIndividuals(individual x){
//        Individuals.add(x);


    public ArrayList<individual> getIndividuals() {
        return Individuals;
    }

    //ham :

    public void thehemoi(){

        for(int i= 0 ;i < (int)information.getMax()/2;i++){
            if(random.nextInt(100) < information.getTilelai() ) reproduction1(Individuals.get(i),Individuals.get(information.getMax()-1-i));
        }
        quicksort(Individuals,0,Individuals.size()-1);
        ArrayList<individual> temp = new ArrayList<>();
        for(int i=0;i<information.getMax();i++){
            temp.add(Individuals.get(i));
        }
        this.Individuals = temp ;
        temp = null;
    }
    public void quicksort(ArrayList<individual> a,int x, int y){

        int h = a.get( (int) (x+y) /2 ).getFitness() ;
        int i = x, j =y ;
        while(i<j){
            while( a.get(i).getFitness() < h ) i++;
            while( a.get(j).getFitness() > h ) j--;
            if(i<=j){
                individual z = a.get(i);
                a.set(i,a.get(j));
                a.set(j,z);
                i++;
                j--;
            }
        }
        if(i<y) quicksort(a,i,y);
        if(j>x) quicksort(a,x,j);
    }
    Random random = new Random();
    public void mutation(int i){
        int x = random.nextInt(information.getSodinh());
        int y;
        do{ y = random.nextInt(information.getSodinh());} while(x==y);
        Individuals.get(i).setPath(x,y);
        Individuals.get(i).setFitness();
    }
    public void mutation(individual a){
        int x = random.nextInt(information.getSodinh());
        int y;
        do{ y = random.nextInt(information.getSodinh());} while(x==y);
        a.setPath(x,y);
        a.setFitness();
    }
    public void reproduction1(individual a , individual b){
        individual x = new individual() ;
        int[] c = new int[information.getSodinh()];
        int averagevalue = (int) information.getSodinh() /2 ;
        for(int i = information.getSodinh() -1 ; i > averagevalue ;i--){
            x.setPath(0, i - averagevalue -1 , a.getPath(i) ) ;
            c[a.getPath(i)] = 1 ;
        }
        averagevalue = information.getSodinh()- averagevalue -1  ;
        for(int i = (int) information.getSodinh() /2 ;i< information.getSodinh();i++){
            if( c[b.getPath(i)] == 0 ){
                x.setPath(0,averagevalue,b.getPath(i));
                averagevalue ++ ;
            }
        }
        for(int i = 0 ;i< (int) information.getSodinh() /2;i++){
            if( c[b.getPath(i)] == 0 ){
                x.setPath(0,averagevalue,b.getPath(i));
                averagevalue ++ ;
            }
        }
        if(random.nextInt(100) < information.getTiledotbien() ) mutation(x);
//        mutation(x);
        x.setFitness();
        Individuals.add(x);
        individual y = new individual();
        int[] d = new int[information.getSodinh()];
        averagevalue = (int) information.getSodinh() /2 ;
        for(int i = information.getSodinh() -1 ; i > averagevalue ;i--){
            y.setPath(0, i - averagevalue -1 , b.getPath(i) ) ;
            d[b.getPath(i)] = 1 ;
        }
        averagevalue = information.getSodinh()- averagevalue -1  ;
        for(int i = (int) information.getSodinh() /2 ;i< information.getSodinh();i++){
            if( d[a.getPath(i)] == 0 ){
                y.setPath(0,averagevalue,a.getPath(i));
                averagevalue ++ ;
            }
        }
        for(int i = 0 ;i< (int) information.getSodinh() /2;i++){
            if( d[a.getPath(i)] == 0 ){
                y.setPath(0,averagevalue,a.getPath(i));
                averagevalue ++ ;
            }
        }
        if(random.nextInt(100) < information.getTiledotbien() ) mutation(y);
//        mutation(y);
        y.setFitness();
        Individuals.add(y);
    }
    public void reproduction(individual a , individual b){
        individual x = new individual() ;
        int[] c = new int[information.getSodinh()];
        int averagevalue = (int) information.getSodinh() /2 ;
        for(int i = information.getSodinh() -1 ; i > averagevalue ;i--){
            x.setPath(0, i , a.getPath(i) ) ;
            c[a.getPath(i)] = 1 ;
        }
        averagevalue = 0;
        for(int i = (int) information.getSodinh() /2 ;i< information.getSodinh();i++){
            if( c[b.getPath(i)] == 0 ){
                x.setPath(0,averagevalue,b.getPath(i));
                averagevalue ++ ;
            }
        }
        for(int i = 0 ;i< (int) information.getSodinh() /2;i++){
            if( c[b.getPath(i)] == 0 ){
                x.setPath(0,averagevalue,b.getPath(i));
                averagevalue ++ ;
            }
        }
//        if(random.nextInt(100) < 50 ) mutation(x);
        mutation(x);
        x.setFitness();
        Individuals.add(x);
        individual y = new individual();
        int[] d = new int[information.getSodinh()];
        averagevalue = (int) information.getSodinh() /2 ;
        for(int i = information.getSodinh() -1 ; i > averagevalue ;i--){
            y.setPath(0, i , b.getPath(i) ) ;
            d[b.getPath(i)] = 1 ;
        }
        averagevalue=0;
        for(int i = (int) information.getSodinh() /2 ;i< information.getSodinh();i++){
            if( d[a.getPath(i)] == 0 ){
                y.setPath(0,averagevalue,a.getPath(i));
                averagevalue ++ ;
            }
        }
        for(int i = 0 ;i< (int) information.getSodinh() /2;i++){
            if( d[a.getPath(i)] == 0 ){
                y.setPath(0,averagevalue,a.getPath(i));
                averagevalue ++ ;
            }
        }
        //if(random.nextInt(100) < 50 ) mutation(y);
        mutation(y);
        y.setFitness();
        Individuals.add(y);
    }

    public void inIndividual(){
        System.out.println("xuat tap hop :");
        for(int i = Individuals.size()-1; i>=0; i--){
            System.out.print("phan tu thu  "+ i + " : \n");
            Individuals.get(i).inPath();
            System.out.print(" : " + Individuals.get(i).getFitness()+"\n");
        }
    }
    public void inIndividual(int i){
        System.out.print("phan tu thu  "+ i + " : \n");
        Individuals.get(i).inPath();
        System.out.print(" : " + Individuals.get(i).getFitness()+"\n");
    }
}
