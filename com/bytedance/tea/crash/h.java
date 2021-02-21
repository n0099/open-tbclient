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
    private static com.bytedance.tea.crash.e.a pwA;
    private static String c = DefaultSharedPrefsWrapper.SP_FILE_DEFAULT;
    private static boolean d = false;
    private static com.bytedance.tea.crash.e.b pwB = new com.bytedance.tea.crash.e.b();
    private static b pwC = new b();
    private static j pwD = null;

    public static com.bytedance.tea.crash.e.a erl() {
        return pwA;
    }

    public static b erm() {
        return pwC;
    }

    public static j ern() {
        if (pwD == null) {
            synchronized (h.class) {
                pwD = new j(f7672a);
            }
        }
        return pwD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, d dVar) {
        f7673b = System.currentTimeMillis();
        f7672a = context;
        pwA = new com.bytedance.tea.crash.e.a(f7672a, dVar);
    }

    public static Context d() {
        return f7672a;
    }

    public static com.bytedance.tea.crash.e.b ero() {
        return pwB;
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

    public static ConcurrentHashMap<Integer, String> erp() {
        return h;
    }

    public static int j() {
        return j;
    }

    public static String k() {
        return k;
    }
}
