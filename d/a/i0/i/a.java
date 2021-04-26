package d.a.i0.i;

import com.baidu.tbadk.core.BaseFragmentActivity;
import d.a.i0.i.b;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static b f48548a = null;

    /* renamed from: b  reason: collision with root package name */
    public static a f48549b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f48550c = false;

    static {
        new ArrayList(5);
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        b bVar;
        if (f48549b == null) {
            synchronized (a.class) {
                if (f48549b == null) {
                    f48549b = new a();
                    f48548a = b.a(baseFragmentActivity);
                }
            }
        } else {
            b bVar2 = f48548a;
            if (bVar2 != null) {
                bVar2.j(baseFragmentActivity.getPageContext());
            }
        }
        if (f48550c && (bVar = f48548a) != null) {
            bVar.d();
            f48548a.c();
            f48550c = false;
        }
        return f48549b;
    }

    public static void h() {
        try {
            if (f48548a != null) {
                if (f48549b != null) {
                    f48549b.j();
                }
                f48548a.e();
                f48548a.i();
                f48548a = null;
            }
            if (f48549b != null) {
                f48549b = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void b() {
        if (f48548a == null) {
        }
    }

    public void c() {
        b();
        b bVar = f48548a;
        if (bVar != null) {
            bVar.d();
            f48550c = false;
        }
    }

    public void d() {
        b();
        b bVar = f48548a;
        if (bVar != null) {
            bVar.c();
            f48550c = false;
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
        b bVar = f48548a;
        if (bVar != null) {
            if (bVar.b()) {
                f48548a.k(aVar);
            }
            f48548a.f();
        }
    }

    public void g(int i2, b.a aVar) {
        b();
        b bVar = f48548a;
        if (bVar != null) {
            if (bVar.b()) {
                f48548a.k(aVar);
            }
            f48548a.g(i2);
        }
    }

    public void i() {
        b();
        b bVar = f48548a;
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
        b bVar = f48548a;
        if (bVar != null) {
            bVar.k(aVar);
        }
    }

    public void l(boolean z) {
        b();
        b bVar = f48548a;
        if (bVar != null) {
            bVar.l(z);
        }
    }

    public void m() {
        b();
        b bVar = f48548a;
        if (bVar != null) {
            bVar.m();
            f48550c = true;
        }
    }
}
