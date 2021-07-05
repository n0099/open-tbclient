package d.a.h0.b.g;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.k0.a.b;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static d.a.k0.a.b a(@NonNull h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, hVar)) == null) {
            b.C0650b c0650b = new b.C0650b(hVar.e(), hVar.f45638g);
            c0650b.t("rsplash");
            c0650b.l(hVar.f45637f == 1);
            c0650b.h(b());
            c0650b.m(c());
            c0650b.o(hVar.f45637f == 1);
            c0650b.n(d(hVar.m));
            c0650b.B(hVar.n * 1000);
            c0650b.z(1);
            c0650b.E(SplashStyleRecorder.a());
            c0650b.i(5);
            c0650b.x(false);
            c0650b.c(hVar.l);
            c0650b.e(25);
            c0650b.d(13);
            c0650b.A(72);
            c0650b.y(30);
            c0650b.D(68);
            c0650b.C(30);
            c0650b.k(17);
            c0650b.q(hVar.y);
            c0650b.w(hVar.z == 1);
            c0650b.b(hVar.A);
            c0650b.p(hVar.d());
            c0650b.r("跳转详情页或第三方应用");
            c0650b.s(hVar.f() ? 47 : b() + 39);
            return c0650b.a();
        }
        return (d.a.k0.a.b) invokeL.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (d.a.h0.a.b.a.f45561a.get() == null || d.a.h0.a.b.a.f45561a.get().d() == 0) {
                return 120;
            }
            return d.a.h0.a.b.a.f45561a.get().d();
        }
        return invokeV.intValue;
    }

    @IdRes
    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d.a.h0.a.b.a.f45561a.get() == null) {
                return -1;
            }
            return d.a.h0.a.b.a.f45561a.get().e();
        }
        return invokeV.intValue;
    }

    @IdRes
    public static int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            if (d.a.h0.a.b.a.f45561a.get() == null) {
                return -1;
            }
            if (i2 == 1) {
                return d.a.h0.a.b.a.f45561a.get().E();
            }
            return d.a.h0.a.b.a.f45561a.get().B();
        }
        return invokeI.intValue;
    }
}
