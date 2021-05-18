package d.a.i0.a.e0.f;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import d.a.i0.a.e0.f.f.d;
import d.a.i0.a.k;
import d.a.i0.a.v2.v;
import java.io.File;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public static a f41182d;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f41179a = k.f43025a;

    /* renamed from: b  reason: collision with root package name */
    public static String f41180b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f41181c = "";

    /* renamed from: e  reason: collision with root package name */
    public static int f41183e = 0;

    public static String a() {
        return f41180b;
    }

    public static String b() {
        if (f41182d != null) {
            return f41182d.c() + File.separator + f41180b;
        }
        return "";
    }

    public static String c() {
        return f41181c;
    }

    public static String d() {
        if (f41182d != null) {
            return f41182d.c() + File.separator + f41181c;
        }
        return "";
    }

    public static boolean e() {
        return f41183e == 2;
    }

    public static boolean f() {
        return f41183e == 1;
    }

    public static void g(Bundle bundle) {
        a aVar = f41182d;
        if (aVar != null) {
            aVar.b(bundle);
        }
    }

    public static void h(Bundle bundle) {
        String i2 = v.i(bundle, "extraWSUrl");
        String i3 = v.i(bundle, "adb_debug_path");
        if (!TextUtils.isEmpty(i2)) {
            f41182d = new d();
            f41183e = 1;
        } else if (!TextUtils.isEmpty(i3)) {
            f41182d = new d.a.i0.a.e0.f.c.b();
            f41183e = 2;
        } else {
            if (f41179a) {
                Log.d("UserDebugParams", "not debug mode");
            }
            f41183e = 0;
            f41182d = null;
            return;
        }
        f41182d.a(bundle);
    }

    public static void i(String str) {
        f41180b = str;
    }

    public static void j(String str) {
        f41181c = str;
    }
}
