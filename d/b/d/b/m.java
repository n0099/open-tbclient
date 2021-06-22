package d.b.d.b;

import android.annotation.SuppressLint;
import android.content.Context;
import d.b.d.b.h.c;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static Context f69803a = null;

    /* renamed from: b  reason: collision with root package name */
    public static long f69804b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static String f69805c = "default";

    /* renamed from: d  reason: collision with root package name */
    public static boolean f69806d = false;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: e  reason: collision with root package name */
    public static d.b.d.b.h.b f69807e;

    /* renamed from: h  reason: collision with root package name */
    public static volatile ConcurrentHashMap<Integer, String> f69810h;
    public static volatile int j;
    public static volatile String k;

    /* renamed from: f  reason: collision with root package name */
    public static c f69808f = new c();

    /* renamed from: g  reason: collision with root package name */
    public static d f69809g = new d();

    /* renamed from: i  reason: collision with root package name */
    public static d.b.d.b.h.k f69811i = null;

    public static d.b.d.b.h.b a() {
        return f69807e;
    }

    public static void b(Context context, g gVar) {
        f69804b = System.currentTimeMillis();
        f69803a = context;
        f69807e = new d.b.d.b.h.b(context, gVar);
    }

    public static d c() {
        return f69809g;
    }

    public static d.b.d.b.h.k d() {
        if (f69811i == null) {
            synchronized (m.class) {
                f69811i = new d.b.d.b.h.k(f69803a);
            }
        }
        return f69811i;
    }

    public static Context e() {
        return f69803a;
    }

    public static c f() {
        return f69808f;
    }

    public static long g() {
        return f69804b;
    }

    public static String h() {
        return f69805c;
    }

    public static boolean i() {
        return f69806d;
    }

    public static ConcurrentHashMap<Integer, String> j() {
        return f69810h;
    }

    public static int k() {
        return j;
    }

    public static String l() {
        return k;
    }
}
