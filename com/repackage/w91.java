package com.repackage;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.qb1;
/* loaded from: classes7.dex */
public class w91 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static qb1 a(@NonNull z91 z91Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, z91Var)) == null) {
            qb1.b bVar = new qb1.b(z91Var.e(), z91Var.g);
            bVar.t("rsplash");
            bVar.i(z91Var.f == 1);
            bVar.f(b());
            bVar.m(c());
            bVar.o(z91Var.f == 1);
            bVar.n(d(z91Var.m));
            bVar.z(z91Var.n * 1000);
            bVar.x(1);
            bVar.C(SplashStyleRecorder.a());
            bVar.g(5);
            bVar.v(false);
            bVar.c(z91Var.l);
            bVar.e(25);
            bVar.d(13);
            bVar.y(72);
            bVar.w(30);
            bVar.B(68);
            bVar.A(30);
            bVar.h(17);
            bVar.q(z91Var.z);
            bVar.u(z91Var.A == 1);
            bVar.b(z91Var.B);
            bVar.p(z91Var.d());
            bVar.r("跳转详情页或第三方应用");
            bVar.s(z91Var.g() ? 47 : b() + 39);
            bVar.j(z91Var.H);
            bVar.l(z91Var.G);
            bVar.k(z91Var.I);
            return bVar.a();
        }
        return (qb1) invokeL.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? m91.a().b() : invokeV.intValue;
    }

    @IdRes
    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? m91.a().c() : invokeV.intValue;
    }

    @IdRes
    public static int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i == 1) {
                return m91.a().h();
            }
            return m91.a().g();
        }
        return invokeI.intValue;
    }
}
