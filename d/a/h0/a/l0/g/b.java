package d.a.h0.a.l0.g;

import d.a.h0.p.d;
import java.io.File;
/* loaded from: classes2.dex */
public final class b {
    public static void a() {
        File b2 = b();
        if (b2.exists()) {
            d.f(b2);
        }
    }

    public static File b() {
        return new File(d.a.h0.a.y0.c.a.d().get(0).f42725a, "/aiapps_debug_extension_core/");
    }

    public static File c() {
        File b2 = b();
        if (!b2.exists()) {
            b2.mkdirs();
        }
        return new File(b2, "debugExtensionCore.zip");
    }
}
