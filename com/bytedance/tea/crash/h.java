package com.bytedance.tea.crash;

import android.annotation.SuppressLint;
import android.content.Context;
import com.bytedance.tea.crash.e.j;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static Context f7970a;

    /* renamed from: b  reason: collision with root package name */
    private static long f7971b;
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

    public static com.bytedance.tea.crash.e.a esF() {
        return pqp;
    }

    public static b esG() {
        return pqr;
    }

    public static j esH() {
        if (pqs == null) {
            synchronized (h.class) {
                pqs = new j(f7970a);
            }
        }
        return pqs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, d dVar) {
        f7971b = System.currentTimeMillis();
        f7970a = context;
        pqp = new com.bytedance.tea.crash.e.a(f7970a, dVar);
    }

    public static Context d() {
        return f7970a;
    }

    public static com.bytedance.tea.crash.e.b esI() {
        return pqq;
    }

    public static long f() {
        return f7971b;
    }

    public static String g() {
        return c;
    }

    public static boolean h() {
        return d;
    }

    public static ConcurrentHashMap<Integer, String> esJ() {
        return h;
    }

    public static int j() {
        return j;
    }

    public static String k() {
        return k;
    }
}
