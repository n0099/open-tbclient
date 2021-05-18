package d.a.i0.a.e0.f.e;

import android.text.TextUtils;
import android.util.Log;
import d.a.i0.a.k;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f41279a = k.f43025a;

    /* renamed from: b  reason: collision with root package name */
    public static String f41280b;

    /* renamed from: c  reason: collision with root package name */
    public static String f41281c;

    public static String a() {
        return f41280b + "/swan-core/master/master.html";
    }

    public static String b() {
        return f41280b + "/swan-core/slaves/slaves.html";
    }

    public static boolean c() {
        return TextUtils.equals(f41281c, "update_tag_by_remote_debug");
    }

    public static boolean d() {
        return !TextUtils.isEmpty(f41280b);
    }

    public static void e(String str) {
        if (f41279a) {
            Log.d("RemoteDebugger", "Current launch mode is " + str);
        }
        f41281c = str;
        if (TextUtils.equals(str, "update_tag_by_activity_on_new_intent")) {
            d.g().o();
        }
    }

    public static void f() {
        f41281c = "update_tag_by_remote_debug";
    }

    public static void g(String str) {
        f41280b = str;
    }
}
