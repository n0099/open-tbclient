package d.a.l0.h.f;

import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f47359a = false;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f47360b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile List<d.a.l0.a.o0.d.b> f47361c = new ArrayList();

    public static void a() {
        if (!f47359a || f47360b) {
            return;
        }
        synchronized (i.class) {
            if (f47361c != null) {
                for (int i2 = 0; i2 < f47361c.size(); i2++) {
                    d.a.l0.a.g1.f.V().m("console", f47361c.get(i2));
                }
                f47361c.clear();
                f47361c = null;
            }
        }
        f47360b = true;
    }

    public static String b(int i2) {
        return i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? i2 != 6 ? TbConfig.TMP_LOG_DIR_NAME : "debug" : "warn" : "error" : "info" : "debug";
    }

    public static void c() {
        synchronized (i.class) {
            f47361c = new ArrayList();
        }
        f47360b = false;
    }

    public static void d(int i2, String str) {
        e(b(i2), str);
    }

    public static void e(String str, String str2) {
        if (f47359a) {
            f(c.h(str, str2));
        }
    }

    public static void f(d.a.l0.a.o0.d.b bVar) {
        if (!f47360b) {
            synchronized (i.class) {
                if (f47361c != null) {
                    f47361c.add(bVar);
                    return;
                }
            }
        }
        d.a.l0.a.g1.f.V().m("console", bVar);
    }

    public static void g(String str, String str2) {
        if (f47359a) {
            f(c.j(str, str2));
        }
    }

    public static void h(boolean z) {
        f47359a = z;
        d.a.l0.a.e0.d.k(z);
    }
}
