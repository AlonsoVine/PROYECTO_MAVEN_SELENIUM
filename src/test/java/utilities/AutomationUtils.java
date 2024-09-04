package utilities;

public class AutomationUtils {
    public static void sleep(long timeMs) {
        try {
            Logs.info("Esperando por %dms", timeMs);
            Thread.sleep(timeMs);
        } catch (InterruptedException ie) {
            Logs.error("Error al esperar: %s", ie.getLocalizedMessage());
        }
    }
}
