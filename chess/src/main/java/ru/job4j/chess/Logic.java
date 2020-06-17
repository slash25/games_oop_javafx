package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;
import java.util.Optional;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }


    /*
    Нужно добавить  еще одну проверку. Нужно проверить, что на пути фигуры,
    которую мы двигаем нет других фигур и конечная ячейка, куда мы хотим
    прийти этой фигурой, тоже свободна.

    За эти действия отвечает уже класс Logic. Класс Logic работает с обобщенными
    объектами. В нем есть только массив с объектами Figure.

    В нем есть метод move. Он осуществляет передвижение объекта фигуры по полю.
    Логика этого метода должны быть следующей.
     */
    /*
    1. По объекту типа Cell source в массиве figures найти объект типа Figure.
     Для этого используется метод findBy. Он возвращает индекс ячейки или -1.

    2. Если объект найден, то нужно получить его ходы до клетки Cell dest.
    Это нужно сделать через метод way объекта Figure.

    3. Дальше нужно проверить, что массив клеток от метода way не заполнен другими
    объектами класса Figure. Если он не заполнен, но нужно в массив figures в позицию,
    полученную в пункте 1, записать новый объект, полученный из метода figure.copy.

То есть мы нашли объект и заменили его ячейку новым объектом.
     */

    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        try {
            /*
           1. По объекту типа Cell source в массиве figures найти объект типа Figure.
            Для этого используется метод findBy. Он возвращает индекс ячейки или -1
             */
            int index = this.findBy(source);
            if (index != -1) {
                /*
               2. Если объект найден, то нужно получить его ходы до клетки Cell dest.
                Это нужно сделать через метод way объекта Figure.
                 */
                Cell[] steps = this.figures[index].way(source, dest);

                if (testWay(steps)) {
                /*
                Дальше нужно проверить, что массив клеток от метода way не заполнен
                 другими объектами класса Figure. Если он не заполнен, но нужно
                  в массив figures в позицию, полученную в пункте 1, записать
                  новый объект, полученный из метода figure.copy.

                То есть мы нашли объект и заменили его ячейку новым объектом
                 */

                    if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
                        rst = true;
                        this.figures[index] = this.figures[index].copy(dest);
                    }

                }

            }
        }
             catch(Exception e){
                    e.printStackTrace();
                }
            return rst;

    }


    private boolean testWay(Cell[] steps){
        boolean value = false;
        for (Cell cl : steps
        ) {
            if (findBy(cl) != -1) {
                value = true;
            }

        }
        return value;
    }


    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    @Override
    public String toString() {
        return "Logic{" +
                "figures=" + Arrays.toString(this.figures) +
                '}';
    }
}
