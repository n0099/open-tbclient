package d.a.h0.a.e0.u;

import java.io.File;
/* loaded from: classes2.dex */
public class d {
    public static boolean a(String str, String str2, boolean z) {
        if (!z) {
            try {
                System.loadLibrary(str);
                return true;
            } catch (Throwable unused) {
            }
        }
        try {
            System.load(str2 + File.separator + "lib" + str + ".so");
            return true;
        } catch (Throwable unused2) {
            return false;
        }
    }
}
