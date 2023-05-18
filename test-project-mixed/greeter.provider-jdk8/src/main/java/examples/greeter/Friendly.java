package examples.greeter;

import examples.greeter.api.Greeter;
import io.github.pixee.security.BoundedLineReader;
import java.io.*;
import java.util.*;
import javax.annotation.Nonnull;

public class Friendly implements Greeter {
    @Override @Nonnull
    public String hello() {
        InputStream stream = this.getClass().getResourceAsStream("/greeting.txt");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream, "utf-8"))) {
            return BoundedLineReader.readLine(reader, 1000000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
