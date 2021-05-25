package d.a.w.c.h;

import java.io.File;
/* loaded from: classes2.dex */
public class a {
    public static boolean a(String str) {
        return new File(str).delete();
    }

    public static void b(String str) {
        File parentFile = new File(str).getParentFile();
        if (parentFile.exists()) {
            return;
        }
        parentFile.mkdirs();
    }
}
