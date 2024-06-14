package com.mcal.example.utils;

import android.content.Context;
import java.io.*;

public class FileHelper {
    public static void copyAssetsFile(Context context, String filename, File output) throws IOException {
        copyFile(context.getAssets().open(filename), new FileOutputStream(output));
    }

    public static void copyFile(InputStream source, OutputStream target) throws IOException {
        byte[] buf = new byte[8192];
        int length;
        while ((length = source.read(buf)) != -1) {
            target.write(buf, 0, length);
        }
    }
}