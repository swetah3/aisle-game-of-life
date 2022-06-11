package com.aisle.service.impl;

import com.aisle.service.GameOfLife;

import java.util.ArrayList;
import java.util.List;

public class GameOfLifeImpl implements GameOfLife {
    @Override
    public List<List<Integer>> getNext(List<List<Integer>> livingCellCoOrdinates) {
        int[][] board = getBoard(livingCellCoOrdinates);
        int[][] nextState = new int[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j =0; j<board[i].length; j++){
                nextState(i , j ,nextState ,board) ;
            }
        }
        return  getLivingCellCoordinates(nextState);
    }
    private List<List<Integer>> getLivingCellCoordinates(int[][] board){
        List<List<Integer>> livingCellCoordinates = new ArrayList<>();
        for(int row = 0; row< board.length; row++){
            for(int column = 0; column < board[row].length; column++){
                if(board[row][column] == 1){
                    List<Integer> coordinates = new ArrayList<>();
                    coordinates.add(row);
                    coordinates.add(column);
                    livingCellCoordinates.add(coordinates);
                }
            }
        }
        return livingCellCoordinates;
    }
    private int[][] getBoard(List<List<Integer>> livingCellCoOrdinates){
        int maxRowSize = Integer.MIN_VALUE;
        int maxColumnSize = Integer.MIN_VALUE;
        for(List<Integer> cellCoordinate : livingCellCoOrdinates){
            maxRowSize = Math.max(cellCoordinate.get(0),maxRowSize);
            maxColumnSize = Math.max(cellCoordinate.get(1),maxColumnSize);

        }
        int maxSize = Math.max(maxRowSize,maxColumnSize)+1;
        int[][] cellBoard = new int[maxSize][maxSize];
        for(List<Integer> cellCoordinate : livingCellCoOrdinates){

            cellBoard[cellCoordinate.get(0)] [cellCoordinate.get(1)] = 1;
        }
        return cellBoard;
    }
    private  void nextState(int row , int column ,int[][] nextState,int[][] board){
        int[] idx= {-1,-1,-1,0,0,1,1,1};
        int[] idy = {-1,0,1,-1,1,-1,0,1};
        int count = 0 ;
        for(int i=0; i<idx.length; i++){
            int newx = row + idx[i];
            int newy = column +idy[i];
            if(newx >= 0 &&
                    newy >= 0 &&
                    newx <board.length &&
                    newy < board[0].length){
                int value = board[newx][newy];
                if(value == 1) {
                    count ++;
                }
            }
        }
        if(board[row][column] == 1 && (count < 2 || count > 3) ){
            nextState[row][column] = 0 ;
        }
        if (board[row][column] == 1 && ((count == 2 || count == 3))){
            nextState[row][column] = 1 ;
        }
        if(board[row][column]  == 0 && count == 3){
            nextState[row][column] = 1;
        }
    }
}
