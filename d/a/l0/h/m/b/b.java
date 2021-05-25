package d.a.l0.h.m.b;

import java.io.File;
/* loaded from: classes3.dex */
public class b {
    public static void a() {
        File b2 = b();
        if (b2.exists()) {
            d.a.l0.t.d.i(b2);
        }
    }

    public static File b() {
        return d.a.l0.h.s.a.e("aigames_debug_extension_core");
    }

    public static File c() {
        File b2 = b();
        if (!b2.exists()) {
            b2.mkdirs();
        }
        return new File(b2, "debugExtensionCore.zip");
    }
}
