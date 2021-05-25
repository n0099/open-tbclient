package d.a.d0.b.g;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import d.a.f0.a.b;
/* loaded from: classes2.dex */
public class e {
    @NonNull
    public static d.a.f0.a.b a(@NonNull h hVar) {
        b.C0525b c0525b = new b.C0525b(hVar.e(), hVar.f39664g);
        c0525b.t("rsplash");
        c0525b.l(hVar.f39663f == 1);
        c0525b.h(b());
        c0525b.m(c());
        c0525b.o(hVar.f39663f == 1);
        c0525b.n(d(hVar.m));
        c0525b.B(hVar.n * 1000);
        c0525b.z(1);
        c0525b.E(SplashStyleRecorder.a());
        c0525b.i(5);
        c0525b.x(false);
        c0525b.c(hVar.l);
        c0525b.e(25);
        c0525b.d(13);
        c0525b.A(72);
        c0525b.y(30);
        c0525b.D(68);
        c0525b.C(30);
        c0525b.k(17);
        c0525b.q(hVar.y);
        c0525b.w(hVar.z == 1);
        c0525b.b(hVar.A);
        c0525b.p(hVar.d());
        c0525b.r("跳转详情页或第三方应用");
        c0525b.s(hVar.f() ? 47 : b() + 39);
        return c0525b.a();
    }

    public static int b() {
        if (d.a.d0.a.b.a.f39590a.get() == null || d.a.d0.a.b.a.f39590a.get().d() == 0) {
            return 120;
        }
        return d.a.d0.a.b.a.f39590a.get().d();
    }

    @IdRes
    public static int c() {
        if (d.a.d0.a.b.a.f39590a.get() == null) {
            return -1;
        }
        return d.a.d0.a.b.a.f39590a.get().e();
    }

    @IdRes
    public static int d(int i2) {
        if (d.a.d0.a.b.a.f39590a.get() == null) {
            return -1;
        }
        if (i2 == 1) {
            return d.a.d0.a.b.a.f39590a.get().E();
        }
        return d.a.d0.a.b.a.f39590a.get().B();
    }
}
