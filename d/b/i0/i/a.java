package d.b.i0.i;

import com.baidu.tbadk.core.BaseFragmentActivity;
import d.b.i0.i.b;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static b f50966a = null;

    /* renamed from: b  reason: collision with root package name */
    public static a f50967b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f50968c = false;

    static {
        new ArrayList(5);
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        b bVar;
        if (f50967b == null) {
            synchronized (a.class) {
                if (f50967b == null) {
                    f50967b = new a();
                    f50966a = b.a(baseFragmentActivity);
                }
            }
        } else {
            b bVar2 = f50966a;
            if (bVar2 != null) {
                bVar2.j(baseFragmentActivity.getPageContext());
            }
        }
        if (f50968c && (bVar = f50966a) != null) {
            bVar.d();
            f50966a.c();
            f50968c = false;
        }
        return f50967b;
    }

    public static void h() {
        try {
            if (f50966a != null) {
                if (f50967b != null) {
                    f50967b.j();
                }
                f50966a.e();
                f50966a.i();
                f50966a = null;
            }
            if (f50967b != null) {
                f50967b = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void b() {
        if (f50966a == null) {
        }
    }

    public void c() {
        b();
        b bVar = f50966a;
        if (bVar != null) {
            bVar.d();
            f50968c = false;
        }
    }

    public void d() {
        b();
        b bVar = f50966a;
        if (bVar != null) {
            bVar.c();
            f50968c = false;
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
        b bVar = f50966a;
        if (bVar != null) {
            if (bVar.b()) {
                f50966a.k(aVar);
            }
            f50966a.f();
        }
    }

    public void g(int i, b.a aVar) {
        b();
        b bVar = f50966a;
        if (bVar != null) {
            if (bVar.b()) {
                f50966a.k(aVar);
            }
            f50966a.g(i);
        }
    }

    public void i() {
        b();
        b bVar = f50966a;
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
        b bVar = f50966a;
        if (bVar != null) {
            bVar.k(aVar);
        }
    }

    public void l(boolean z) {
        b();
        b bVar = f50966a;
        if (bVar != null) {
            bVar.l(z);
        }
    }

    public void m() {
        b();
        b bVar = f50966a;
        if (bVar != null) {
            bVar.m();
            f50968c = true;
        }
    }
}
