package d.a.l0.h.f;

import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f51033a = false;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f51034b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile List<d.a.l0.a.o0.d.b> f51035c = new ArrayList();

    public static void a() {
        if (!f51033a || f51034b) {
            return;
        }
        synchronized (i.class) {
            if (f51035c != null) {
                for (int i2 = 0; i2 < f51035c.size(); i2++) {
                    d.a.l0.a.g1.f.V().m("console", f51035c.get(i2));
                }
                f51035c.clear();
                f51035c = null;
            }
        }
        f51034b = true;
    }

    public static String b(int i2) {
        return i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? i2 != 6 ? TbConfig.TMP_LOG_DIR_NAME : "debug" : "warn" : "error" : "info" : "debug";
    }

    public static void c() {
        synchronized (i.class) {
            f51035c = new ArrayList();
        }
        f51034b = false;
    }

    public static void d(int i2, String str) {
        e(b(i2), str);
    }

    public static void e(String str, String str2) {
        if (f51033a) {
            f(c.h(str, str2));
        }
    }

    public static void f(d.a.l0.a.o0.d.b bVar) {
        if (!f51034b) {
            synchronized (i.class) {
                if (f51035c != null) {
                    f51035c.add(bVar);
                    return;
                }
            }
        }
        d.a.l0.a.g1.f.V().m("console", bVar);
    }

    public static void g(String str, String str2) {
        if (f51033a) {
            f(c.j(str, str2));
        }
    }

    public static void h(boolean z) {
        f51033a = z;
        d.a.l0.a.e0.d.k(z);
    }
}
