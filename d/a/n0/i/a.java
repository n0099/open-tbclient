package d.a.n0.i;

import com.baidu.tbadk.core.BaseFragmentActivity;
import d.a.n0.i.b;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static b f53201a = null;

    /* renamed from: b  reason: collision with root package name */
    public static a f53202b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f53203c = false;

    static {
        new ArrayList(5);
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        b bVar;
        if (f53202b == null) {
            synchronized (a.class) {
                if (f53202b == null) {
                    f53202b = new a();
                    f53201a = b.a(baseFragmentActivity);
                }
            }
        } else {
            b bVar2 = f53201a;
            if (bVar2 != null) {
                bVar2.j(baseFragmentActivity.getPageContext());
            }
        }
        if (f53203c && (bVar = f53201a) != null) {
            bVar.d();
            f53201a.c();
            f53203c = false;
        }
        return f53202b;
    }

    public static void h() {
        try {
            if (f53201a != null) {
                if (f53202b != null) {
                    f53202b.j();
                }
                f53201a.e();
                f53201a.i();
                f53201a = null;
            }
            if (f53202b != null) {
                f53202b = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void b() {
        if (f53201a == null) {
        }
    }

    public void c() {
        b();
        b bVar = f53201a;
        if (bVar != null) {
            bVar.d();
            f53203c = false;
        }
    }

    public void d() {
        b();
        b bVar = f53201a;
        if (bVar != null) {
            bVar.c();
            f53203c = false;
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
        b bVar = f53201a;
        if (bVar != null) {
            if (bVar.b()) {
                f53201a.k(aVar);
            }
            f53201a.f();
        }
    }

    public void g(int i2, b.a aVar) {
        b();
        b bVar = f53201a;
        if (bVar != null) {
            if (bVar.b()) {
                f53201a.k(aVar);
            }
            f53201a.g(i2);
        }
    }

    public void i() {
        b();
        b bVar = f53201a;
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
        b bVar = f53201a;
        if (bVar != null) {
            bVar.k(aVar);
        }
    }

    public void l(boolean z) {
        b();
        b bVar = f53201a;
        if (bVar != null) {
            bVar.l(z);
        }
    }

    public void m() {
        b();
        b bVar = f53201a;
        if (bVar != null) {
            bVar.m();
            f53203c = true;
        }
    }
}
