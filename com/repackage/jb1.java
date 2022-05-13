package com.repackage;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.dd1;
/* loaded from: classes6.dex */
public class jb1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static dd1 a(@NonNull mb1 mb1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, mb1Var)) == null) {
            dd1.b bVar = new dd1.b(mb1Var.e(), mb1Var.g);
            bVar.t("rsplash");
            bVar.i(mb1Var.f == 1);
            bVar.f(b());
            bVar.m(c());
            bVar.o(mb1Var.f == 1);
            bVar.n(d(mb1Var.m));
            bVar.z(mb1Var.n * 1000);
            bVar.x(1);
            bVar.C(SplashStyleRecorder.a());
            bVar.g(5);
            bVar.v(false);
            bVar.c(mb1Var.l);
            bVar.e(25);
            bVar.d(13);
            bVar.y(72);
            bVar.w(30);
            bVar.B(68);
            bVar.A(30);
            bVar.h(17);
            bVar.q(mb1Var.z);
            bVar.u(mb1Var.A == 1);
            bVar.b(mb1Var.B);
            bVar.p(mb1Var.d());
            bVar.r("跳转详情页或第三方应用");
            bVar.s(mb1Var.g() ? 47 : b() + 39);
            bVar.j(mb1Var.H);
            bVar.l(mb1Var.G);
            bVar.k(mb1Var.I);
            return bVar.a();
        }
        return (dd1) invokeL.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? za1.a().b() : invokeV.intValue;
    }

    @IdRes
    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? za1.a().c() : invokeV.intValue;
    }

    @IdRes
    public static int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i == 1) {
                return za1.a().h();
            }
            return za1.a().g();
        }
        return invokeI.intValue;
    }
}
