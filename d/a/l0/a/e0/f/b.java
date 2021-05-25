package d.a.l0.a.e0.f;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import d.a.l0.a.e0.f.f.d;
import d.a.l0.a.k;
import d.a.l0.a.v2.v;
import java.io.File;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public static a f41356d;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f41353a = k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public static String f41354b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f41355c = "";

    /* renamed from: e  reason: collision with root package name */
    public static int f41357e = 0;

    public static String a() {
        return f41354b;
    }

    public static String b() {
        if (f41356d != null) {
            return f41356d.c() + File.separator + f41354b;
        }
        return "";
    }

    public static String c() {
        return f41355c;
    }

    public static String d() {
        if (f41356d != null) {
            return f41356d.c() + File.separator + f41355c;
        }
        return "";
    }

    public static boolean e() {
        return f41357e == 2;
    }

    public static boolean f() {
        return f41357e == 1;
    }

    public static void g(Bundle bundle) {
        a aVar = f41356d;
        if (aVar != null) {
            aVar.b(bundle);
        }
    }

    public static void h(Bundle bundle) {
        String i2 = v.i(bundle, "extraWSUrl");
        String i3 = v.i(bundle, "adb_debug_path");
        if (!TextUtils.isEmpty(i2)) {
            f41356d = new d();
            f41357e = 1;
        } else if (!TextUtils.isEmpty(i3)) {
            f41356d = new d.a.l0.a.e0.f.c.b();
            f41357e = 2;
        } else {
            if (f41353a) {
                Log.d("UserDebugParams", "not debug mode");
            }
            f41357e = 0;
            f41356d = null;
            return;
        }
        f41356d.a(bundle);
    }

    public static void i(String str) {
        f41354b = str;
    }

    public static void j(String str) {
        f41355c = str;
    }
}
