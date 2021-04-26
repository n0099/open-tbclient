package d.a.h0.g.f;

import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f46322a = false;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f46323b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile List<d.a.h0.a.k0.b.b> f46324c = new ArrayList();

    public static void a() {
        if (!f46322a || f46323b) {
            return;
        }
        synchronized (i.class) {
            if (f46324c != null) {
                for (int i2 = 0; i2 < f46324c.size(); i2++) {
                    d.a.h0.a.z0.f.V().o("console", f46324c.get(i2));
                }
                f46324c.clear();
                f46324c = null;
            }
        }
        f46323b = true;
    }

    public static String b(int i2) {
        return i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? i2 != 6 ? TbConfig.TMP_LOG_DIR_NAME : "debug" : "warn" : "error" : "info" : "debug";
    }

    public static void c() {
        synchronized (i.class) {
            f46324c = new ArrayList();
        }
        f46323b = false;
    }

    public static void d(int i2, String str) {
        e(b(i2), str);
    }

    public static void e(String str, String str2) {
        if (f46322a) {
            f(c.b(str, str2));
        }
    }

    public static void f(d.a.h0.a.k0.b.b bVar) {
        if (!f46323b) {
            synchronized (i.class) {
                if (f46324c != null) {
                    f46324c.add(bVar);
                    return;
                }
            }
        }
        d.a.h0.a.z0.f.V().o("console", bVar);
    }

    public static void g(String str, String str2) {
        if (f46322a) {
            f(c.d(str, str2));
        }
    }

    public static void h(boolean z) {
        f46322a = z;
        d.a.h0.a.c0.c.k(z);
    }
}
