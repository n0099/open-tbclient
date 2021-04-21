package d.b.h0.g.f;

import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f48851a = false;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f48852b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile List<d.b.h0.a.k0.b.b> f48853c = new ArrayList();

    public static void a() {
        if (!f48851a || f48852b) {
            return;
        }
        synchronized (i.class) {
            if (f48853c != null) {
                for (int i = 0; i < f48853c.size(); i++) {
                    d.b.h0.a.z0.f.V().z("console", f48853c.get(i));
                }
                f48853c.clear();
                f48853c = null;
            }
        }
        f48852b = true;
    }

    public static String b(int i) {
        return i != 2 ? i != 3 ? i != 4 ? i != 5 ? i != 6 ? TbConfig.TMP_LOG_DIR_NAME : "debug" : "warn" : "error" : "info" : "debug";
    }

    public static void c() {
        synchronized (i.class) {
            f48853c = new ArrayList();
        }
        f48852b = false;
    }

    public static void d(int i, String str) {
        e(b(i), str);
    }

    public static void e(String str, String str2) {
        if (f48851a) {
            f(c.b(str, str2));
        }
    }

    public static void f(d.b.h0.a.k0.b.b bVar) {
        if (!f48852b) {
            synchronized (i.class) {
                if (f48853c != null) {
                    f48853c.add(bVar);
                    return;
                }
            }
        }
        d.b.h0.a.z0.f.V().z("console", bVar);
    }

    public static void g(String str, String str2) {
        if (f48851a) {
            f(c.d(str, str2));
        }
    }

    public static void h(boolean z) {
        f48851a = z;
        d.b.h0.a.c0.c.k(z);
    }
}
