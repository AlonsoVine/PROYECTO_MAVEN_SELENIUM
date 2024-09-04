package listeners;

import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.TestResult;
import utilities.FileManager;
import utilities.Logs;

public class AllureListeners implements TestLifecycleListener {

    @Override
    public void beforeTestStop(TestResult result) {
        Logs.debug("Before Step Stop");
        final var resultType = result.getStatus();
        switch (resultType) {
            case BROKEN, FAILED -> {
                FileManager.getScreenshot();
                FileManager.getPageSource();
            }
        }
    }
}
