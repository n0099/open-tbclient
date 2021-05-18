package d.a.i0.a.p0.f;

import d.a.i0.t.d;
import java.io.File;
/* loaded from: classes2.dex */
public final class c {
    public static void a() {
        File b2 = b();
        if (b2.exists()) {
            d.i(b2);
        }
    }

    public static File b() {
        return new File(d.a.i0.a.f1.c.a.d().get(0).f45247a, "/aiapps_debug_extension_core/");
    }

    public static File c() {
        File b2 = b();
        if (!b2.exists()) {
            b2.mkdirs();
        }
        return new File(b2, "debugExtensionCore.zip");
    }
}
