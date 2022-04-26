/**
 * Абстрактная фабрика по производству автомобилей
 *
 */
public interface AbstractCarsFactory {
    //Создает продукт - автомобиль типа седан
    Sedan createSedan();
    //Создает продукт - автомобиль типа хэтчбэк
    HatchBack createHatchback();
}
