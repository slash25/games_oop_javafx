package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Objects;

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

        // Метод проверки в какую сторону диагональ
        int size = Math.abs(dest.x - source.x) + 1;
        Cell[] steps = new Cell[size];
        int dx = (dest.x - source.x) / Math.abs(dest.x - source.x);
        int dy = (dest.y - source.y) / Math.abs(dest.y - source.y);

        int  newDX = 0;
        int newDY = 0;

        for (int index = 0; index < size; index++){

            steps[index] = Cell.findBy( source.x + newDX , source.y + newDY);
            newDX = newDX + dx;//тут делаем приращение ходов по Х
            newDY  = newDY + dy;// тут делаем приращение ходов по У
        }
        return steps;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BishopBlack)) return false;
        BishopBlack that = (BishopBlack) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
