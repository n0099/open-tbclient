package d.b.p.g.c.a;

import android.database.Cursor;
import java.io.Closeable;
import java.util.zip.ZipFile;
/* loaded from: classes2.dex */
public class c {
    public static boolean a(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    public static boolean b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    public static boolean c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    public static boolean d(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }
}
