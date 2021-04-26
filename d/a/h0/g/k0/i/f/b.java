package d.a.h0.g.k0.i.f;

import d.a.h0.a.a2.g.h;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes3.dex */
public class b {
    public static String a() {
        return new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis()));
    }

    public static String b(String str) {
        return h.a().getString(str, null);
    }

    public static void c(String str, String str2) {
        h.a().putString(str, str2);
    }
}
