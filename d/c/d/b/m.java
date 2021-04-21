package d.c.d.b;

import android.annotation.SuppressLint;
import android.content.Context;
import d.c.d.b.h.c;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static Context f66833a = null;

    /* renamed from: b  reason: collision with root package name */
    public static long f66834b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static String f66835c = "default";

    /* renamed from: d  reason: collision with root package name */
    public static boolean f66836d = false;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: e  reason: collision with root package name */
    public static d.c.d.b.h.b f66837e;

    /* renamed from: h  reason: collision with root package name */
    public static volatile ConcurrentHashMap<Integer, String> f66840h;
    public static volatile int j;
    public static volatile String k;

    /* renamed from: f  reason: collision with root package name */
    public static c f66838f = new c();

    /* renamed from: g  reason: collision with root package name */
    public static d f66839g = new d();
    public static d.c.d.b.h.k i = null;

    public static d.c.d.b.h.b a() {
        return f66837e;
    }

    public static void b(Context context, g gVar) {
        f66834b = System.currentTimeMillis();
        f66833a = context;
        f66837e = new d.c.d.b.h.b(context, gVar);
    }

    public static d c() {
        return f66839g;
    }

    public static d.c.d.b.h.k d() {
        if (i == null) {
            synchronized (m.class) {
                i = new d.c.d.b.h.k(f66833a);
            }
        }
        return i;
    }

    public static Context e() {
        return f66833a;
    }

    public static c f() {
        return f66838f;
    }

    public static long g() {
        return f66834b;
    }

    public static String h() {
        return f66835c;
    }

    public static boolean i() {
        return f66836d;
    }

    public static ConcurrentHashMap<Integer, String> j() {
        return f66840h;
    }

    public static int k() {
        return j;
    }

    public static String l() {
        return k;
    }
}
