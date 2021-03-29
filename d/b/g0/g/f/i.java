package d.b.g0.g.f;

import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f48130a = false;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f48131b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile List<d.b.g0.a.k0.b.b> f48132c = new ArrayList();

    public static void a() {
        if (!f48130a || f48131b) {
            return;
        }
        synchronized (i.class) {
            if (f48132c != null) {
                for (int i = 0; i < f48132c.size(); i++) {
                    d.b.g0.a.z0.f.V().z("console", f48132c.get(i));
                }
                f48132c.clear();
                f48132c = null;
            }
        }
        f48131b = true;
    }

    public static String b(int i) {
        return i != 2 ? i != 3 ? i != 4 ? i != 5 ? i != 6 ? TbConfig.TMP_LOG_DIR_NAME : "debug" : "warn" : "error" : "info" : "debug";
    }

    public static void c() {
        synchronized (i.class) {
            f48132c = new ArrayList();
        }
        f48131b = false;
    }

    public static void d(int i, String str) {
        e(b(i), str);
    }

    public static void e(String str, String str2) {
        if (f48130a) {
            f(c.b(str, str2));
        }
    }

    public static void f(d.b.g0.a.k0.b.b bVar) {
        if (!f48131b) {
            synchronized (i.class) {
                if (f48132c != null) {
                    f48132c.add(bVar);
                    return;
                }
            }
        }
        d.b.g0.a.z0.f.V().z("console", bVar);
    }

    public static void g(String str, String str2) {
        if (f48130a) {
            f(c.d(str, str2));
        }
    }

    public static void h(boolean z) {
        f48130a = z;
        d.b.g0.a.c0.c.k(z);
    }
}
