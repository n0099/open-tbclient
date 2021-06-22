package d.a.m0.a.e0.f.e;

import android.text.TextUtils;
import android.util.Log;
import d.a.m0.a.k;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45237a = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static String f45238b;

    /* renamed from: c  reason: collision with root package name */
    public static String f45239c;

    public static String a() {
        return f45238b + "/swan-core/master/master.html";
    }

    public static String b() {
        return f45238b + "/swan-core/slaves/slaves.html";
    }

    public static boolean c() {
        return TextUtils.equals(f45239c, "update_tag_by_remote_debug");
    }

    public static boolean d() {
        return !TextUtils.isEmpty(f45238b);
    }

    public static void e(String str) {
        if (f45237a) {
            Log.d("RemoteDebugger", "Current launch mode is " + str);
        }
        f45239c = str;
        if (TextUtils.equals(str, "update_tag_by_activity_on_new_intent")) {
            d.g().o();
        }
    }

    public static void f() {
        f45239c = "update_tag_by_remote_debug";
    }

    public static void g(String str) {
        f45238b = str;
    }
}
