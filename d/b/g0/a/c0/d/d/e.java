package d.b.g0.a.c0.d.d;

import android.text.TextUtils;
import android.util.Log;
import d.b.g0.a.k;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44019a = k.f45443a;

    /* renamed from: b  reason: collision with root package name */
    public static String f44020b;

    /* renamed from: c  reason: collision with root package name */
    public static String f44021c;

    public static String a() {
        return f44020b + "/swan-core/master/master.html";
    }

    public static String b() {
        return f44020b + "/swan-core/slaves/slaves.html";
    }

    public static boolean c() {
        return TextUtils.equals(f44021c, "update_tag_by_remote_debug");
    }

    public static boolean d() {
        return !TextUtils.isEmpty(f44020b);
    }

    public static void e(String str) {
        if (f44019a) {
            Log.d("RemoteDebugger", "Current launch mode is " + str);
        }
        f44021c = str;
        if (TextUtils.equals(str, "update_tag_by_activity_on_new_intent")) {
            d.g().o();
        }
    }

    public static void f() {
        f44021c = "update_tag_by_remote_debug";
    }

    public static void g(String str) {
        f44020b = str;
    }
}
