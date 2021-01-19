package com.bytedance.tea.crash;

import android.annotation.SuppressLint;
import android.content.Context;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.bytedance.tea.crash.e.j;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static Context f7670a;

    /* renamed from: b  reason: collision with root package name */
    private static long f7671b;
    private static volatile ConcurrentHashMap<Integer, String> h;
    private static volatile int j;
    private static volatile String k;
    @SuppressLint({"StaticFieldLeak"})
    private static com.bytedance.tea.crash.e.a plL;
    private static String c = DefaultSharedPrefsWrapper.SP_FILE_DEFAULT;
    private static boolean d = false;
    private static com.bytedance.tea.crash.e.b plM = new com.bytedance.tea.crash.e.b();
    private static b plN = new b();
    private static j plO = null;

    public static com.bytedance.tea.crash.e.a eoL() {
        return plL;
    }

    public static b eoM() {
        return plN;
    }

    public static j eoN() {
        if (plO == null) {
            synchronized (h.class) {
                plO = new j(f7670a);
            }
        }
        return plO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, d dVar) {
        f7671b = System.currentTimeMillis();
        f7670a = context;
        plL = new com.bytedance.tea.crash.e.a(f7670a, dVar);
    }

    public static Context d() {
        return f7670a;
    }

    public static com.bytedance.tea.crash.e.b eoO() {
        return plM;
    }

    public static long f() {
        return f7671b;
    }

    public static String g() {
        return c;
    }

    public static boolean h() {
        return d;
    }

    public static ConcurrentHashMap<Integer, String> eoP() {
        return h;
    }

    public static int j() {
        return j;
    }

    public static String k() {
        return k;
    }
}
