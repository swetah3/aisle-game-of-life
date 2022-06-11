package com.aisle.service;

import java.util.List;

public interface GameOfLife {
    List<List<Integer>> getNext(List<List<Integer>> livingCellCoOrdinates);
}
