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
       int[] delts = findDirection(source, dest);
        int dx = delts[0];
        int dy = delts[1];
        int  newDX = 0;
        int newDY = 0;

        for (int index = 0; index < size; index++){

            steps[index] = Cell.findBy( source.x + newDX , source.y + newDY);
            newDX = newDX + dx;
            newDY  = newDY + dy;
        }
        return steps;
    }


    private int[] findDirection(Cell source, Cell dest) {
        int xDir = dest.x - source.x;
        int yDir = dest.y - source.y;

        //Upp right
        if ((xDir > 0) && (yDir > 0)) {
            int[] xd = {1,1} ;
            return xd ;
        }

        //Down right
        if ((xDir > 0) && (yDir < 0)) {
            int[] xd = {1,-1} ;
            return xd ;
        }

        //Up left
        if ((xDir < 0) && (yDir < 0)) {
            int[] xd = {-1,1} ;
            return xd ;
        }
        //Up down
        int[] xd = {-1,-1};
        return xd;//Down left
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
