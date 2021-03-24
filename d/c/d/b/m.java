package d.c.d.b;

import android.annotation.SuppressLint;
import android.content.Context;
import d.c.d.b.h.c;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static Context f65892a = null;

    /* renamed from: b  reason: collision with root package name */
    public static long f65893b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static String f65894c = "default";

    /* renamed from: d  reason: collision with root package name */
    public static boolean f65895d = false;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: e  reason: collision with root package name */
    public static d.c.d.b.h.b f65896e;

    /* renamed from: h  reason: collision with root package name */
    public static volatile ConcurrentHashMap<Integer, String> f65899h;
    public static volatile int j;
    public static volatile String k;

    /* renamed from: f  reason: collision with root package name */
    public static c f65897f = new c();

    /* renamed from: g  reason: collision with root package name */
    public static d f65898g = new d();
    public static d.c.d.b.h.k i = null;

    public static d.c.d.b.h.b a() {
        return f65896e;
    }

    public static void b(Context context, g gVar) {
        f65893b = System.currentTimeMillis();
        f65892a = context;
        f65896e = new d.c.d.b.h.b(context, gVar);
    }

    public static d c() {
        return f65898g;
    }

    public static d.c.d.b.h.k d() {
        if (i == null) {
            synchronized (m.class) {
                i = new d.c.d.b.h.k(f65892a);
            }
        }
        return i;
    }

    public static Context e() {
        return f65892a;
    }

    public static c f() {
        return f65897f;
    }

    public static long g() {
        return f65893b;
    }

    public static String h() {
        return f65894c;
    }

    public static boolean i() {
        return f65895d;
    }

    public static ConcurrentHashMap<Integer, String> j() {
        return f65899h;
    }

    public static int k() {
        return j;
    }

    public static String l() {
        return k;
    }
}
