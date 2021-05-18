package d.b.d.b;

import android.annotation.SuppressLint;
import android.content.Context;
import d.b.d.b.h.c;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static Context f65925a = null;

    /* renamed from: b  reason: collision with root package name */
    public static long f65926b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static String f65927c = "default";

    /* renamed from: d  reason: collision with root package name */
    public static boolean f65928d = false;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: e  reason: collision with root package name */
    public static d.b.d.b.h.b f65929e;

    /* renamed from: h  reason: collision with root package name */
    public static volatile ConcurrentHashMap<Integer, String> f65932h;
    public static volatile int j;
    public static volatile String k;

    /* renamed from: f  reason: collision with root package name */
    public static c f65930f = new c();

    /* renamed from: g  reason: collision with root package name */
    public static d f65931g = new d();

    /* renamed from: i  reason: collision with root package name */
    public static d.b.d.b.h.k f65933i = null;

    public static d.b.d.b.h.b a() {
        return f65929e;
    }

    public static void b(Context context, g gVar) {
        f65926b = System.currentTimeMillis();
        f65925a = context;
        f65929e = new d.b.d.b.h.b(context, gVar);
    }

    public static d c() {
        return f65931g;
    }

    public static d.b.d.b.h.k d() {
        if (f65933i == null) {
            synchronized (m.class) {
                f65933i = new d.b.d.b.h.k(f65925a);
            }
        }
        return f65933i;
    }

    public static Context e() {
        return f65925a;
    }

    public static c f() {
        return f65930f;
    }

    public static long g() {
        return f65926b;
    }

    public static String h() {
        return f65927c;
    }

    public static boolean i() {
        return f65928d;
    }

    public static ConcurrentHashMap<Integer, String> j() {
        return f65932h;
    }

    public static int k() {
        return j;
    }

    public static String l() {
        return k;
    }
}
