package d.b.b0.b.f;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import d.b.d0.a.b;
/* loaded from: classes2.dex */
public class e {
    @NonNull
    public static d.b.d0.a.b a(@NonNull g gVar) {
        b.C0593b c0593b = new b.C0593b(gVar.e(), gVar.f42167g);
        c0593b.t("rsplash");
        c0593b.l(gVar.f42166f == 1);
        c0593b.h(b());
        c0593b.m(c());
        c0593b.o(gVar.f42166f == 1);
        c0593b.n(d(gVar.m));
        c0593b.B(gVar.n * 1000);
        c0593b.z(1);
        c0593b.E(SplashStyleRecorder.a());
        c0593b.i(5);
        c0593b.x(false);
        c0593b.c(gVar.l);
        c0593b.e(25);
        c0593b.d(13);
        c0593b.A(72);
        c0593b.y(30);
        c0593b.D(68);
        c0593b.C(30);
        c0593b.k(17);
        c0593b.q(gVar.y);
        c0593b.w(gVar.z == 1);
        c0593b.b(gVar.A);
        c0593b.p(gVar.d());
        c0593b.r("跳转详情页或第三方应用");
        c0593b.s(gVar.f() ? 47 : b() + 39);
        return c0593b.a();
    }

    public static int b() {
        if (d.b.b0.a.b.a.f42106a.get() == null || d.b.b0.a.b.a.f42106a.get().g() == 0) {
            return 120;
        }
        return d.b.b0.a.b.a.f42106a.get().g();
    }

    @IdRes
    public static int c() {
        if (d.b.b0.a.b.a.f42106a.get() == null) {
            return -1;
        }
        return d.b.b0.a.b.a.f42106a.get().h();
    }

    @IdRes
    public static int d(int i) {
        if (d.b.b0.a.b.a.f42106a.get() == null) {
            return -1;
        }
        if (i == 1) {
            return d.b.b0.a.b.a.f42106a.get().B();
        }
        return d.b.b0.a.b.a.f42106a.get().r();
    }
}
