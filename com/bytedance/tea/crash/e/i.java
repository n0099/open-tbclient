package com.bytedance.tea.crash.e;

import android.os.Build;
import android.system.Os;
import android.system.OsConstants;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static long f7652a = -1;

    /* loaded from: classes4.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static long f7653a = -1;

        public static long a(long j) {
            long a2;
            if (f7653a > 0) {
                return f7653a;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                a2 = Os.sysconf(OsConstants._SC_CLK_TCK);
            } else {
                a2 = Build.VERSION.SDK_INT >= 14 ? a("_SC_CLK_TCK", j) : j;
            }
            if (a2 > 0) {
                j = a2;
            }
            f7653a = j;
            return f7653a;
        }

        public static long a() {
            if (i.f7652a == -1) {
                long unused = i.f7652a = 1000 / b();
            }
            return i.f7652a;
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
