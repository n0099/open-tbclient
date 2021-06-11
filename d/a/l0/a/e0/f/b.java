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
    public static a f45032d;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45029a = k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public static String f45030b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f45031c = "";

    /* renamed from: e  reason: collision with root package name */
    public static int f45033e = 0;

    public static String a() {
        return f45030b;
    }

    public static String b() {
        if (f45032d != null) {
            return f45032d.c() + File.separator + f45030b;
        }
        return "";
    }

    public static String c() {
        return f45031c;
    }

    public static String d() {
        if (f45032d != null) {
            return f45032d.c() + File.separator + f45031c;
        }
        return "";
    }

    public static boolean e() {
        return f45033e == 2;
    }

    public static boolean f() {
        return f45033e == 1;
    }

    public static void g(Bundle bundle) {
        a aVar = f45032d;
        if (aVar != null) {
            aVar.b(bundle);
        }
    }

    public static void h(Bundle bundle) {
        String i2 = v.i(bundle, "extraWSUrl");
        String i3 = v.i(bundle, "adb_debug_path");
        if (!TextUtils.isEmpty(i2)) {
            f45032d = new d();
            f45033e = 1;
        } else if (!TextUtils.isEmpty(i3)) {
            f45032d = new d.a.l0.a.e0.f.c.b();
            f45033e = 2;
        } else {
            if (f45029a) {
                Log.d("UserDebugParams", "not debug mode");
            }
            f45033e = 0;
            f45032d = null;
            return;
        }
        f45032d.a(bundle);
    }

    public static void i(String str) {
        f45030b = str;
    }

    public static void j(String str) {
        f45031c = str;
    }
}
