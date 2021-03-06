import java.lang.Exception;
import java.nio.file.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class Watch {
    public Watch () throws Exception {
        final Path path = FileSystems.getDefault().getPath(System.getProperty("user.home"), "Desktop");
        System.out.println(path);
        final WatchService watchService = FileSystems.getDefault().newWatchService();
        final WatchKey watchKey = path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
        while(true)

        {
            final WatchKey wk = watchService.take();
            for (WatchEvent<?> event : wk.pollEvents()) {
                //we only register "ENTRY_MODIFY" so the context is always a Path.
                final Path changed = (Path) event.context();
                System.out.println(changed);
                if (changed.endsWith("myFile.txt")) {
                    System.out.println("My file has changed");
                }
            }
            // reset the key
            boolean valid = wk.reset();
            if (!valid) {
                System.out.println("Key has been unregisterede");
            }
        }
    }
}
