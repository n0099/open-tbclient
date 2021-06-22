package d.a.m0.a.p0.f;

import d.a.m0.t.d;
import java.io.File;
/* loaded from: classes3.dex */
public final class c {
    public static void a() {
        File b2 = b();
        if (b2.exists()) {
            d.i(b2);
        }
    }

    public static File b() {
        return new File(d.a.m0.a.f1.c.a.d().get(0).f49205a, "/aiapps_debug_extension_core/");
    }

    public static File c() {
        File b2 = b();
        if (!b2.exists()) {
            b2.mkdirs();
        }
        return new File(b2, "debugExtensionCore.zip");
    }
}
