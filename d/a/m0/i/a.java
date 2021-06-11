package d.a.m0.i;

import com.baidu.tbadk.core.BaseFragmentActivity;
import d.a.m0.i.b;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static b f53094a = null;

    /* renamed from: b  reason: collision with root package name */
    public static a f53095b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f53096c = false;

    static {
        new ArrayList(5);
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        b bVar;
        if (f53095b == null) {
            synchronized (a.class) {
                if (f53095b == null) {
                    f53095b = new a();
                    f53094a = b.a(baseFragmentActivity);
                }
            }
        } else {
            b bVar2 = f53094a;
            if (bVar2 != null) {
                bVar2.j(baseFragmentActivity.getPageContext());
            }
        }
        if (f53096c && (bVar = f53094a) != null) {
            bVar.d();
            f53094a.c();
            f53096c = false;
        }
        return f53095b;
    }

    public static void h() {
        try {
            if (f53094a != null) {
                if (f53095b != null) {
                    f53095b.j();
                }
                f53094a.e();
                f53094a.i();
                f53094a = null;
            }
            if (f53095b != null) {
                f53095b = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void b() {
        if (f53094a == null) {
        }
    }

    public void c() {
        b();
        b bVar = f53094a;
        if (bVar != null) {
            bVar.d();
            f53096c = false;
        }
    }

    public void d() {
        b();
        b bVar = f53094a;
        if (bVar != null) {
            bVar.c();
            f53096c = false;
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
        b bVar = f53094a;
        if (bVar != null) {
            if (bVar.b()) {
                f53094a.k(aVar);
            }
            f53094a.f();
        }
    }

    public void g(int i2, b.a aVar) {
        b();
        b bVar = f53094a;
        if (bVar != null) {
            if (bVar.b()) {
                f53094a.k(aVar);
            }
            f53094a.g(i2);
        }
    }

    public void i() {
        b();
        b bVar = f53094a;
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
        b bVar = f53094a;
        if (bVar != null) {
            bVar.k(aVar);
        }
    }

    public void l(boolean z) {
        b();
        b bVar = f53094a;
        if (bVar != null) {
            bVar.l(z);
        }
    }

    public void m() {
        b();
        b bVar = f53094a;
        if (bVar != null) {
            bVar.m();
            f53096c = true;
        }
    }
}
