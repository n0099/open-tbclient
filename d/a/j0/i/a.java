package d.a.j0.i;

import com.baidu.tbadk.core.BaseFragmentActivity;
import d.a.j0.i.b;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static b f49376a = null;

    /* renamed from: b  reason: collision with root package name */
    public static a f49377b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f49378c = false;

    static {
        new ArrayList(5);
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        b bVar;
        if (f49377b == null) {
            synchronized (a.class) {
                if (f49377b == null) {
                    f49377b = new a();
                    f49376a = b.a(baseFragmentActivity);
                }
            }
        } else {
            b bVar2 = f49376a;
            if (bVar2 != null) {
                bVar2.j(baseFragmentActivity.getPageContext());
            }
        }
        if (f49378c && (bVar = f49376a) != null) {
            bVar.d();
            f49376a.c();
            f49378c = false;
        }
        return f49377b;
    }

    public static void h() {
        try {
            if (f49376a != null) {
                if (f49377b != null) {
                    f49377b.j();
                }
                f49376a.e();
                f49376a.i();
                f49376a = null;
            }
            if (f49377b != null) {
                f49377b = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void b() {
        if (f49376a == null) {
        }
    }

    public void c() {
        b();
        b bVar = f49376a;
        if (bVar != null) {
            bVar.d();
            f49378c = false;
        }
    }

    public void d() {
        b();
        b bVar = f49376a;
        if (bVar != null) {
            bVar.c();
            f49378c = false;
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
        b bVar = f49376a;
        if (bVar != null) {
            if (bVar.b()) {
                f49376a.k(aVar);
            }
            f49376a.f();
        }
    }

    public void g(int i2, b.a aVar) {
        b();
        b bVar = f49376a;
        if (bVar != null) {
            if (bVar.b()) {
                f49376a.k(aVar);
            }
            f49376a.g(i2);
        }
    }

    public void i() {
        b();
        b bVar = f49376a;
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
        b bVar = f49376a;
        if (bVar != null) {
            bVar.k(aVar);
        }
    }

    public void l(boolean z) {
        b();
        b bVar = f49376a;
        if (bVar != null) {
            bVar.l(z);
        }
    }

    public void m() {
        b();
        b bVar = f49376a;
        if (bVar != null) {
            bVar.m();
            f49378c = true;
        }
    }
}
