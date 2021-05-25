package d.a.m0.i;

import com.baidu.tbadk.core.BaseFragmentActivity;
import d.a.m0.i.b;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static b f49420a = null;

    /* renamed from: b  reason: collision with root package name */
    public static a f49421b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f49422c = false;

    static {
        new ArrayList(5);
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        b bVar;
        if (f49421b == null) {
            synchronized (a.class) {
                if (f49421b == null) {
                    f49421b = new a();
                    f49420a = b.a(baseFragmentActivity);
                }
            }
        } else {
            b bVar2 = f49420a;
            if (bVar2 != null) {
                bVar2.j(baseFragmentActivity.getPageContext());
            }
        }
        if (f49422c && (bVar = f49420a) != null) {
            bVar.d();
            f49420a.c();
            f49422c = false;
        }
        return f49421b;
    }

    public static void h() {
        try {
            if (f49420a != null) {
                if (f49421b != null) {
                    f49421b.j();
                }
                f49420a.e();
                f49420a.i();
                f49420a = null;
            }
            if (f49421b != null) {
                f49421b = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void b() {
        if (f49420a == null) {
        }
    }

    public void c() {
        b();
        b bVar = f49420a;
        if (bVar != null) {
            bVar.d();
            f49422c = false;
        }
    }

    public void d() {
        b();
        b bVar = f49420a;
        if (bVar != null) {
            bVar.c();
            f49422c = false;
        }
    }

    public void e(boolean z, boolean z2, boolean z3, b.a aVar) {
        b();
        if (z) {
            c();
        }
        if (z2) {
            d();
        }
        l(z3);
        k(aVar);
    }

    public void f(b.a aVar) {
        b();
        b bVar = f49420a;
        if (bVar != null) {
            if (bVar.b()) {
                f49420a.k(aVar);
            }
            f49420a.f();
        }
    }

    public void g(int i2, b.a aVar) {
        b();
        b bVar = f49420a;
        if (bVar != null) {
            if (bVar.b()) {
                f49420a.k(aVar);
            }
            f49420a.g(i2);
        }
    }

    public void i() {
        b();
        b bVar = f49420a;
        if (bVar != null) {
            bVar.h();
        }
    }

    public void j() {
        b();
        i();
        m();
    }

    public void k(b.a aVar) {
        b();
        b bVar = f49420a;
        if (bVar != null) {
            bVar.k(aVar);
        }
    }

    public void l(boolean z) {
        b();
        b bVar = f49420a;
        if (bVar != null) {
            bVar.l(z);
        }
    }

    public void m() {
        b();
        b bVar = f49420a;
        if (bVar != null) {
            bVar.m();
            f49422c = true;
        }
    }
}
