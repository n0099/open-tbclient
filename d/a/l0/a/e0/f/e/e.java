package d.a.l0.a.e0.f.e;

import android.text.TextUtils;
import android.util.Log;
import d.a.l0.a.k;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45129a = k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public static String f45130b;

    /* renamed from: c  reason: collision with root package name */
    public static String f45131c;

    public static String a() {
        return f45130b + "/swan-core/master/master.html";
    }

    public static String b() {
        return f45130b + "/swan-core/slaves/slaves.html";
    }

    public static boolean c() {
        return TextUtils.equals(f45131c, "update_tag_by_remote_debug");
    }

    public static boolean d() {
        return !TextUtils.isEmpty(f45130b);
    }

    public static void e(String str) {
        if (f45129a) {
            Log.d("RemoteDebugger", "Current launch mode is " + str);
        }
        f45131c = str;
        if (TextUtils.equals(str, "update_tag_by_activity_on_new_intent")) {
            d.g().o();
        }
    }

    public static void f() {
        f45131c = "update_tag_by_remote_debug";
    }

    public static void g(String str) {
        f45130b = str;
    }
}
