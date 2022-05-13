package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class eo4 {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> i;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public boolean h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755730905, "Lcom/repackage/eo4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755730905, "Lcom/repackage/eo4;");
                return;
            }
        }
        i = new HashSet();
    }

    public eo4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? i.contains(str) : invokeL.booleanValue;
    }

    public static void b(AdvertAppInfo advertAppInfo) {
        eo4 eo4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) || advertAppInfo == null || (eo4Var = advertAppInfo.i) == null || eo4Var.h || a(eo4Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.w(ClogBuilder.LogType.SHOW).t(advertAppInfo.j).o(String.valueOf(advertAppInfo.position + 1)).p(eo4Var.d).q(eo4Var.e).r(eo4Var.c).u(String.valueOf(eo4Var.b)).n(advertAppInfo.g);
        ez0.c(clogBuilder);
        kd7.b(kd7.a(advertAppInfo));
        eo4Var.h = true;
        i.add(eo4Var.g);
    }

    public static void c(eo4 eo4Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{eo4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eo4Var == null || eo4Var.h || a(eo4Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.w(z ? ClogBuilder.LogType.STOCK : ClogBuilder.LogType.SHOW).t(eo4Var.a).o(String.valueOf(i2 + 1)).p(eo4Var.d).q(eo4Var.e).r(eo4Var.c).u(String.valueOf(eo4Var.b)).n(eo4Var.g);
        ez0.c(clogBuilder);
        eo4Var.h = true;
        i.add(eo4Var.g);
    }

    public static void d(ay5 ay5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, ay5Var) == null) || ay5Var == null || ay5Var.e() == null || ay5Var.e().i == null || ay5Var.e().i.h || a(ay5Var.e().i.g)) {
            return;
        }
        ay5Var.e().j = ay5Var.e().i.a;
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.w(ClogBuilder.LogType.SHOW).t(ay5Var.e().j).o(String.valueOf(ay5Var.e().position + 1)).u(String.valueOf(ay5Var.e().i.b)).n(ay5Var.e().i.g);
        ez0.c(clogBuilder);
        kd7.b(kd7.a(ay5Var.e()));
        ay5Var.e().i.h = true;
        i.add(ay5Var.e().i.g);
    }

    public static void e(eo4 eo4Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{eo4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eo4Var == null || eo4Var.h || a(eo4Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.w(z ? ClogBuilder.LogType.STOCK : ClogBuilder.LogType.SHOW).t(eo4Var.a).o(String.valueOf(i2 + 1)).u(String.valueOf(eo4Var.b)).n(eo4Var.g);
        ez0.c(clogBuilder);
        eo4Var.h = true;
        i.add(eo4Var.g);
    }

    public static void f(zj8 zj8Var) {
        eo4 eo4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, zj8Var) == null) || zj8Var == null || zj8Var.getAdvertAppInfo() == null || (eo4Var = zj8Var.getAdvertAppInfo().i) == null || eo4Var.h || a(eo4Var.g)) {
            return;
        }
        zj8Var.I0 = eo4Var.d;
        zj8Var.J0 = eo4Var.e;
        zj8Var.H0 = eo4Var.c;
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.w(ClogBuilder.LogType.SHOW).o(String.valueOf(zj8Var.N0 + 1)).u(String.valueOf(zj8Var.L0)).t(eo4Var.a).p(eo4Var.d).q(eo4Var.e).r(eo4Var.c).n(eo4Var.g);
        ez0.c(clogBuilder);
        eo4Var.h = true;
        i.add(eo4Var.g);
    }

    public static void g(eo4 eo4Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{eo4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eo4Var == null || eo4Var.h || a(eo4Var.g)) {
            return;
        }
        boolean equals = "PB_BANNER".equals(eo4Var.a);
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.w(z ? ClogBuilder.LogType.STOCK : ClogBuilder.LogType.SHOW).o(String.valueOf(equals ? -1 : i2 + 1)).u(String.valueOf(equals ? -1 : eo4Var.b)).t(eo4Var.a).p(eo4Var.d).q(eo4Var.e).r(eo4Var.c).n(eo4Var.g);
        ez0.c(clogBuilder);
        eo4Var.h = true;
        i.add(eo4Var.g);
    }
}
