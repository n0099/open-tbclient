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
    public static a f43991d;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43988a = k.f45443a;

    /* renamed from: b  reason: collision with root package name */
    public static String f43989b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f43990c = "";

    /* renamed from: e  reason: collision with root package name */
    public static int f43992e = 0;

    public static String a() {
        return f43989b;
    }

    public static String b() {
        if (f43991d != null) {
            return f43991d.a() + File.separator + f43989b;
        }
        return "";
    }

    public static String c() {
        return f43990c;
    }

    public static String d() {
        if (f43991d != null) {
            return f43991d.a() + File.separator + f43990c;
        }
        return "";
    }

    public static boolean e() {
        return f43992e == 2;
    }

    public static boolean f() {
        return f43992e == 1;
    }

    public static void g(Bundle bundle) {
        a aVar = f43991d;
        if (aVar != null) {
            aVar.c(bundle);
        }
    }

    public static void h(Bundle bundle) {
        String i = u.i(bundle, "extraWSUrl");
        String i2 = u.i(bundle, "adb_debug_path");
        if (!TextUtils.isEmpty(i)) {
            f43991d = new d();
            f43992e = 1;
        } else if (!TextUtils.isEmpty(i2)) {
            f43991d = new d.b.g0.a.c0.d.c.b();
            f43992e = 2;
        } else {
            if (f43988a) {
                Log.d("UserDebugParams", "not debug mode");
            }
            f43992e = 0;
            f43991d = null;
            return;
        }
        f43991d.b(bundle);
    }

    public static void i(String str) {
        f43989b = str;
    }

    public static void j(String str) {
        f43990c = str;
    }
}
