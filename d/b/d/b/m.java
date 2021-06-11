package d.b.d.b;

import android.annotation.SuppressLint;
import android.content.Context;
import d.b.d.b.h.c;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static Context f69699a = null;

    /* renamed from: b  reason: collision with root package name */
    public static long f69700b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static String f69701c = "default";

    /* renamed from: d  reason: collision with root package name */
    public static boolean f69702d = false;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: e  reason: collision with root package name */
    public static d.b.d.b.h.b f69703e;

    /* renamed from: h  reason: collision with root package name */
    public static volatile ConcurrentHashMap<Integer, String> f69706h;
    public static volatile int j;
    public static volatile String k;

    /* renamed from: f  reason: collision with root package name */
    public static c f69704f = new c();

    /* renamed from: g  reason: collision with root package name */
    public static d f69705g = new d();

    /* renamed from: i  reason: collision with root package name */
    public static d.b.d.b.h.k f69707i = null;

    public static d.b.d.b.h.b a() {
        return f69703e;
    }

    public static void b(Context context, g gVar) {
        f69700b = System.currentTimeMillis();
        f69699a = context;
        f69703e = new d.b.d.b.h.b(context, gVar);
    }

    public static d c() {
        return f69705g;
    }

    public static d.b.d.b.h.k d() {
        if (f69707i == null) {
            synchronized (m.class) {
                f69707i = new d.b.d.b.h.k(f69699a);
            }
        }
        return f69707i;
    }

    public static Context e() {
        return f69699a;
    }

    public static c f() {
        return f69704f;
    }

    public static long g() {
        return f69700b;
    }

    public static String h() {
        return f69701c;
    }

    public static boolean i() {
        return f69702d;
    }

    public static ConcurrentHashMap<Integer, String> j() {
        return f69706h;
    }

    public static int k() {
        return j;
    }

    public static String l() {
        return k;
    }
}
