package d.a.m0.h.f;

import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f51141a = false;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f51142b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile List<d.a.m0.a.o0.d.b> f51143c = new ArrayList();

    public static void a() {
        if (!f51141a || f51142b) {
            return;
        }
        synchronized (i.class) {
            if (f51143c != null) {
                for (int i2 = 0; i2 < f51143c.size(); i2++) {
                    d.a.m0.a.g1.f.V().m("console", f51143c.get(i2));
                }
                f51143c.clear();
                f51143c = null;
            }
        }
        f51142b = true;
    }

    public static String b(int i2) {
        return i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? i2 != 6 ? TbConfig.TMP_LOG_DIR_NAME : "debug" : "warn" : "error" : "info" : "debug";
    }

    public static void c() {
        synchronized (i.class) {
            f51143c = new ArrayList();
        }
        f51142b = false;
    }

    public static void d(int i2, String str) {
        e(b(i2), str);
    }

    public static void e(String str, String str2) {
        if (f51141a) {
            f(c.h(str, str2));
        }
    }

    public static void f(d.a.m0.a.o0.d.b bVar) {
        if (!f51142b) {
            synchronized (i.class) {
                if (f51143c != null) {
                    f51143c.add(bVar);
                    return;
                }
            }
        }
        d.a.m0.a.g1.f.V().m("console", bVar);
    }

    public static void g(String str, String str2) {
        if (f51141a) {
            f(c.j(str, str2));
        }
    }

    public static void h(boolean z) {
        f51141a = z;
        d.a.m0.a.e0.d.k(z);
    }
}
