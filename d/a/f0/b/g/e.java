package d.a.f0.b.g;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.i0.a.b;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static d.a.i0.a.b a(@NonNull h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, hVar)) == null) {
            b.C0602b c0602b = new b.C0602b(hVar.e(), hVar.f42790g);
            c0602b.t("rsplash");
            c0602b.l(hVar.f42789f == 1);
            c0602b.h(b());
            c0602b.m(c());
            c0602b.o(hVar.f42789f == 1);
            c0602b.n(d(hVar.m));
            c0602b.B(hVar.n * 1000);
            c0602b.z(1);
            c0602b.E(SplashStyleRecorder.a());
            c0602b.i(5);
            c0602b.x(false);
            c0602b.c(hVar.l);
            c0602b.e(25);
            c0602b.d(13);
            c0602b.A(72);
            c0602b.y(30);
            c0602b.D(68);
            c0602b.C(30);
            c0602b.k(17);
            c0602b.q(hVar.y);
            c0602b.w(hVar.z == 1);
            c0602b.b(hVar.A);
            c0602b.p(hVar.d());
            c0602b.r("跳转详情页或第三方应用");
            c0602b.s(hVar.f() ? 47 : b() + 39);
            return c0602b.a();
        }
        return (d.a.i0.a.b) invokeL.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (d.a.f0.a.b.a.f42713a.get() == null || d.a.f0.a.b.a.f42713a.get().d() == 0) {
                return 120;
            }
            return d.a.f0.a.b.a.f42713a.get().d();
        }
        return invokeV.intValue;
    }

    @IdRes
    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d.a.f0.a.b.a.f42713a.get() == null) {
                return -1;
            }
            return d.a.f0.a.b.a.f42713a.get().e();
        }
        return invokeV.intValue;
    }

    @IdRes
    public static int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            if (d.a.f0.a.b.a.f42713a.get() == null) {
                return -1;
            }
            if (i2 == 1) {
                return d.a.f0.a.b.a.f42713a.get().E();
            }
            return d.a.f0.a.b.a.f42713a.get().B();
        }
        return invokeI.intValue;
    }
}
