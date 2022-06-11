package com.aisle;

import com.aisle.service.GameOfLife;
import com.aisle.service.impl.GameOfLifeImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            GameOfLife gameOfLife = new GameOfLifeImpl();
            List<List<Integer>> livingCellCoOrdinates = new ArrayList<>();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the number of living cell");
            int numberOfCoordinate = sc.nextInt();
            System.out.println("Enter the comma separated Coordinates");
            sc.nextLine();
            while (numberOfCoordinate-- > 0){
                String line = sc.nextLine();
                String[] coOrdinate = line.split(",");
                List<Integer> livingCell = new ArrayList<>();

                for (int i=0;i< coOrdinate.length;i++){
                    livingCell.add(Integer.parseInt(coOrdinate[i].trim()));
                }
                livingCellCoOrdinates.add(livingCell);
            }
            System.out.println(gameOfLife.getNext(livingCellCoOrdinates));
        }

    }
