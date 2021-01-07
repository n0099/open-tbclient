package com.bytedance.tea.crash.e;

import android.os.Build;
import android.system.Os;
import android.system.OsConstants;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static long f7952a = -1;

    /* loaded from: classes4.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static long f7953a = -1;

        public static long a(long j) {
            long a2;
            if (f7953a > 0) {
                return f7953a;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                a2 = Os.sysconf(OsConstants._SC_CLK_TCK);
            } else {
                a2 = Build.VERSION.SDK_INT >= 14 ? a("_SC_CLK_TCK", j) : j;
            }
            if (a2 > 0) {
                j = a2;
            }
            f7953a = j;
            return f7953a;
        }

        public static long a() {
            if (i.f7952a == -1) {
                long unused = i.f7952a = 1000 / b();
            }
            return i.f7952a;
        }

        public static long b() {
            return a(100L);
        }

        private static long a(String str, long j) {
            try {
                int i = Class.forName("libcore.io.OsConstants").getField(str).getInt(null);
                Class<?> cls = Class.forName("libcore.io.Libcore");
                Class<?> cls2 = Class.forName("libcore.io.Os");
                return ((Long) cls2.getMethod("sysconf", Integer.TYPE).invoke(cls.getField("os").get(null), Integer.valueOf(i))).longValue();
            } catch (Throwable th) {
                th.printStackTrace();
                return j;
            }
        }
    }
}
