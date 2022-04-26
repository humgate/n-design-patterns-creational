/**
 * Cобирает из подходящих друг другу компонентов автомобили первого автоконцерна каждого типа
 *
 */
public class BrandTwoCarFactory implements AbstractCarsFactory{
    /**
     * Cобирает седан производства второго автоконцерна
     *
     * @return экземпляр седана
     */
    @Override
    public Sedan createSedan() {
        return new BrandTwoSedan();
    }
    /**
     * Cобирает хэтчбэк производства второго автоконцерна
     *
     * @return экземпляр седана
     */
    @Override
    public HatchBack createHatchback() {
        return new BrandTwoHatchBack();
    }
}