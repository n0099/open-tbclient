package d.b.h0.a.c0.d.d;

import android.text.TextUtils;
import android.util.Log;
import d.b.h0.a.k;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44348a = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public static String f44349b;

    /* renamed from: c  reason: collision with root package name */
    public static String f44350c;

    public static String a() {
        return f44349b + "/swan-core/master/master.html";
    }

    public static String b() {
        return f44349b + "/swan-core/slaves/slaves.html";
    }

    public static boolean c() {
        return TextUtils.equals(f44350c, "update_tag_by_remote_debug");
    }

    public static boolean d() {
        return !TextUtils.isEmpty(f44349b);
    }

    public static void e(String str) {
        if (f44348a) {
            Log.d("RemoteDebugger", "Current launch mode is " + str);
        }
        f44350c = str;
        if (TextUtils.equals(str, "update_tag_by_activity_on_new_intent")) {
            d.g().o();
        }
    }

    public static void f() {
        f44350c = "update_tag_by_remote_debug";
    }

    public static void g(String str) {
        f44349b = str;
    }
}
