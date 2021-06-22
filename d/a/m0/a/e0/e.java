package d.a.m0.a.e0;

import androidx.annotation.NonNull;
import d.a.m0.a.k2.g.h;
import java.io.File;
/* loaded from: classes2.dex */
public class e {
    public static File a() {
        return new File(d.a.m0.a.a1.e.q(), "sConsole-core");
    }

    public static long b() {
        return h.a().getLong("get_app_console_core_code", -1L);
    }

    public static String c() {
        return h.a().getString("get_app_console_core", "-1");
    }

    public static void d() {
        e("-1", -1L);
    }

    public static void e(@NonNull String str, long j) {
        h.a().putString("get_app_console_core", str);
        h.a().putLong("get_app_console_core_code", j);
    }
}
