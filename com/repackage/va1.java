package com.repackage;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.qc1;
/* loaded from: classes7.dex */
public class va1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static qc1 a(@NonNull za1 za1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, za1Var)) == null) {
            qc1.b bVar = new qc1.b(za1Var.e(), za1Var.g);
            bVar.t("rsplash");
            bVar.i(za1Var.f == 1);
            bVar.f(b());
            bVar.m(c());
            bVar.o(za1Var.f == 1);
            bVar.n(d(za1Var.m));
            bVar.B(za1Var.n * 1000);
            bVar.z(1);
            bVar.E(SplashStyleRecorder.a());
            bVar.g(5);
            bVar.x(false);
            bVar.c(za1Var.l);
            bVar.e(25);
            bVar.d(13);
            bVar.A(72);
            bVar.y(30);
            bVar.D(68);
            bVar.C(30);
            bVar.h(17);
            bVar.q(za1Var.z);
            bVar.w(za1Var.A == 1);
            bVar.b(za1Var.B);
            bVar.p(za1Var.d());
            bVar.r("跳转详情页或第三方应用");
            bVar.s(za1Var.g() ? 47 : b() + 39);
            bVar.j(za1Var.H);
            bVar.l(za1Var.G);
            bVar.k(za1Var.I);
            bVar.v(za1Var.M);
            bVar.u(za1Var.N);
            return bVar.a();
        }
        return (qc1) invokeL.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? la1.a().b() : invokeV.intValue;
    }

    @IdRes
    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? la1.a().c() : invokeV.intValue;
    }

    @IdRes
    public static int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i == 1) {
                return la1.a().h();
            }
            return la1.a().g();
        }
        return invokeI.intValue;
    }
}
