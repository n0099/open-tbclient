package d.b.g0.a.c0.d.d;

import android.text.TextUtils;
import android.util.Log;
import d.b.g0.a.k;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43626a = k.f45050a;

    /* renamed from: b  reason: collision with root package name */
    public static String f43627b;

    /* renamed from: c  reason: collision with root package name */
    public static String f43628c;

    public static String a() {
        return f43627b + "/swan-core/master/master.html";
    }

    public static String b() {
        return f43627b + "/swan-core/slaves/slaves.html";
    }

    public static boolean c() {
        return TextUtils.equals(f43628c, "update_tag_by_remote_debug");
    }

    public static boolean d() {
        return !TextUtils.isEmpty(f43627b);
    }

    public static void e(String str) {
        if (f43626a) {
            Log.d("RemoteDebugger", "Current launch mode is " + str);
        }
        f43628c = str;
        if (TextUtils.equals(str, "update_tag_by_activity_on_new_intent")) {
            d.g().o();
        }
    }

    public static void f() {
        f43628c = "update_tag_by_remote_debug";
    }

    public static void g(String str) {
        f43627b = str;
    }
}
