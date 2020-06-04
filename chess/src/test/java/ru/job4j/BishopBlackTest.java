package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {
    @Test
    public void testPosition() {
        BishopBlack bishop = new BishopBlack(Cell.B1);
            assertThat(bishop.position(),is(Cell.B1));

    }

    @Test
    public void testCopy() {
        BishopBlack bishop = new BishopBlack(Cell.G1);
        assertThat(bishop.copy(Cell.G1), is(Cell.G1));
    }

    @Test
    public void testWay() {

        BishopBlack bishopMov = new BishopBlack(Cell.C1);
        ArrayList<Cell> moving  = new ArrayList<>();

        moving.add(Cell.D2);
        moving.add(Cell.E3);
        moving.add(Cell.F4);
        moving.add(Cell.G5);
        assertThat(bishopMov.way(Cell.C1, Cell.G5),is(moving));

    }

}
