package d.a.h0.e.a.q;

import android.text.TextUtils;
import d.a.h0.a.i2.k0;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes3.dex */
public class e {
    public static String a() {
        String substring = new a().a(String.valueOf(System.currentTimeMillis())).substring(4, 14);
        String f2 = d.a.h0.a.w0.a.O().f(d.a.h0.a.w0.a.c());
        if (TextUtils.isEmpty(f2)) {
            f2 = k0.r();
        }
        return "38" + substring + f2.substring(0, 4);
    }

    public static String b() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
