package d.a.h0.a.c0.d;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import d.a.h0.a.c0.d.e.d;
import d.a.h0.a.i2.u;
import d.a.h0.a.k;
import java.io.File;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public static a f41604d;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f41601a = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public static String f41602b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f41603c = "";

    /* renamed from: e  reason: collision with root package name */
    public static int f41605e = 0;

    public static String a() {
        return f41602b;
    }

    public static String b() {
        if (f41604d != null) {
            return f41604d.c() + File.separator + f41602b;
        }
        return "";
    }

    public static String c() {
        return f41603c;
    }

    public static String d() {
        if (f41604d != null) {
            return f41604d.c() + File.separator + f41603c;
        }
        return "";
    }

    public static boolean e() {
        return f41605e == 2;
    }

    public static boolean f() {
        return f41605e == 1;
    }

    public static void g(Bundle bundle) {
        a aVar = f41604d;
        if (aVar != null) {
            aVar.b(bundle);
        }
    }

    public static void h(Bundle bundle) {
        String i2 = u.i(bundle, "extraWSUrl");
        String i3 = u.i(bundle, "adb_debug_path");
        if (!TextUtils.isEmpty(i2)) {
            f41604d = new d();
            f41605e = 1;
        } else if (!TextUtils.isEmpty(i3)) {
            f41604d = new d.a.h0.a.c0.d.c.b();
            f41605e = 2;
        } else {
            if (f41601a) {
                Log.d("UserDebugParams", "not debug mode");
            }
            f41605e = 0;
            f41604d = null;
            return;
        }
        f41604d.a(bundle);
    }

    public static void i(String str) {
        f41602b = str;
    }

    public static void j(String str) {
        f41603c = str;
    }
}
