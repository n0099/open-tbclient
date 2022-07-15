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
/* loaded from: classes7.dex */
public class sn4 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755314792, "Lcom/repackage/sn4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755314792, "Lcom/repackage/sn4;");
                return;
            }
        }
        i = new HashSet();
    }

    public sn4() {
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
        sn4 sn4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) || advertAppInfo == null || (sn4Var = advertAppInfo.i) == null || sn4Var.h || a(sn4Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).r(sn4Var.d).s(sn4Var.e).t(sn4Var.c).w(String.valueOf(sn4Var.b)).p(advertAppInfo.g);
        iy0.b(clogBuilder);
        bd7.b(bd7.a(advertAppInfo));
        sn4Var.h = true;
        i.add(sn4Var.g);
    }

    public static void c(sn4 sn4Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{sn4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || sn4Var == null || sn4Var.h || a(sn4Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(z ? ClogBuilder.LogType.STOCK : ClogBuilder.LogType.SHOW).v(sn4Var.a).q(String.valueOf(i2 + 1)).r(sn4Var.d).s(sn4Var.e).t(sn4Var.c).w(String.valueOf(sn4Var.b)).p(sn4Var.g);
        iy0.b(clogBuilder);
        sn4Var.h = true;
        i.add(sn4Var.g);
    }

    public static void d(py5 py5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, py5Var) == null) || py5Var == null || py5Var.c() == null || py5Var.c().i == null || py5Var.c().i.h || a(py5Var.c().i.g)) {
            return;
        }
        py5Var.c().j = py5Var.c().i.a;
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(ClogBuilder.LogType.SHOW).v(py5Var.c().j).q(String.valueOf(py5Var.c().position + 1)).w(String.valueOf(py5Var.c().i.b)).p(py5Var.c().i.g);
        iy0.b(clogBuilder);
        bd7.b(bd7.a(py5Var.c()));
        py5Var.c().i.h = true;
        i.add(py5Var.c().i.g);
    }

    public static void e(sn4 sn4Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{sn4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || sn4Var == null || sn4Var.h || a(sn4Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(z ? ClogBuilder.LogType.STOCK : ClogBuilder.LogType.SHOW).v(sn4Var.a).q(String.valueOf(i2 + 1)).w(String.valueOf(sn4Var.b)).p(sn4Var.g);
        iy0.b(clogBuilder);
        sn4Var.h = true;
        i.add(sn4Var.g);
    }

    public static void f(ni8 ni8Var) {
        sn4 sn4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, ni8Var) == null) || ni8Var == null || ni8Var.getAdvertAppInfo() == null || (sn4Var = ni8Var.getAdvertAppInfo().i) == null || sn4Var.h || a(sn4Var.g)) {
            return;
        }
        ni8Var.L0 = sn4Var.d;
        ni8Var.M0 = sn4Var.e;
        ni8Var.K0 = sn4Var.c;
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(ClogBuilder.LogType.SHOW).q(String.valueOf(ni8Var.Q0 + 1)).w(String.valueOf(ni8Var.O0)).v(sn4Var.a).r(sn4Var.d).s(sn4Var.e).t(sn4Var.c).p(sn4Var.g);
        iy0.b(clogBuilder);
        sn4Var.h = true;
        i.add(sn4Var.g);
    }

    public static void g(sn4 sn4Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{sn4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || sn4Var == null || sn4Var.h || a(sn4Var.g)) {
            return;
        }
        boolean equals = "PB_BANNER".equals(sn4Var.a);
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(z ? ClogBuilder.LogType.STOCK : ClogBuilder.LogType.SHOW).q(String.valueOf(equals ? -1 : i2 + 1)).w(String.valueOf(equals ? -1 : sn4Var.b)).v(sn4Var.a).r(sn4Var.d).s(sn4Var.e).t(sn4Var.c).p(sn4Var.g);
        iy0.b(clogBuilder);
        sn4Var.h = true;
        i.add(sn4Var.g);
    }
}
