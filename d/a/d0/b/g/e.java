package d.a.d0.b.g;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import d.a.g0.a.b;
/* loaded from: classes2.dex */
public class e {
    @NonNull
    public static d.a.g0.a.b a(@NonNull h hVar) {
        b.C0584b c0584b = new b.C0584b(hVar.e(), hVar.f43448g);
        c0584b.t("rsplash");
        c0584b.l(hVar.f43447f == 1);
        c0584b.h(b());
        c0584b.m(c());
        c0584b.o(hVar.f43447f == 1);
        c0584b.n(d(hVar.m));
        c0584b.B(hVar.n * 1000);
        c0584b.z(1);
        c0584b.E(SplashStyleRecorder.a());
        c0584b.i(5);
        c0584b.x(false);
        c0584b.c(hVar.l);
        c0584b.e(25);
        c0584b.d(13);
        c0584b.A(72);
        c0584b.y(30);
        c0584b.D(68);
        c0584b.C(30);
        c0584b.k(17);
        c0584b.q(hVar.y);
        c0584b.w(hVar.z == 1);
        c0584b.b(hVar.A);
        c0584b.p(hVar.d());
        c0584b.r("跳转详情页或第三方应用");
        c0584b.s(hVar.f() ? 47 : b() + 39);
        return c0584b.a();
    }

    public static int b() {
        if (d.a.d0.a.b.a.f43374a.get() == null || d.a.d0.a.b.a.f43374a.get().d() == 0) {
            return 120;
        }
        return d.a.d0.a.b.a.f43374a.get().d();
    }

    @IdRes
    public static int c() {
        if (d.a.d0.a.b.a.f43374a.get() == null) {
            return -1;
        }
        return d.a.d0.a.b.a.f43374a.get().e();
    }

    @IdRes
    public static int d(int i2) {
        if (d.a.d0.a.b.a.f43374a.get() == null) {
            return -1;
        }
        if (i2 == 1) {
            return d.a.d0.a.b.a.f43374a.get().E();
        }
        return d.a.d0.a.b.a.f43374a.get().B();
    }
}
