package d.a.i0.h.f;

import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f47183a = false;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f47184b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile List<d.a.i0.a.o0.d.b> f47185c = new ArrayList();

    public static void a() {
        if (!f47183a || f47184b) {
            return;
        }
        synchronized (i.class) {
            if (f47185c != null) {
                for (int i2 = 0; i2 < f47185c.size(); i2++) {
                    d.a.i0.a.g1.f.V().m("console", f47185c.get(i2));
                }
                f47185c.clear();
                f47185c = null;
            }
        }
        f47184b = true;
    }

    public static String b(int i2) {
        return i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? i2 != 6 ? TbConfig.TMP_LOG_DIR_NAME : "debug" : "warn" : "error" : "info" : "debug";
    }

    public static void c() {
        synchronized (i.class) {
            f47185c = new ArrayList();
        }
        f47184b = false;
    }

    public static void d(int i2, String str) {
        e(b(i2), str);
    }

    public static void e(String str, String str2) {
        if (f47183a) {
            f(c.h(str, str2));
        }
    }

    public static void f(d.a.i0.a.o0.d.b bVar) {
        if (!f47184b) {
            synchronized (i.class) {
                if (f47185c != null) {
                    f47185c.add(bVar);
                    return;
                }
            }
        }
        d.a.i0.a.g1.f.V().m("console", bVar);
    }

    public static void g(String str, String str2) {
        if (f47183a) {
            f(c.j(str, str2));
        }
    }

    public static void h(boolean z) {
        f47183a = z;
        d.a.i0.a.e0.d.k(z);
    }
}
