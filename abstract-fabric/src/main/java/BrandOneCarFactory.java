/**
 * Cобирает из подходящих друг другу компонентов автомобили первого автоконцерна каждого типа
 */
public class BrandOneCarFactory implements AbstractCarsFactory {
    /**
     * Cобирает седан производства первого автоконцерна
     *
     * @return экземпляр седана
     */
    @Override
    public Sedan createSedan() {
        //
        return new BrandOneSedan();
    }

    /**
     * Cобирает хэтчбэк производства первого автоконцерна
     *
     * @return экземпляр седана
     */
    @Override
    public HatchBack createHatchback() {
        return new BrandOneHatchBack();
    }
}
