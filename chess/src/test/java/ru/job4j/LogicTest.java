package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.*;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LogicTest {
    @Test
    public void moveTest() {
        Logic bishopTestWay = new Logic();
        RookBlack rookBlack = new RookBlack(Cell.A1);
        KnightBlack knightBlack = new KnightBlack(Cell.B1);
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        QueenBlack queenBlack = new QueenBlack(Cell.D1);
        KingBlack kingBlack = new KingBlack(Cell.E1);
        BishopBlack bishopBlackR = new BishopBlack(Cell.F1);
        KnightBlack knightBlackR = new KnightBlack(Cell.G1);
        RookBlack rookBlackR = new RookBlack(Cell.H1);
        PawnBlack pawnBlack1 = new PawnBlack(Cell.A2);
        PawnBlack pawnBlack2 = new PawnBlack(Cell.B2);
        PawnBlack pawnBlack3 = new PawnBlack(Cell.C2);
        PawnBlack pawnBlack4 = new PawnBlack(Cell.D2);
        PawnBlack pawnBlack5 = new PawnBlack(Cell.E2);
        PawnBlack pawnBlack6 = new PawnBlack(Cell.F2);
        PawnBlack pawnBlack7 = new PawnBlack(Cell.G2);
        PawnBlack pawnBlack8 = new PawnBlack(Cell.H2);

        bishopTestWay.add(bishopBlack);
        bishopTestWay.add(rookBlack);
        bishopTestWay.add(knightBlack);
        bishopTestWay.add(queenBlack);
        bishopTestWay.add(kingBlack);
        bishopTestWay.add(knightBlackR);
        bishopTestWay.add(bishopBlackR);
        bishopTestWay.add(rookBlackR);
        bishopTestWay.add(pawnBlack1);
        bishopTestWay.add(pawnBlack2);
        bishopTestWay.add(pawnBlack3);
        bishopTestWay.add(pawnBlack4);
        bishopTestWay.add(pawnBlack5);
        bishopTestWay.add(pawnBlack6);
        bishopTestWay.add(pawnBlack7);
        bishopTestWay.add(pawnBlack8);

        assertThat(bishopTestWay.move(Cell.C1, Cell.G5), is(true));
    }
}
