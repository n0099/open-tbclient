package d.a.m0.a.e0.f;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import d.a.m0.a.e0.f.f.d;
import d.a.m0.a.k;
import d.a.m0.a.v2.v;
import java.io.File;
/* loaded from: classes.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public static a f45140d;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45137a = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static String f45138b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f45139c = "";

    /* renamed from: e  reason: collision with root package name */
    public static int f45141e = 0;

    public static String a() {
        return f45138b;
    }

    public static String b() {
        if (f45140d != null) {
            return f45140d.c() + File.separator + f45138b;
        }
        return "";
    }

    public static String c() {
        return f45139c;
    }

    public static String d() {
        if (f45140d != null) {
            return f45140d.c() + File.separator + f45139c;
        }
        return "";
    }

    public static boolean e() {
        return f45141e == 2;
    }

    public static boolean f() {
        return f45141e == 1;
    }

    public static void g(Bundle bundle) {
        a aVar = f45140d;
        if (aVar != null) {
            aVar.b(bundle);
        }
    }

    public static void h(Bundle bundle) {
        String i2 = v.i(bundle, "extraWSUrl");
        String i3 = v.i(bundle, "adb_debug_path");
        if (!TextUtils.isEmpty(i2)) {
            f45140d = new d();
            f45141e = 1;
        } else if (!TextUtils.isEmpty(i3)) {
            f45140d = new d.a.m0.a.e0.f.c.b();
            f45141e = 2;
        } else {
            if (f45137a) {
                Log.d("UserDebugParams", "not debug mode");
            }
            f45141e = 0;
            f45140d = null;
            return;
        }
        f45140d.a(bundle);
    }

    public static void i(String str) {
        f45138b = str;
    }

    public static void j(String str) {
        f45139c = str;
    }
}
