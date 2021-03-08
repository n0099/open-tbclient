package com.bytedance.tea.crash;

import android.annotation.SuppressLint;
import android.content.Context;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.bytedance.tea.crash.e.j;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static Context f5192a;
    private static long b;
    private static volatile int j;
    private static volatile String k;
    @SuppressLint({"StaticFieldLeak"})
    private static com.bytedance.tea.crash.e.a pyD;
    private static volatile ConcurrentHashMap<Integer, String> pyG;
    private static String c = DefaultSharedPrefsWrapper.SP_FILE_DEFAULT;
    private static boolean d = false;
    private static com.bytedance.tea.crash.e.b pyE = new com.bytedance.tea.crash.e.b();
    private static b pyF = new b();
    private static j pyH = null;

    public static com.bytedance.tea.crash.e.a erv() {
        return pyD;
    }

    public static b erw() {
        return pyF;
    }

    public static j erx() {
        if (pyH == null) {
            synchronized (h.class) {
                pyH = new j(f5192a);
            }
        }
        return pyH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, d dVar) {
        b = System.currentTimeMillis();
        f5192a = context;
        pyD = new com.bytedance.tea.crash.e.a(f5192a, dVar);
    }

    public static Context d() {
        return f5192a;
    }

    public static com.bytedance.tea.crash.e.b ery() {
        return pyE;
    }

    public static long f() {
        return b;
    }

    public static String g() {
        return c;
    }

    public static boolean h() {
        return d;
    }

    public static ConcurrentHashMap<Integer, String> erz() {
        return pyG;
    }

    public static int j() {
        return j;
    }

    public static String k() {
        return k;
    }
}
