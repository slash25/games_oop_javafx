package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
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
        BishopBlack bishop = new BishopBlack(Cell.C1);
        assertThat(bishop.copy(Cell.C1), is(bishop));
    }

    @Test
    public void testWayDiag() {

        BishopBlack bishopMov = new BishopBlack(Cell.C1);
        Cell[] moving  = {Cell.C1, Cell.D2, Cell.E3, Cell.F4, Cell.G5 };
        assertThat(bishopMov.way(Cell.C1, Cell.G5), is(moving));
    }

    @Test
    public void testWayDownRightDiag() {
        BishopBlack bishopMov = new BishopBlack(Cell.C1);
        Cell[] moving  = {Cell.D4, Cell.E3, Cell.F2, Cell.G1 };
        assertThat(bishopMov.way(Cell.D4, Cell.G1), is(moving));
    }

   /* @Test
    public void testWayDownRight() {
        BishopBlack bishopMov = new BishopBlack(Cell.C1);
        Cell[] moving  = {Cell.D4, Cell.D3, Cell.D2, Cell.D1};
        assertThat(bishopMov.way(Cell.D4, Cell.D1), is(moving));
    }*/


}
