package d.a.b0.b.f;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import d.a.d0.a.b;
/* loaded from: classes2.dex */
public class e {
    @NonNull
    public static d.a.d0.a.b a(@NonNull g gVar) {
        b.C0532b c0532b = new b.C0532b(gVar.e(), gVar.f39350g);
        c0532b.t("rsplash");
        c0532b.l(gVar.f39349f == 1);
        c0532b.h(b());
        c0532b.m(c());
        c0532b.o(gVar.f39349f == 1);
        c0532b.n(d(gVar.m));
        c0532b.B(gVar.n * 1000);
        c0532b.z(1);
        c0532b.E(SplashStyleRecorder.a());
        c0532b.i(5);
        c0532b.x(false);
        c0532b.c(gVar.l);
        c0532b.e(25);
        c0532b.d(13);
        c0532b.A(72);
        c0532b.y(30);
        c0532b.D(68);
        c0532b.C(30);
        c0532b.k(17);
        c0532b.q(gVar.y);
        c0532b.w(gVar.z == 1);
        c0532b.b(gVar.A);
        c0532b.p(gVar.d());
        c0532b.r("跳转详情页或第三方应用");
        c0532b.s(gVar.f() ? 47 : b() + 39);
        return c0532b.a();
    }

    public static int b() {
        if (d.a.b0.a.b.a.f39288a.get() == null || d.a.b0.a.b.a.f39288a.get().d() == 0) {
            return 120;
        }
        return d.a.b0.a.b.a.f39288a.get().d();
    }

    @IdRes
    public static int c() {
        if (d.a.b0.a.b.a.f39288a.get() == null) {
            return -1;
        }
        return d.a.b0.a.b.a.f39288a.get().e();
    }

    @IdRes
    public static int d(int i2) {
        if (d.a.b0.a.b.a.f39288a.get() == null) {
            return -1;
        }
        if (i2 == 1) {
            return d.a.b0.a.b.a.f39288a.get().E();
        }
        return d.a.b0.a.b.a.f39288a.get().B();
    }
}
