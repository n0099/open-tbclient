package d.a.h0.a.c0.d.d;

import android.text.TextUtils;
import android.util.Log;
import d.a.h0.a.k;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f41633a = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public static String f41634b;

    /* renamed from: c  reason: collision with root package name */
    public static String f41635c;

    public static String a() {
        return f41634b + "/swan-core/master/master.html";
    }

    public static String b() {
        return f41634b + "/swan-core/slaves/slaves.html";
    }

    public static boolean c() {
        return TextUtils.equals(f41635c, "update_tag_by_remote_debug");
    }

    public static boolean d() {
        return !TextUtils.isEmpty(f41634b);
    }

    public static void e(String str) {
        if (f41633a) {
            Log.d("RemoteDebugger", "Current launch mode is " + str);
        }
        f41635c = str;
        if (TextUtils.equals(str, "update_tag_by_activity_on_new_intent")) {
            d.g().o();
        }
    }

    public static void f() {
        f41635c = "update_tag_by_remote_debug";
    }

    public static void g(String str) {
        f41634b = str;
    }
}
