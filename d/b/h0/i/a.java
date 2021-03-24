package d.b.h0.i;

import com.baidu.tbadk.core.BaseFragmentActivity;
import d.b.h0.i.b;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static b f50222a = null;

    /* renamed from: b  reason: collision with root package name */
    public static a f50223b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f50224c = false;

    static {
        new ArrayList(5);
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        b bVar;
        if (f50223b == null) {
            synchronized (a.class) {
                if (f50223b == null) {
                    f50223b = new a();
                    f50222a = b.a(baseFragmentActivity);
                }
            }
        } else {
            b bVar2 = f50222a;
            if (bVar2 != null) {
                bVar2.j(baseFragmentActivity.getPageContext());
            }
        }
        if (f50224c && (bVar = f50222a) != null) {
            bVar.d();
            f50222a.c();
            f50224c = false;
        }
        return f50223b;
    }

    public static void h() {
        try {
            if (f50222a != null) {
                if (f50223b != null) {
                    f50223b.j();
                }
                f50222a.e();
                f50222a.i();
                f50222a = null;
            }
            if (f50223b != null) {
                f50223b = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void b() {
        if (f50222a == null) {
        }
    }

    public void c() {
        b();
        b bVar = f50222a;
        if (bVar != null) {
            bVar.d();
            f50224c = false;
        }
    }

    public void d() {
        b();
        b bVar = f50222a;
        if (bVar != null) {
            bVar.c();
            f50224c = false;
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
        b bVar = f50222a;
        if (bVar != null) {
            if (bVar.b()) {
                f50222a.k(aVar);
            }
            f50222a.f();
        }
    }

    public void g(int i, b.a aVar) {
        b();
        b bVar = f50222a;
        if (bVar != null) {
            if (bVar.b()) {
                f50222a.k(aVar);
            }
            f50222a.g(i);
        }
    }

    public void i() {
        b();
        b bVar = f50222a;
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
        b bVar = f50222a;
        if (bVar != null) {
            bVar.k(aVar);
        }
    }

    public void l(boolean z) {
        b();
        b bVar = f50222a;
        if (bVar != null) {
            bVar.l(z);
        }
    }

    public void m() {
        b();
        b bVar = f50222a;
        if (bVar != null) {
            bVar.m();
            f50224c = true;
        }
    }
}
