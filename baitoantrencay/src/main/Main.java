package main;

import javax.print.attribute.standard.JobName;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException , FileNotFoundException, UnsupportedEncodingException {

        // doc file du lieu :
        Scanner scanner = new Scanner(Paths.get("src\\main\\cache\\m120_4_20"), "UTF-8");
        Information.setTiletonghop(scanner.nextInt());
        Information.setTx(scanner.nextInt());
        Information.setRx(scanner.nextInt());
        Information.setSonut(scanner.nextInt());
        double x;
        for (int i = 0; i < Information.getSonut(); i++) {
            x = scanner.nextInt();
            x = scanner.nextDouble();
            x = scanner.nextDouble();
            x = scanner.nextInt();
            x = scanner.nextInt();
            Information.setReportsize(i, scanner.nextInt());
        }
        Information.setSocanh(scanner.nextInt());
        for (int i = 0; i < Information.getSocanh(); i++) {
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            Information.setArrayEdge(c, d);
            Information.setListEdge(c, d);
        }
        Information.setListBac();
        scanner.close();
        Information.inListEdge();
        Information.inListBac();
        Information.inListBaccha();
        Information.inReportsize();

        Population population = new Population();
        population.setIndividuals();
        population.inIndividuals();
        for(int i = 0 ; i< Information.getSothehe() ; i++){
            System.out.print("the he "+(Information.getSothehe() - i) + " : ");
            population.inIndividual(0);
            population.thehemoi();
        }
        population.inIndividuals();
        System.out.println();
        System.out.print(" ");
//
////      them thong tin tu ket qua cua Bang :
////        ArrayList<ArrayList<Integer>> f = Information.getListBaccha() ;
////        PrintWriter printWriter = new PrintWriter("src\\main\\file ket qua","UTF-8");
////        printWriter.append("9 63 62 49 93 27 4 63 30 41 4 0 9 0 92 99 36 84 16 52 76 67 33 80 55 38 63 23 0 0 62 44 0 86 82 81 8 70 79 23 12 37 85 85 41 47 67 21 38 0 81 59 99 91 85 62 71 2 0 38 60 64 0 59 13 0 76 0 72 0 85 92 58 67 60 0 76 51 0 39 0 95 49 99 79 59 23 27 32 12 20 84 38 9 52 13 0 85 0");
////        printWriter.close();
//
//        // ket qua cua Bang :
//        Scanner scanner23 = new Scanner(Paths.get("src\\main\\file ket qua"), "UTF-8") ;
//        Individual Bang = new Individual() ;
//        for(int i=1 ;  i< Information.getSonut() ; i++ ){
//            Bang.setEdges(i,scanner23.nextInt() );
//        }
//        scanner23.close();
//
//        System.out.println("thong tin ve Bang : ");
//        Bang.setListcon();
////        Bang.inListcon();
//        Bang.setListbac();
//        Bang.inListbac();
    }
}
