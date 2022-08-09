package com.repackage;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.hd1;
/* loaded from: classes6.dex */
public class mb1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static hd1 a(@NonNull qb1 qb1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, qb1Var)) == null) {
            hd1.b bVar = new hd1.b(qb1Var.e(), qb1Var.g);
            bVar.t("rsplash");
            bVar.i(qb1Var.f == 1);
            bVar.f(b());
            bVar.m(c());
            bVar.o(qb1Var.f == 1);
            bVar.n(d(qb1Var.m));
            bVar.B(qb1Var.n * 1000);
            bVar.z(1);
            bVar.E(SplashStyleRecorder.a());
            bVar.g(5);
            bVar.x(false);
            bVar.c(qb1Var.l);
            bVar.e(25);
            bVar.d(13);
            bVar.A(72);
            bVar.y(30);
            bVar.D(68);
            bVar.C(30);
            bVar.h(17);
            bVar.q(qb1Var.z);
            bVar.w(qb1Var.A == 1);
            bVar.b(qb1Var.B);
            bVar.p(qb1Var.d());
            bVar.r("跳转详情页或第三方应用");
            bVar.s(qb1Var.g() ? 47 : b() + 39);
            bVar.j(qb1Var.H);
            bVar.l(qb1Var.G);
            bVar.k(qb1Var.I);
            bVar.v(qb1Var.M);
            bVar.u(qb1Var.N);
            return bVar.a();
        }
        return (hd1) invokeL.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? cb1.a().b() : invokeV.intValue;
    }

    @IdRes
    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? cb1.a().c() : invokeV.intValue;
    }

    @IdRes
    public static int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i == 1) {
                return cb1.a().h();
            }
            return cb1.a().g();
        }
        return invokeI.intValue;
    }
}
