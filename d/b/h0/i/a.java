package d.b.h0.i;

import com.baidu.tbadk.core.BaseFragmentActivity;
import d.b.h0.i.b;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static b f50223a = null;

    /* renamed from: b  reason: collision with root package name */
    public static a f50224b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f50225c = false;

    static {
        new ArrayList(5);
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        b bVar;
        if (f50224b == null) {
            synchronized (a.class) {
                if (f50224b == null) {
                    f50224b = new a();
                    f50223a = b.a(baseFragmentActivity);
                }
            }
        } else {
            b bVar2 = f50223a;
            if (bVar2 != null) {
                bVar2.j(baseFragmentActivity.getPageContext());
            }
        }
        if (f50225c && (bVar = f50223a) != null) {
            bVar.d();
            f50223a.c();
            f50225c = false;
        }
        return f50224b;
    }

    public static void h() {
        try {
            if (f50223a != null) {
                if (f50224b != null) {
                    f50224b.j();
                }
                f50223a.e();
                f50223a.i();
                f50223a = null;
            }
            if (f50224b != null) {
                f50224b = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void b() {
        if (f50223a == null) {
        }
    }

    public void c() {
        b();
        b bVar = f50223a;
        if (bVar != null) {
            bVar.d();
            f50225c = false;
        }
    }

    public void d() {
        b();
        b bVar = f50223a;
        if (bVar != null) {
            bVar.c();
            f50225c = false;
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
        b bVar = f50223a;
        if (bVar != null) {
            if (bVar.b()) {
                f50223a.k(aVar);
            }
            f50223a.f();
        }
    }

    public void g(int i, b.a aVar) {
        b();
        b bVar = f50223a;
        if (bVar != null) {
            if (bVar.b()) {
                f50223a.k(aVar);
            }
            f50223a.g(i);
        }
    }

    public void i() {
        b();
        b bVar = f50223a;
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
        b bVar = f50223a;
        if (bVar != null) {
            bVar.k(aVar);
        }
    }

    public void l(boolean z) {
        b();
        b bVar = f50223a;
        if (bVar != null) {
            bVar.l(z);
        }
    }

    public void m() {
        b();
        b bVar = f50223a;
        if (bVar != null) {
            bVar.m();
            f50225c = true;
        }
    }
}
