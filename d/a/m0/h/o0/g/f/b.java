package d.a.m0.h.o0.g.f;

import d.a.m0.a.k2.g.h;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes3.dex */
public class b {
    public static String a() {
        return new SimpleDateFormat("yyyy年MM月dd日", Locale.CHINESE).format(new Date(System.currentTimeMillis()));
    }

    public static String b(String str) {
        return h.a().getString(str, null);
    }

    public static void c(String str, String str2) {
        h.a().putString(str, str2);
    }
}
