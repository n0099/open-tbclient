package d.b.g0.g.f;

import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f48522a = false;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f48523b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile List<d.b.g0.a.k0.b.b> f48524c = new ArrayList();

    public static void a() {
        if (!f48522a || f48523b) {
            return;
        }
        synchronized (i.class) {
            if (f48524c != null) {
                for (int i = 0; i < f48524c.size(); i++) {
                    d.b.g0.a.z0.f.V().z("console", f48524c.get(i));
                }
                f48524c.clear();
                f48524c = null;
            }
        }
        f48523b = true;
    }

    public static String b(int i) {
        return i != 2 ? i != 3 ? i != 4 ? i != 5 ? i != 6 ? TbConfig.TMP_LOG_DIR_NAME : "debug" : "warn" : "error" : "info" : "debug";
    }

    public static void c() {
        synchronized (i.class) {
            f48524c = new ArrayList();
        }
        f48523b = false;
    }

    public static void d(int i, String str) {
        e(b(i), str);
    }

    public static void e(String str, String str2) {
        if (f48522a) {
            f(c.b(str, str2));
        }
    }

    public static void f(d.b.g0.a.k0.b.b bVar) {
        if (!f48523b) {
            synchronized (i.class) {
                if (f48524c != null) {
                    f48524c.add(bVar);
                    return;
                }
            }
        }
        d.b.g0.a.z0.f.V().z("console", bVar);
    }

    public static void g(String str, String str2) {
        if (f48522a) {
            f(c.d(str, str2));
        }
    }

    public static void h(boolean z) {
        f48522a = z;
        d.b.g0.a.c0.c.k(z);
    }
}
