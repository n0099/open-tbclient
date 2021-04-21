package d.b.h0.a.c0.d;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import d.b.h0.a.c0.d.e.d;
import d.b.h0.a.i2.u;
import d.b.h0.a.k;
import java.io.File;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public static a f44320d;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44317a = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public static String f44318b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f44319c = "";

    /* renamed from: e  reason: collision with root package name */
    public static int f44321e = 0;

    public static String a() {
        return f44318b;
    }

    public static String b() {
        if (f44320d != null) {
            return f44320d.a() + File.separator + f44318b;
        }
        return "";
    }

    public static String c() {
        return f44319c;
    }

    public static String d() {
        if (f44320d != null) {
            return f44320d.a() + File.separator + f44319c;
        }
        return "";
    }

    public static boolean e() {
        return f44321e == 2;
    }

    public static boolean f() {
        return f44321e == 1;
    }

    public static void g(Bundle bundle) {
        a aVar = f44320d;
        if (aVar != null) {
            aVar.c(bundle);
        }
    }

    public static void h(Bundle bundle) {
        String i = u.i(bundle, "extraWSUrl");
        String i2 = u.i(bundle, "adb_debug_path");
        if (!TextUtils.isEmpty(i)) {
            f44320d = new d();
            f44321e = 1;
        } else if (!TextUtils.isEmpty(i2)) {
            f44320d = new d.b.h0.a.c0.d.c.b();
            f44321e = 2;
        } else {
            if (f44317a) {
                Log.d("UserDebugParams", "not debug mode");
            }
            f44321e = 0;
            f44320d = null;
            return;
        }
        f44320d.b(bundle);
    }

    public static void i(String str) {
        f44318b = str;
    }

    public static void j(String str) {
        f44319c = str;
    }
}
