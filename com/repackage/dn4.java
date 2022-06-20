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
/* loaded from: classes5.dex */
public class dn4 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755761657, "Lcom/repackage/dn4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755761657, "Lcom/repackage/dn4;");
                return;
            }
        }
        i = new HashSet();
    }

    public dn4() {
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
        dn4 dn4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) || advertAppInfo == null || (dn4Var = advertAppInfo.i) == null || dn4Var.h || a(dn4Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.w(ClogBuilder.LogType.SHOW).t(advertAppInfo.j).o(String.valueOf(advertAppInfo.position + 1)).p(dn4Var.d).q(dn4Var.e).r(dn4Var.c).u(String.valueOf(dn4Var.b)).n(advertAppInfo.g);
        vx0.c(clogBuilder);
        jc7.b(jc7.a(advertAppInfo));
        dn4Var.h = true;
        i.add(dn4Var.g);
    }

    public static void c(dn4 dn4Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{dn4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || dn4Var == null || dn4Var.h || a(dn4Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.w(z ? ClogBuilder.LogType.STOCK : ClogBuilder.LogType.SHOW).t(dn4Var.a).o(String.valueOf(i2 + 1)).p(dn4Var.d).q(dn4Var.e).r(dn4Var.c).u(String.valueOf(dn4Var.b)).n(dn4Var.g);
        vx0.c(clogBuilder);
        dn4Var.h = true;
        i.add(dn4Var.g);
    }

    public static void d(sx5 sx5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, sx5Var) == null) || sx5Var == null || sx5Var.c() == null || sx5Var.c().i == null || sx5Var.c().i.h || a(sx5Var.c().i.g)) {
            return;
        }
        sx5Var.c().j = sx5Var.c().i.a;
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.w(ClogBuilder.LogType.SHOW).t(sx5Var.c().j).o(String.valueOf(sx5Var.c().position + 1)).u(String.valueOf(sx5Var.c().i.b)).n(sx5Var.c().i.g);
        vx0.c(clogBuilder);
        jc7.b(jc7.a(sx5Var.c()));
        sx5Var.c().i.h = true;
        i.add(sx5Var.c().i.g);
    }

    public static void e(dn4 dn4Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{dn4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || dn4Var == null || dn4Var.h || a(dn4Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.w(z ? ClogBuilder.LogType.STOCK : ClogBuilder.LogType.SHOW).t(dn4Var.a).o(String.valueOf(i2 + 1)).u(String.valueOf(dn4Var.b)).n(dn4Var.g);
        vx0.c(clogBuilder);
        dn4Var.h = true;
        i.add(dn4Var.g);
    }

    public static void f(sh8 sh8Var) {
        dn4 dn4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, sh8Var) == null) || sh8Var == null || sh8Var.getAdvertAppInfo() == null || (dn4Var = sh8Var.getAdvertAppInfo().i) == null || dn4Var.h || a(dn4Var.g)) {
            return;
        }
        sh8Var.J0 = dn4Var.d;
        sh8Var.K0 = dn4Var.e;
        sh8Var.I0 = dn4Var.c;
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.w(ClogBuilder.LogType.SHOW).o(String.valueOf(sh8Var.O0 + 1)).u(String.valueOf(sh8Var.M0)).t(dn4Var.a).p(dn4Var.d).q(dn4Var.e).r(dn4Var.c).n(dn4Var.g);
        vx0.c(clogBuilder);
        dn4Var.h = true;
        i.add(dn4Var.g);
    }

    public static void g(dn4 dn4Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{dn4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || dn4Var == null || dn4Var.h || a(dn4Var.g)) {
            return;
        }
        boolean equals = "PB_BANNER".equals(dn4Var.a);
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.w(z ? ClogBuilder.LogType.STOCK : ClogBuilder.LogType.SHOW).o(String.valueOf(equals ? -1 : i2 + 1)).u(String.valueOf(equals ? -1 : dn4Var.b)).t(dn4Var.a).p(dn4Var.d).q(dn4Var.e).r(dn4Var.c).n(dn4Var.g);
        vx0.c(clogBuilder);
        dn4Var.h = true;
        i.add(dn4Var.g);
    }
}
