package d.b.d.b.h;

import android.os.Build;
import android.system.Os;
import android.system.OsConstants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
/* loaded from: classes5.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static long f65215a = -1;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static long f65216a = -1;

        public static long a() {
            if (j.f65215a == -1) {
                long unused = j.f65215a = 1000 / d();
            }
            return j.f65215a;
        }

        public static long b(long j) {
            long c2;
            long j2 = f65216a;
            if (j2 > 0) {
                return j2;
            }
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 21) {
                c2 = Os.sysconf(OsConstants._SC_CLK_TCK);
            } else {
                c2 = i2 >= 14 ? c("_SC_CLK_TCK", j) : j;
            }
            if (c2 > 0) {
                j = c2;
            }
            f65216a = j;
            return j;
        }

        public static long c(String str, long j) {
            try {
                int i2 = Class.forName("libcore.io.OsConstants").getField(str).getInt(null);
                Class<?> cls = Class.forName("libcore.io.Libcore");
                Class<?> cls2 = Class.forName("libcore.io.Os");
                return ((Long) cls2.getMethod("sysconf", Integer.TYPE).invoke(cls.getField(IAdRequestParam.OS).get(null), Integer.valueOf(i2))).longValue();
            } catch (Throwable th) {
                th.printStackTrace();
                return j;
            }
        }

        public static long d() {
            return b(100L);
        }
    }
}
