package d.a.b0.b.f;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import d.a.d0.a.b;
/* loaded from: classes2.dex */
public class e {
    @NonNull
    public static d.a.d0.a.b a(@NonNull g gVar) {
        b.C0519b c0519b = new b.C0519b(gVar.e(), gVar.f38595g);
        c0519b.t("rsplash");
        c0519b.l(gVar.f38594f == 1);
        c0519b.h(b());
        c0519b.m(c());
        c0519b.o(gVar.f38594f == 1);
        c0519b.n(d(gVar.m));
        c0519b.B(gVar.n * 1000);
        c0519b.z(1);
        c0519b.E(SplashStyleRecorder.a());
        c0519b.i(5);
        c0519b.x(false);
        c0519b.c(gVar.l);
        c0519b.e(25);
        c0519b.d(13);
        c0519b.A(72);
        c0519b.y(30);
        c0519b.D(68);
        c0519b.C(30);
        c0519b.k(17);
        c0519b.q(gVar.y);
        c0519b.w(gVar.z == 1);
        c0519b.b(gVar.A);
        c0519b.p(gVar.d());
        c0519b.r("跳转详情页或第三方应用");
        c0519b.s(gVar.f() ? 47 : b() + 39);
        return c0519b.a();
    }

    public static int b() {
        if (d.a.b0.a.b.a.f38533a.get() == null || d.a.b0.a.b.a.f38533a.get().d() == 0) {
            return 120;
        }
        return d.a.b0.a.b.a.f38533a.get().d();
    }

    @IdRes
    public static int c() {
        if (d.a.b0.a.b.a.f38533a.get() == null) {
            return -1;
        }
        return d.a.b0.a.b.a.f38533a.get().e();
    }

    @IdRes
    public static int d(int i2) {
        if (d.a.b0.a.b.a.f38533a.get() == null) {
            return -1;
        }
        if (i2 == 1) {
            return d.a.b0.a.b.a.f38533a.get().E();
        }
        return d.a.b0.a.b.a.f38533a.get().B();
    }
}
