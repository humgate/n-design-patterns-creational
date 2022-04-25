/**
 * Конкретная реализация логгера
 *
 */
public class MyLogger implements Logger {
    @Override
    public void log(String msg) {
        System.out.println("/*" + msg + "*/");
    }
}
