package main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Population {
    //thong tin :

    ArrayList<Individual> Individuals ;
    // khoi tao :

    public Population(){
    }
    //phuong thuc :
    public void setIndividuals(){
        Individuals = new ArrayList<>() ;
        for(int i = 0 ; i< Information.getMax() ;  i++){
            Individual x= new Individual() ;
//            System.out.println("dang chay day");
            x.setEdges();
            x.setListcon();
            x.setFitness();
            Individuals.add(x) ;
        }
        quicksort(Individuals , 0 , Individuals.size() -1);
    }
    //ham :
    public void quicksort(ArrayList<Individual> a,int x, int y){

        int h = a.get( (int) (x+y) /2 ).getFitness() ;
        int i = x, j =y ;
        while(i<j){
            while( a.get(i).getFitness() < h ) i++;
            while( a.get(j).getFitness() > h ) j--;
            if(i<=j){
                Individual z = a.get(i);
                a.set(i,a.get(j));
                a.set(j,z);
                i++;
                j--;
            }
        }
        if(i<y) quicksort(a,i,y);
        if(j>x) quicksort(a,x,j);
    }
    Random random = new Random() ;
    public void thehemoi(){
        for(int i= 0 ;i < (int)Information.getMax()/2;i++){
            if(random.nextInt(100) < Information.getTilelai() ) reproduction1(Individuals.get(i),Individuals.get(Information.getMax()-1-i));
        }
        quicksort(Individuals,0,Individuals.size()-1);
        ArrayList<Individual> temp = new ArrayList<>();
        for(int i=0;i<Information.getMax();i++){
            temp.add(Individuals.get(i));
        }
        this.Individuals = temp ;
        temp = null;
    }
    public void chon(Individual x ,Individual individual , int n){
        for(int i = 1 ;  i< Information.getSonut() ;  i ++){
            if( individual.getEdges(i) == n && random.nextInt(100)> (100 - (int) 100 / ( individual.getBac(i) + 0.1) )  ){
                x.setEdges(i,n);
                chon(x,individual,i);
            }
        }
    }
    int dem = 1;
    public void reproduction1(Individual individual1, Individual individual2) {
        Individual x = new Individual();
        chon(x,individual1,0);
        for(int i = 0 ; i< Information.getSonut() ; i++){
            if(x.getEdges(i) ==-1 ){
                x.setEdges( i, individual2.getEdges(i) );
            }
        }
        Individual y = new Individual();
        chon(y,individual2,0);
        for(int i = 0 ; i< Information.getSonut() ; i++){
            if(y.getEdges(i) ==-1 ){
                y.setEdges( i, individual2.getEdges(i) );
            }
        }
        dem++;
        if( random.nextInt(100) < Information.getTiledotbien() ){
            x.setBac();
            x.setListcon();
            mutation1(x);
        }
        dem++;
        if( random.nextInt(100) < Information.getTiledotbien() ) {
            y.setBac();
            y.setListcon();
            mutation1(y);
        }
        x.setBac();
        y.setBac();
        x.setFitness();
        y.setFitness();
        Individuals.add(x);
        Individuals.add(y);
    }
    private static ArrayList< ArrayList<Integer> >  ListEdge = Information.getListEdge() ;
    public void mutation1(Individual a){
        int y = random.nextInt(Information.getSonut()-1)+1;
        int x = 0;
        int k = 0 ;
        while(k<10 || x == y){
            x = random.nextInt(Information.getSonut()-1)+1;
            if( x != y && Information.getArrayEdge(x,y) == 1 && !a.getListcon(y).contains(x)  ){
                a.setEdges(y,x);
                k=10;
            }
            else{
                k++;
            }
        }
    }
    public void mutation(Individual a){
        int k = 0 ;
        int y = 0;
        while(k<20 && y < 10 ){
            int x = random.nextInt(Information.getSonut()-1) +1 ;
            for(int i =  0; i < ListEdge.get(x).size() ; i ++){
                if( a.getBac( ListEdge.get(x).get(i) ) < a.getBac(x)  ){
                    a.setEdges(x,ListEdge.get(x).get(i) );
                    k++;
                    break ;
                }
            }
//            x++;
        }
    }
    public void inIndividuals(){
        System.out.println("inIndividuals : ");
        for(int i = Individuals.size() -1 ; i >=0;i--){
            System.out.println(" Individual "+ i +  " : "+Individuals.get(i).getFitness());
            if(i<3){ Individuals.get(i).inEdges();
            System.out.println();}
        }
    }
    public void inIndividual(int i){
        System.out.print(" "+Individuals.get(i).getFitness());
        System.out.println();
    }

}
