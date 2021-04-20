package d.c.d.b;

import android.annotation.SuppressLint;
import android.content.Context;
import d.c.d.b.h.c;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static Context f66738a = null;

    /* renamed from: b  reason: collision with root package name */
    public static long f66739b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static String f66740c = "default";

    /* renamed from: d  reason: collision with root package name */
    public static boolean f66741d = false;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: e  reason: collision with root package name */
    public static d.c.d.b.h.b f66742e;

    /* renamed from: h  reason: collision with root package name */
    public static volatile ConcurrentHashMap<Integer, String> f66745h;
    public static volatile int j;
    public static volatile String k;

    /* renamed from: f  reason: collision with root package name */
    public static c f66743f = new c();

    /* renamed from: g  reason: collision with root package name */
    public static d f66744g = new d();
    public static d.c.d.b.h.k i = null;

    public static d.c.d.b.h.b a() {
        return f66742e;
    }

    public static void b(Context context, g gVar) {
        f66739b = System.currentTimeMillis();
        f66738a = context;
        f66742e = new d.c.d.b.h.b(context, gVar);
    }

    public static d c() {
        return f66744g;
    }

    public static d.c.d.b.h.k d() {
        if (i == null) {
            synchronized (m.class) {
                i = new d.c.d.b.h.k(f66738a);
            }
        }
        return i;
    }

    public static Context e() {
        return f66738a;
    }

    public static c f() {
        return f66743f;
    }

    public static long g() {
        return f66739b;
    }

    public static String h() {
        return f66740c;
    }

    public static boolean i() {
        return f66741d;
    }

    public static ConcurrentHashMap<Integer, String> j() {
        return f66745h;
    }

    public static int k() {
        return j;
    }

    public static String l() {
        return k;
    }
}
