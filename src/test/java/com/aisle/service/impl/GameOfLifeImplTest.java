package com.aisle.service.impl;

import com.aisle.service.GameOfLife;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeImplTest {
    private GameOfLife gameOfLife;
    private Comparator<List<Integer>> comparator;
    @BeforeEach
    void init(){
        gameOfLife = new GameOfLifeImpl();
        comparator = (list1, list2) -> {
            if (list1.get(0) < list2.get(0)) {
                return list1.get(0).compareTo(list2.get(0));
            }
            return list1.get(1).compareTo(list2.get(1));
        };

    }
    @Test
    void testBlockPattern() {
        List<List<Integer>> livingCellCoordinates = gameOfLife.getNext(
                Arrays.asList(
                        Arrays.asList(1,1),
                        Arrays.asList(1,2),
                        Arrays.asList(2,1),
                        Arrays.asList(2,2)
                ));
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1,1),
                Arrays.asList(1,2),
                Arrays.asList(2,1),
                Arrays.asList(2,2)
        );
        assertEquals(new HashSet<>(expected), new HashSet<>(livingCellCoordinates));
    }
    @Test
    void testBoatPattern() {
        List<List<Integer>> livingCellCoordinates = gameOfLife.getNext(
                Arrays.asList(
                        Arrays.asList(0,1),
                        Arrays.asList(1,0),
                        Arrays.asList(2,1),
                        Arrays.asList(0,2),
                        Arrays.asList(1,2)
                ));
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0,1),
                Arrays.asList(1,0),
                Arrays.asList(2,1),
                Arrays.asList(0,2),
                Arrays.asList(1,2)
        );
        assertEquals(new HashSet<>(expected), new HashSet<>(livingCellCoordinates));
    }

    @Test
    void testBlinkerPattern() {
        List<List<Integer>> livingCellCoordinates = gameOfLife.getNext(
                Arrays.asList(
                        Arrays.asList(1,1),
                        Arrays.asList(1,0),
                        Arrays.asList(1,2)

                ));
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1,1),
                Arrays.asList(0,1),
                Arrays.asList(2,1)
        );
        assertEquals(new HashSet<>(expected), new HashSet<>(livingCellCoordinates));
    }
    @Test
    void testToadPattern() {
        List<List<Integer>> livingCellCoordinates = gameOfLife.getNext(
                Arrays.asList(
                        Arrays.asList(1,1),
                        Arrays.asList(1,2),
                        Arrays.asList(1,3),
                        Arrays.asList(2,2),
                        Arrays.asList(2,3),
                        Arrays.asList(2,4)

                ));
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0,2),
                Arrays.asList(1,1),
                Arrays.asList(1,4),
                Arrays.asList(2,1),
                Arrays.asList(2,4),
                Arrays.asList(3,3)
        );
        assertEquals(new HashSet<>(expected), new HashSet<>(livingCellCoordinates));
    }
}