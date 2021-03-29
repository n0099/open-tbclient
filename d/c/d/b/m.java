package d.c.d.b;

import android.annotation.SuppressLint;
import android.content.Context;
import d.c.d.b.h.c;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static Context f65893a = null;

    /* renamed from: b  reason: collision with root package name */
    public static long f65894b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static String f65895c = "default";

    /* renamed from: d  reason: collision with root package name */
    public static boolean f65896d = false;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: e  reason: collision with root package name */
    public static d.c.d.b.h.b f65897e;

    /* renamed from: h  reason: collision with root package name */
    public static volatile ConcurrentHashMap<Integer, String> f65900h;
    public static volatile int j;
    public static volatile String k;

    /* renamed from: f  reason: collision with root package name */
    public static c f65898f = new c();

    /* renamed from: g  reason: collision with root package name */
    public static d f65899g = new d();
    public static d.c.d.b.h.k i = null;

    public static d.c.d.b.h.b a() {
        return f65897e;
    }

    public static void b(Context context, g gVar) {
        f65894b = System.currentTimeMillis();
        f65893a = context;
        f65897e = new d.c.d.b.h.b(context, gVar);
    }

    public static d c() {
        return f65899g;
    }

    public static d.c.d.b.h.k d() {
        if (i == null) {
            synchronized (m.class) {
                i = new d.c.d.b.h.k(f65893a);
            }
        }
        return i;
    }

    public static Context e() {
        return f65893a;
    }

    public static c f() {
        return f65898f;
    }

    public static long g() {
        return f65894b;
    }

    public static String h() {
        return f65895c;
    }

    public static boolean i() {
        return f65896d;
    }

    public static ConcurrentHashMap<Integer, String> j() {
        return f65900h;
    }

    public static int k() {
        return j;
    }

    public static String l() {
        return k;
    }
}
