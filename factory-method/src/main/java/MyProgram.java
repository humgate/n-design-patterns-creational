/**
 * Наследник нашего абстрактного класса, который создает экземпляр конретной ореализации логгера
 *
 */
public class MyProgram extends AbstractProgram {
    @Override
    protected Logger getLogger() {
        return new MyLogger();
    }
}
