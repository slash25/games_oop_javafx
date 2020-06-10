package ru.job4j.chess.firuges;

public interface Figure {

    //Метод для получения позиции фигуры на поле
    Cell position();//возвращает тип перечисления (Cell)


    //Метод, возвращающий массив с клетками которые должна пройти фигура от клетки source
    //до клетки dest
    Cell[] way(Cell source, Cell dest);

    //Метод возвращает имя картинки фигуры.Метод имеет реализацию по умолчанию
    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );
    }


    //Метод создающий объект класса с позицией dest.Все фигуры будут одноразовые
    //При переходе из одной клетки в другую мы будем создавать новый объект а старый удалять.
    Figure copy(Cell dest);
}
