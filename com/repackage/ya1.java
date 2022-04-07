package com.repackage;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.sc1;
/* loaded from: classes7.dex */
public class ya1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static sc1 a(@NonNull bb1 bb1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bb1Var)) == null) {
            sc1.b bVar = new sc1.b(bb1Var.e(), bb1Var.g);
            bVar.t("rsplash");
            bVar.i(bb1Var.f == 1);
            bVar.f(b());
            bVar.m(c());
            bVar.o(bb1Var.f == 1);
            bVar.n(d(bb1Var.m));
            bVar.z(bb1Var.n * 1000);
            bVar.x(1);
            bVar.C(SplashStyleRecorder.a());
            bVar.g(5);
            bVar.v(false);
            bVar.c(bb1Var.l);
            bVar.e(25);
            bVar.d(13);
            bVar.y(72);
            bVar.w(30);
            bVar.B(68);
            bVar.A(30);
            bVar.h(17);
            bVar.q(bb1Var.y);
            bVar.u(bb1Var.z == 1);
            bVar.b(bb1Var.A);
            bVar.p(bb1Var.d());
            bVar.r("跳转详情页或第三方应用");
            bVar.s(bb1Var.g() ? 47 : b() + 39);
            bVar.j(bb1Var.G);
            bVar.l(bb1Var.F);
            bVar.k(bb1Var.H);
            return bVar.a();
        }
        return (sc1) invokeL.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? oa1.a().b() : invokeV.intValue;
    }

    @IdRes
    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? oa1.a().c() : invokeV.intValue;
    }

    @IdRes
    public static int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i == 1) {
                return oa1.a().h();
            }
            return oa1.a().g();
        }
        return invokeI.intValue;
    }
}
