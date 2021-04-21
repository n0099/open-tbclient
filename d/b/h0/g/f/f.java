package d.b.h0.g.f;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class f {
    public static String a() {
        return d.b.h0.a.a2.g.h.a().getString("get_app_console_core", "-1");
    }

    public static void b() {
        c("-1");
    }

    public static void c(@NonNull String str) {
        d.b.h0.a.a2.g.h.a().putString("get_app_console_core", str);
    }
}
