package d.a.l0.a.e0.f.e;

import android.text.TextUtils;
import android.util.Log;
import d.a.l0.a.k;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f41453a = k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public static String f41454b;

    /* renamed from: c  reason: collision with root package name */
    public static String f41455c;

    public static String a() {
        return f41454b + "/swan-core/master/master.html";
    }

    public static String b() {
        return f41454b + "/swan-core/slaves/slaves.html";
    }

    public static boolean c() {
        return TextUtils.equals(f41455c, "update_tag_by_remote_debug");
    }

    public static boolean d() {
        return !TextUtils.isEmpty(f41454b);
    }

    public static void e(String str) {
        if (f41453a) {
            Log.d("RemoteDebugger", "Current launch mode is " + str);
        }
        f41455c = str;
        if (TextUtils.equals(str, "update_tag_by_activity_on_new_intent")) {
            d.g().o();
        }
    }

    public static void f() {
        f41455c = "update_tag_by_remote_debug";
    }

    public static void g(String str) {
        f41454b = str;
    }
}
