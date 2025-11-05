package utils;

import io.github.cdimascio.dotenv.Dotenv;

public class Enviornment {
    static Dotenv dotenv;

    public static void load() {
        dotenv = Dotenv.configure().filename("env.dev.config").directory(System.getProperty("user.dir")).load();

    }

    public static String get(String key) {
        return dotenv.get(key);

    }
}
