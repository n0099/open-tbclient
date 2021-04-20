package d.b.a0.b.f;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import d.b.c0.a.b;
/* loaded from: classes2.dex */
public class e {
    @NonNull
    public static d.b.c0.a.b a(@NonNull g gVar) {
        b.C0571b c0571b = new b.C0571b(gVar.e(), gVar.f41878g);
        c0571b.t("rsplash");
        c0571b.l(gVar.f41877f == 1);
        c0571b.h(b());
        c0571b.m(c());
        c0571b.o(gVar.f41877f == 1);
        c0571b.n(d(gVar.m));
        c0571b.B(gVar.n * 1000);
        c0571b.z(1);
        c0571b.E(SplashStyleRecorder.a());
        c0571b.i(5);
        c0571b.x(false);
        c0571b.c(gVar.l);
        c0571b.e(25);
        c0571b.d(13);
        c0571b.A(72);
        c0571b.y(30);
        c0571b.D(68);
        c0571b.C(30);
        c0571b.k(17);
        c0571b.q(gVar.y);
        c0571b.w(gVar.z == 1);
        c0571b.b(gVar.A);
        c0571b.p(gVar.d());
        c0571b.r("跳转详情页或第三方应用");
        c0571b.s(gVar.f() ? 47 : b() + 39);
        return c0571b.a();
    }

    public static int b() {
        if (d.b.a0.a.b.a.f41817a.get() == null || d.b.a0.a.b.a.f41817a.get().g() == 0) {
            return 120;
        }
        return d.b.a0.a.b.a.f41817a.get().g();
    }

    @IdRes
    public static int c() {
        if (d.b.a0.a.b.a.f41817a.get() == null) {
            return -1;
        }
        return d.b.a0.a.b.a.f41817a.get().h();
    }

    @IdRes
    public static int d(int i) {
        if (d.b.a0.a.b.a.f41817a.get() == null) {
            return -1;
        }
        if (i == 1) {
            return d.b.a0.a.b.a.f41817a.get().B();
        }
        return d.b.a0.a.b.a.f41817a.get().r();
    }
}
