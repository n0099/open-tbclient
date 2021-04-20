package d.b.h0.i;

import com.baidu.tbadk.core.BaseFragmentActivity;
import d.b.h0.i.b;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static b f50630a = null;

    /* renamed from: b  reason: collision with root package name */
    public static a f50631b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f50632c = false;

    static {
        new ArrayList(5);
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        b bVar;
        if (f50631b == null) {
            synchronized (a.class) {
                if (f50631b == null) {
                    f50631b = new a();
                    f50630a = b.a(baseFragmentActivity);
                }
            }
        } else {
            b bVar2 = f50630a;
            if (bVar2 != null) {
                bVar2.j(baseFragmentActivity.getPageContext());
            }
        }
        if (f50632c && (bVar = f50630a) != null) {
            bVar.d();
            f50630a.c();
            f50632c = false;
        }
        return f50631b;
    }

    public static void h() {
        try {
            if (f50630a != null) {
                if (f50631b != null) {
                    f50631b.j();
                }
                f50630a.e();
                f50630a.i();
                f50630a = null;
            }
            if (f50631b != null) {
                f50631b = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void b() {
        if (f50630a == null) {
        }
    }

    public void c() {
        b();
        b bVar = f50630a;
        if (bVar != null) {
            bVar.d();
            f50632c = false;
        }
    }

    public void d() {
        b();
        b bVar = f50630a;
        if (bVar != null) {
            bVar.c();
            f50632c = false;
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
        b bVar = f50630a;
        if (bVar != null) {
            if (bVar.b()) {
                f50630a.k(aVar);
            }
            f50630a.f();
        }
    }

    public void g(int i, b.a aVar) {
        b();
        b bVar = f50630a;
        if (bVar != null) {
            if (bVar.b()) {
                f50630a.k(aVar);
            }
            f50630a.g(i);
        }
    }

    public void i() {
        b();
        b bVar = f50630a;
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
        b bVar = f50630a;
        if (bVar != null) {
            bVar.k(aVar);
        }
    }

    public void l(boolean z) {
        b();
        b bVar = f50630a;
        if (bVar != null) {
            bVar.l(z);
        }
    }

    public void m() {
        b();
        b bVar = f50630a;
        if (bVar != null) {
            bVar.m();
            f50632c = true;
        }
    }
}
