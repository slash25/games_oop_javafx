package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LogicTest {
@Test
    public void moveTest (){
        Logic bishopTestWay = new Logic();
        assertThat(bishopTestWay.move(Cell.C1, Cell.G5), is(true));
    }
}
