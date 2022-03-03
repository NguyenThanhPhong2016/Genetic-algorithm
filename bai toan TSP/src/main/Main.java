package main;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner ;

public class Main {

    public static void main(String[] args) throws IOException {
        //them thong tin :

        Scanner scanner = new Scanner(Paths.get("src\\main\\data_17.txt"),"UTF-8") ;
        for (int i = 0; i < information.getSodinh(); i++){
            for(int j=0;j< information.getSodinh();j++){
                information.setMap(i,j,scanner.nextInt());
            }
        }
        scanner.close();
        //tim ket qua toi uu :
        //information.inMap(); //in ra ban do
        population x = new population();
        x.setIndividuals();
        for(int i =0;i<information.getSothehe();i++){
            System.out.print("the he thu : "+i);
            System.out.print(" : " + x.getIndividuals().get(0).getFitness()+"\n");
            x.thehemoi();
//            if(i== information.getSothehe() -1) x.inIndividual();
        }
        //x.inIndividual();
        x.inIndividual(0);

        //ket qua bai toan :
        System.out.println("ket qua bai toan :");
        Scanner scanner1 = new Scanner(Paths.get("src\\main\\path_17.txt"),"UTF-8");
        ArrayList<Integer> h = new ArrayList<>();
        for(int i=0;i < information.getSodinh();i++){
            h.add(scanner1.nextInt());
        }
        scanner1.close();
        individual min = new individual();
        min.setPath(h);
        min.setFitness();
        min.inPath();
        System.out.println(" fitness : " + min.getFitness());
    }
}
