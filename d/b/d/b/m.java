package d.b.d.b;

import android.annotation.SuppressLint;
import android.content.Context;
import d.b.d.b.h.c;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static Context f65239a = null;

    /* renamed from: b  reason: collision with root package name */
    public static long f65240b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static String f65241c = "default";

    /* renamed from: d  reason: collision with root package name */
    public static boolean f65242d = false;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: e  reason: collision with root package name */
    public static d.b.d.b.h.b f65243e;

    /* renamed from: h  reason: collision with root package name */
    public static volatile ConcurrentHashMap<Integer, String> f65246h;
    public static volatile int j;
    public static volatile String k;

    /* renamed from: f  reason: collision with root package name */
    public static c f65244f = new c();

    /* renamed from: g  reason: collision with root package name */
    public static d f65245g = new d();

    /* renamed from: i  reason: collision with root package name */
    public static d.b.d.b.h.k f65247i = null;

    public static d.b.d.b.h.b a() {
        return f65243e;
    }

    public static void b(Context context, g gVar) {
        f65240b = System.currentTimeMillis();
        f65239a = context;
        f65243e = new d.b.d.b.h.b(context, gVar);
    }

    public static d c() {
        return f65245g;
    }

    public static d.b.d.b.h.k d() {
        if (f65247i == null) {
            synchronized (m.class) {
                f65247i = new d.b.d.b.h.k(f65239a);
            }
        }
        return f65247i;
    }

    public static Context e() {
        return f65239a;
    }

    public static c f() {
        return f65244f;
    }

    public static long g() {
        return f65240b;
    }

    public static String h() {
        return f65241c;
    }

    public static boolean i() {
        return f65242d;
    }

    public static ConcurrentHashMap<Integer, String> j() {
        return f65246h;
    }

    public static int k() {
        return j;
    }

    public static String l() {
        return k;
    }
}
