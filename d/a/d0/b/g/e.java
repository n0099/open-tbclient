package d.a.d0.b.g;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import d.a.f0.a.b;
/* loaded from: classes2.dex */
public class e {
    @NonNull
    public static d.a.f0.a.b a(@NonNull h hVar) {
        b.C0581b c0581b = new b.C0581b(hVar.e(), hVar.f43345g);
        c0581b.t("rsplash");
        c0581b.l(hVar.f43344f == 1);
        c0581b.h(b());
        c0581b.m(c());
        c0581b.o(hVar.f43344f == 1);
        c0581b.n(d(hVar.m));
        c0581b.B(hVar.n * 1000);
        c0581b.z(1);
        c0581b.E(SplashStyleRecorder.a());
        c0581b.i(5);
        c0581b.x(false);
        c0581b.c(hVar.l);
        c0581b.e(25);
        c0581b.d(13);
        c0581b.A(72);
        c0581b.y(30);
        c0581b.D(68);
        c0581b.C(30);
        c0581b.k(17);
        c0581b.q(hVar.y);
        c0581b.w(hVar.z == 1);
        c0581b.b(hVar.A);
        c0581b.p(hVar.d());
        c0581b.r("跳转详情页或第三方应用");
        c0581b.s(hVar.f() ? 47 : b() + 39);
        return c0581b.a();
    }

    public static int b() {
        if (d.a.d0.a.b.a.f43271a.get() == null || d.a.d0.a.b.a.f43271a.get().d() == 0) {
            return 120;
        }
        return d.a.d0.a.b.a.f43271a.get().d();
    }

    @IdRes
    public static int c() {
        if (d.a.d0.a.b.a.f43271a.get() == null) {
            return -1;
        }
        return d.a.d0.a.b.a.f43271a.get().e();
    }

    @IdRes
    public static int d(int i2) {
        if (d.a.d0.a.b.a.f43271a.get() == null) {
            return -1;
        }
        if (i2 == 1) {
            return d.a.d0.a.b.a.f43271a.get().E();
        }
        return d.a.d0.a.b.a.f43271a.get().B();
    }
}
