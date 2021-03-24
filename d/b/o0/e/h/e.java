package d.b.o0.e.h;

import java.io.File;
/* loaded from: classes5.dex */
public class e {
    public static String a(File file, Object obj) {
        String b2;
        synchronized (obj) {
            b2 = f.b(file);
        }
        return b2;
    }

    public static boolean b(String str, File file, boolean z, Object obj) {
        boolean e2;
        synchronized (obj) {
            e2 = f.e(str, file, z);
        }
        return e2;
    }
}
