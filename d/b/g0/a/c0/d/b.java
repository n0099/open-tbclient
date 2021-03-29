package d.b.g0.a.c0.d;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import d.b.g0.a.c0.d.e.d;
import d.b.g0.a.i2.u;
import d.b.g0.a.k;
import java.io.File;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public static a f43599d;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43596a = k.f45051a;

    /* renamed from: b  reason: collision with root package name */
    public static String f43597b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f43598c = "";

    /* renamed from: e  reason: collision with root package name */
    public static int f43600e = 0;

    public static String a() {
        return f43597b;
    }

    public static String b() {
        if (f43599d != null) {
            return f43599d.a() + File.separator + f43597b;
        }
        return "";
    }

    public static String c() {
        return f43598c;
    }

    public static String d() {
        if (f43599d != null) {
            return f43599d.a() + File.separator + f43598c;
        }
        return "";
    }

    public static boolean e() {
        return f43600e == 2;
    }

    public static boolean f() {
        return f43600e == 1;
    }

    public static void g(Bundle bundle) {
        a aVar = f43599d;
        if (aVar != null) {
            aVar.c(bundle);
        }
    }

    public static void h(Bundle bundle) {
        String i = u.i(bundle, "extraWSUrl");
        String i2 = u.i(bundle, "adb_debug_path");
        if (!TextUtils.isEmpty(i)) {
            f43599d = new d();
            f43600e = 1;
        } else if (!TextUtils.isEmpty(i2)) {
            f43599d = new d.b.g0.a.c0.d.c.b();
            f43600e = 2;
        } else {
            if (f43596a) {
                Log.d("UserDebugParams", "not debug mode");
            }
            f43600e = 0;
            f43599d = null;
            return;
        }
        f43599d.b(bundle);
    }

    public static void i(String str) {
        f43597b = str;
    }

    public static void j(String str) {
        f43598c = str;
    }
}
