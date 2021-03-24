package d.b.g0.a.c0.d;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import d.b.g0.a.c0.d.e.d;
import d.b.g0.a.i2.u;
import d.b.g0.a.k;
import java.io.File;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public static a f43598d;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43595a = k.f45050a;

    /* renamed from: b  reason: collision with root package name */
    public static String f43596b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f43597c = "";

    /* renamed from: e  reason: collision with root package name */
    public static int f43599e = 0;

    public static String a() {
        return f43596b;
    }

    public static String b() {
        if (f43598d != null) {
            return f43598d.a() + File.separator + f43596b;
        }
        return "";
    }

    public static String c() {
        return f43597c;
    }

    public static String d() {
        if (f43598d != null) {
            return f43598d.a() + File.separator + f43597c;
        }
        return "";
    }

    public static boolean e() {
        return f43599e == 2;
    }

    public static boolean f() {
        return f43599e == 1;
    }

    public static void g(Bundle bundle) {
        a aVar = f43598d;
        if (aVar != null) {
            aVar.c(bundle);
        }
    }

    public static void h(Bundle bundle) {
        String i = u.i(bundle, "extraWSUrl");
        String i2 = u.i(bundle, "adb_debug_path");
        if (!TextUtils.isEmpty(i)) {
            f43598d = new d();
            f43599e = 1;
        } else if (!TextUtils.isEmpty(i2)) {
            f43598d = new d.b.g0.a.c0.d.c.b();
            f43599e = 2;
        } else {
            if (f43595a) {
                Log.d("UserDebugParams", "not debug mode");
            }
            f43599e = 0;
            f43598d = null;
            return;
        }
        f43598d.b(bundle);
    }

    public static void i(String str) {
        f43596b = str;
    }

    public static void j(String str) {
        f43597c = str;
    }
}
