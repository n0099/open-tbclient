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
public class tn4 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755285001, "Lcom/repackage/tn4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755285001, "Lcom/repackage/tn4;");
                return;
            }
        }
        i = new HashSet();
    }

    public tn4() {
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
        tn4 tn4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) || advertAppInfo == null || (tn4Var = advertAppInfo.i) == null || tn4Var.h || a(tn4Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).r(tn4Var.d).s(tn4Var.e).t(tn4Var.c).w(String.valueOf(tn4Var.b)).p(advertAppInfo.g);
        iy0.b(clogBuilder);
        bd7.b(bd7.a(advertAppInfo));
        tn4Var.h = true;
        i.add(tn4Var.g);
    }

    public static void c(tn4 tn4Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{tn4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || tn4Var == null || tn4Var.h || a(tn4Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(z ? ClogBuilder.LogType.STOCK : ClogBuilder.LogType.SHOW).v(tn4Var.a).q(String.valueOf(i2 + 1)).r(tn4Var.d).s(tn4Var.e).t(tn4Var.c).w(String.valueOf(tn4Var.b)).p(tn4Var.g);
        iy0.b(clogBuilder);
        tn4Var.h = true;
        i.add(tn4Var.g);
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

    public static void e(tn4 tn4Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{tn4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || tn4Var == null || tn4Var.h || a(tn4Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(z ? ClogBuilder.LogType.STOCK : ClogBuilder.LogType.SHOW).v(tn4Var.a).q(String.valueOf(i2 + 1)).w(String.valueOf(tn4Var.b)).p(tn4Var.g);
        iy0.b(clogBuilder);
        tn4Var.h = true;
        i.add(tn4Var.g);
    }

    public static void f(ni8 ni8Var) {
        tn4 tn4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, ni8Var) == null) || ni8Var == null || ni8Var.getAdvertAppInfo() == null || (tn4Var = ni8Var.getAdvertAppInfo().i) == null || tn4Var.h || a(tn4Var.g)) {
            return;
        }
        ni8Var.L0 = tn4Var.d;
        ni8Var.M0 = tn4Var.e;
        ni8Var.K0 = tn4Var.c;
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(ClogBuilder.LogType.SHOW).q(String.valueOf(ni8Var.Q0 + 1)).w(String.valueOf(ni8Var.O0)).v(tn4Var.a).r(tn4Var.d).s(tn4Var.e).t(tn4Var.c).p(tn4Var.g);
        iy0.b(clogBuilder);
        tn4Var.h = true;
        i.add(tn4Var.g);
    }

    public static void g(tn4 tn4Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{tn4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || tn4Var == null || tn4Var.h || a(tn4Var.g)) {
            return;
        }
        boolean equals = "PB_BANNER".equals(tn4Var.a);
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(z ? ClogBuilder.LogType.STOCK : ClogBuilder.LogType.SHOW).q(String.valueOf(equals ? -1 : i2 + 1)).w(String.valueOf(equals ? -1 : tn4Var.b)).v(tn4Var.a).r(tn4Var.d).s(tn4Var.e).t(tn4Var.c).p(tn4Var.g);
        iy0.b(clogBuilder);
        tn4Var.h = true;
        i.add(tn4Var.g);
    }
}
