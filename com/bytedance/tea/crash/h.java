package com.bytedance.tea.crash;

import android.annotation.SuppressLint;
import android.content.Context;
import com.bytedance.tea.crash.e.j;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static Context f7969a;

    /* renamed from: b  reason: collision with root package name */
    private static long f7970b;
    private static volatile ConcurrentHashMap<Integer, String> h;
    private static volatile int j;
    private static volatile String k;
    @SuppressLint({"StaticFieldLeak"})
    private static com.bytedance.tea.crash.e.a pqp;
    private static String c = "default";
    private static boolean d = false;
    private static com.bytedance.tea.crash.e.b pqq = new com.bytedance.tea.crash.e.b();
    private static b pqr = new b();
    private static j pqs = null;

    public static com.bytedance.tea.crash.e.a esE() {
        return pqp;
    }

    public static b esF() {
        return pqr;
    }

    public static j esG() {
        if (pqs == null) {
            synchronized (h.class) {
                pqs = new j(f7969a);
            }
        }
        return pqs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, d dVar) {
        f7970b = System.currentTimeMillis();
        f7969a = context;
        pqp = new com.bytedance.tea.crash.e.a(f7969a, dVar);
    }

    public static Context d() {
        return f7969a;
    }

    public static com.bytedance.tea.crash.e.b esH() {
        return pqq;
    }

    public static long f() {
        return f7970b;
    }

    public static String g() {
        return c;
    }

    public static boolean h() {
        return d;
    }

    public static ConcurrentHashMap<Integer, String> esI() {
        return h;
    }

    public static int j() {
        return j;
    }

    public static String k() {
        return k;
    }
}
