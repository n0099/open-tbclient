package d.b.d.b;

import android.annotation.SuppressLint;
import android.content.Context;
import d.b.d.b.h.c;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static Context f65968a = null;

    /* renamed from: b  reason: collision with root package name */
    public static long f65969b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static String f65970c = "default";

    /* renamed from: d  reason: collision with root package name */
    public static boolean f65971d = false;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: e  reason: collision with root package name */
    public static d.b.d.b.h.b f65972e;

    /* renamed from: h  reason: collision with root package name */
    public static volatile ConcurrentHashMap<Integer, String> f65975h;
    public static volatile int j;
    public static volatile String k;

    /* renamed from: f  reason: collision with root package name */
    public static c f65973f = new c();

    /* renamed from: g  reason: collision with root package name */
    public static d f65974g = new d();

    /* renamed from: i  reason: collision with root package name */
    public static d.b.d.b.h.k f65976i = null;

    public static d.b.d.b.h.b a() {
        return f65972e;
    }

    public static void b(Context context, g gVar) {
        f65969b = System.currentTimeMillis();
        f65968a = context;
        f65972e = new d.b.d.b.h.b(context, gVar);
    }

    public static d c() {
        return f65974g;
    }

    public static d.b.d.b.h.k d() {
        if (f65976i == null) {
            synchronized (m.class) {
                f65976i = new d.b.d.b.h.k(f65968a);
            }
        }
        return f65976i;
    }

    public static Context e() {
        return f65968a;
    }

    public static c f() {
        return f65973f;
    }

    public static long g() {
        return f65969b;
    }

    public static String h() {
        return f65970c;
    }

    public static boolean i() {
        return f65971d;
    }

    public static ConcurrentHashMap<Integer, String> j() {
        return f65975h;
    }

    public static int k() {
        return j;
    }

    public static String l() {
        return k;
    }
}
