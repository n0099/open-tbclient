package com.bytedance.tea.crash;

import android.annotation.SuppressLint;
import android.content.Context;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.bytedance.tea.crash.e.j;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static Context f7672a;

    /* renamed from: b  reason: collision with root package name */
    private static long f7673b;
    private static volatile ConcurrentHashMap<Integer, String> h;
    private static volatile int j;
    private static volatile String k;
    @SuppressLint({"StaticFieldLeak"})
    private static com.bytedance.tea.crash.e.a pwa;
    private static String c = DefaultSharedPrefsWrapper.SP_FILE_DEFAULT;
    private static boolean d = false;
    private static com.bytedance.tea.crash.e.b pwb = new com.bytedance.tea.crash.e.b();
    private static b pwc = new b();
    private static j pwd = null;

    public static com.bytedance.tea.crash.e.a erd() {
        return pwa;
    }

    public static b ere() {
        return pwc;
    }

    public static j erf() {
        if (pwd == null) {
            synchronized (h.class) {
                pwd = new j(f7672a);
            }
        }
        return pwd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, d dVar) {
        f7673b = System.currentTimeMillis();
        f7672a = context;
        pwa = new com.bytedance.tea.crash.e.a(f7672a, dVar);
    }

    public static Context d() {
        return f7672a;
    }

    public static com.bytedance.tea.crash.e.b erg() {
        return pwb;
    }

    public static long f() {
        return f7673b;
    }

    public static String g() {
        return c;
    }

    public static boolean h() {
        return d;
    }

    public static ConcurrentHashMap<Integer, String> erh() {
        return h;
    }

    public static int j() {
        return j;
    }

    public static String k() {
        return k;
    }
}
