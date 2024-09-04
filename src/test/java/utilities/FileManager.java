package utilities;

import io.qameta.allure.Attachment;
import org.aspectj.util.FileUtil;
import org.jsoup.Jsoup;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    private final static String screenshotPath = "src/test/resources/screenshots";
    private final static String pageStructurePath = "src/test/resources/pageStructure";

    public static void getScreenshot(String screenshotName) {
        Logs.debug("Taking screenshot");

        final var screenshotFile = ((TakesScreenshot) new WebDriverProvider().get()).getScreenshotAs(OutputType.FILE);

        final var path = String.format("%s/%s.png", screenshotPath, screenshotName);

        try {
            FileUtil.copyFile(screenshotFile, new File(path));
        } catch (IOException ioException) {
            Logs.error("Error al tomar el screenshot: %s", ioException.getLocalizedMessage());
        }
    }

    public static void getPageSource(String fileName) {
        Logs.debug("Tomando el nombre del archivo");
        final var path = String.format("%s/page-source-%s.html", pageStructurePath, fileName);
        try {
            final var file = new File(path);
            Logs.debug("Creando los directorios padres si es que no existen");
            if (file.getParentFile().mkdirs()) {
                final var fileWriter = new FileWriter(file);
                final var pageSource = new WebDriverProvider().get().getPageSource();
                fileWriter.write(Jsoup.parse(pageSource).toString());
                fileWriter.close();
            }
        } catch (IOException ioexception) {
            Logs.debug("Error al obtener el page source: %s", ioexception.getLocalizedMessage());
        }
    }

    public static void deletePreviousEvidence() {
        try {
            Logs.debug("Borrando la evidencia anterior");
            FileUtil.deleteContents(new File(screenshotPath));
            FileUtil.deleteContents(new File(pageStructurePath));
        } catch (Exception e) {
            Logs.error("Error al borrar la evidencia anterior: %s", e.getLocalizedMessage());
        }
    }

    @Attachment(value = "failureScreenshot", type = "image/png")
    public static byte[] getScreenshot() {
        return ((TakesScreenshot) new WebDriverProvider().get()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "pageSource", type = "text/html", fileExtension = "txt")
    public static String getPageSource() {
        return Jsoup.parse(new WebDriverProvider().get().getPageSource()).toString();
    }
}
