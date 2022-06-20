package com.repackage;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.bc1;
/* loaded from: classes6.dex */
public class ha1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static bc1 a(@NonNull ka1 ka1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ka1Var)) == null) {
            bc1.b bVar = new bc1.b(ka1Var.e(), ka1Var.g);
            bVar.t("rsplash");
            bVar.i(ka1Var.f == 1);
            bVar.f(b());
            bVar.m(c());
            bVar.o(ka1Var.f == 1);
            bVar.n(d(ka1Var.m));
            bVar.z(ka1Var.n * 1000);
            bVar.x(1);
            bVar.C(SplashStyleRecorder.a());
            bVar.g(5);
            bVar.v(false);
            bVar.c(ka1Var.l);
            bVar.e(25);
            bVar.d(13);
            bVar.y(72);
            bVar.w(30);
            bVar.B(68);
            bVar.A(30);
            bVar.h(17);
            bVar.q(ka1Var.z);
            bVar.u(ka1Var.A == 1);
            bVar.b(ka1Var.B);
            bVar.p(ka1Var.d());
            bVar.r("跳转详情页或第三方应用");
            bVar.s(ka1Var.g() ? 47 : b() + 39);
            bVar.j(ka1Var.H);
            bVar.l(ka1Var.G);
            bVar.k(ka1Var.I);
            return bVar.a();
        }
        return (bc1) invokeL.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? x91.a().b() : invokeV.intValue;
    }

    @IdRes
    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? x91.a().c() : invokeV.intValue;
    }

    @IdRes
    public static int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i == 1) {
                return x91.a().h();
            }
            return x91.a().g();
        }
        return invokeI.intValue;
    }
}
