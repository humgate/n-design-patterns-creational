/**
 * Класс для тестирования. Иллюстрация использования фабричного метода. Мы просто создали экземпляр наследника нашего
 * абстрактного класса и вызвали метод log абстрактного класса.
 * Приимущества:
 * 1. Мы можем ничего не знать о том, как реализовано логирование и как там "под капотом" создается необходимый
 * для этого объект.
 * 2. Разработчик логгера (MyLogger) может вносить изменения и модернизировать логгер, при этом наша программа не
 * потребует никаких изменений
 *
 */
public class Main {
    public static void main(String[] args) {
        AbstractProgram myProgram = new MyProgram();
        myProgram.log("Hello world!");
    }
}
