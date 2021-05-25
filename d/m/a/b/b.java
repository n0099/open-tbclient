package d.m.a.b;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipFile;
/* loaded from: classes7.dex */
public class b {
    public static void a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static void b(String str, int i2) {
        c.d("android.os.FileUtils", str, Integer.valueOf(i2), -1, -1);
    }

    public static void c(ZipFile zipFile) {
        if (zipFile == null) {
            return;
        }
        try {
            zipFile.close();
        } catch (IOException unused) {
        }
    }

    public static boolean d(String str) {
        return new File(str).mkdirs();
    }
}
