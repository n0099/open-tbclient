package d.a.e0.b.g;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.h0.a.b;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static d.a.h0.a.b a(@NonNull h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, hVar)) == null) {
            b.C0593b c0593b = new b.C0593b(hVar.e(), hVar.f42286g);
            c0593b.t("rsplash");
            c0593b.l(hVar.f42285f == 1);
            c0593b.h(b());
            c0593b.m(c());
            c0593b.o(hVar.f42285f == 1);
            c0593b.n(d(hVar.m));
            c0593b.B(hVar.n * 1000);
            c0593b.z(1);
            c0593b.E(SplashStyleRecorder.a());
            c0593b.i(5);
            c0593b.x(false);
            c0593b.c(hVar.l);
            c0593b.e(25);
            c0593b.d(13);
            c0593b.A(72);
            c0593b.y(30);
            c0593b.D(68);
            c0593b.C(30);
            c0593b.k(17);
            c0593b.q(hVar.y);
            c0593b.w(hVar.z == 1);
            c0593b.b(hVar.A);
            c0593b.p(hVar.d());
            c0593b.r("跳转详情页或第三方应用");
            c0593b.s(hVar.f() ? 47 : b() + 39);
            return c0593b.a();
        }
        return (d.a.h0.a.b) invokeL.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (d.a.e0.a.b.a.f42209a.get() == null || d.a.e0.a.b.a.f42209a.get().d() == 0) {
                return 120;
            }
            return d.a.e0.a.b.a.f42209a.get().d();
        }
        return invokeV.intValue;
    }

    @IdRes
    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d.a.e0.a.b.a.f42209a.get() == null) {
                return -1;
            }
            return d.a.e0.a.b.a.f42209a.get().e();
        }
        return invokeV.intValue;
    }

    @IdRes
    public static int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            if (d.a.e0.a.b.a.f42209a.get() == null) {
                return -1;
            }
            if (i2 == 1) {
                return d.a.e0.a.b.a.f42209a.get().E();
            }
            return d.a.e0.a.b.a.f42209a.get().B();
        }
        return invokeI.intValue;
    }
}
