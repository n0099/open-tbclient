package org.chromium.base;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.ZipFile;
/* loaded from: classes2.dex */
public class StreamUtil {
    public static void closeQuietly(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static void closeQuietly(ZipFile zipFile) {
        if (zipFile == null) {
            return;
        }
        try {
            zipFile.close();
        } catch (IOException unused) {
        }
    }
}
