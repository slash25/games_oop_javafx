package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public  Cell[] way(Cell source, Cell dest) {

        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not way by diagonal from %s to %s", source, dest)
            );
        }

        //написать метод проверки в какую сторону диагональ
        int size = Math.abs(dest.x - source.x) + 1;
        Cell[] steps = new Cell[size];
        switch (findDirection(source, dest)) {

            //Вверх влево
            case 1:
                int deltaXupLeft = 0;
                int deltaYupLeft = 0;
               // steps[0] = Cell.findBy(source.x, source.y);

                for (int index = 0; index < size; index++) {
                    steps[index] = Cell.findBy(source.x + deltaXupLeft, source.y + deltaYupLeft);
                deltaXupLeft--;
                deltaYupLeft++;
                }
                break;


            //Вниз влево
            case 2:
                int deltaXdownLeft = 0;
                int deltaYdownLeft = 0;

                for (int index = 0; index < size; index++) {
                    steps[index] = Cell.findBy(source.x + deltaXdownLeft, source.y + deltaYdownLeft);
                    deltaXdownLeft--;
                    deltaYdownLeft--;
                }
                break;

            //Вверх вправо
            case 3:
                int deltaXupRight = 0;
                int deltaYupRight = 0;

                for (int index = 0; index < size; index++) {
                    steps[index] = Cell.findBy(source.x + deltaXupRight, source.y + deltaYupRight);
                    deltaXupRight++;
                    deltaYupRight++;
                }
                break;

            //Вниз вправо
            case 4:
                int deltaXdownRight = 0;
                int deltaYdownRight = 0;

                for (int index = 0; index < size; index++) {
                    steps[index] = Cell.findBy(source.x + deltaXdownRight, source.y + deltaYdownRight);
                    deltaXdownRight++;
                    deltaYdownRight--;
                }
                break;
        }
        return steps;
    }

    private int findDirection(Cell source, Cell dest) {
        int xDir = dest.x - source.x;
        int yDir = dest.y - source.y;

        //Upp right
        if ((xDir > 0) && (yDir > 0)) {
            return 3;
        }

        //Down right
        if ((xDir > 0) && (yDir < 0)) {
            return 4;
        }

        //Up left
        if ((xDir < 0) && (yDir < 0)) {
            return 1;
        }
        return 2;//Down left
    }

    //метод проверки диагонали
    private boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y);
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

    @Override
    public String toString() {
        return "BishopBlack{" +
                "position=" + position +
                '}';
    }
}
