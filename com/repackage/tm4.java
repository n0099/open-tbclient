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
public class tm4 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755285962, "Lcom/repackage/tm4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755285962, "Lcom/repackage/tm4;");
                return;
            }
        }
        i = new HashSet();
    }

    public tm4() {
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
        tm4 tm4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) || advertAppInfo == null || (tm4Var = advertAppInfo.i) == null || tm4Var.h || a(tm4Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.w(ClogBuilder.LogType.SHOW).t(advertAppInfo.j).o(String.valueOf(advertAppInfo.position + 1)).p(tm4Var.d).q(tm4Var.e).r(tm4Var.c).u(String.valueOf(tm4Var.b)).n(advertAppInfo.g);
        rx0.c(clogBuilder);
        ya7.b(ya7.a(advertAppInfo));
        tm4Var.h = true;
        i.add(tm4Var.g);
    }

    public static void c(tm4 tm4Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{tm4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || tm4Var == null || tm4Var.h || a(tm4Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.w(z ? ClogBuilder.LogType.STOCK : ClogBuilder.LogType.SHOW).t(tm4Var.a).o(String.valueOf(i2 + 1)).p(tm4Var.d).q(tm4Var.e).r(tm4Var.c).u(String.valueOf(tm4Var.b)).n(tm4Var.g);
        rx0.c(clogBuilder);
        tm4Var.h = true;
        i.add(tm4Var.g);
    }

    public static void d(tw5 tw5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, tw5Var) == null) || tw5Var == null || tw5Var.e() == null || tw5Var.e().i == null || tw5Var.e().i.h || a(tw5Var.e().i.g)) {
            return;
        }
        tw5Var.e().j = tw5Var.e().i.a;
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.w(ClogBuilder.LogType.SHOW).t(tw5Var.e().j).o(String.valueOf(tw5Var.e().position + 1)).u(String.valueOf(tw5Var.e().i.b)).n(tw5Var.e().i.g);
        rx0.c(clogBuilder);
        ya7.b(ya7.a(tw5Var.e()));
        tw5Var.e().i.h = true;
        i.add(tw5Var.e().i.g);
    }

    public static void e(tm4 tm4Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{tm4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || tm4Var == null || tm4Var.h || a(tm4Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.w(z ? ClogBuilder.LogType.STOCK : ClogBuilder.LogType.SHOW).t(tm4Var.a).o(String.valueOf(i2 + 1)).u(String.valueOf(tm4Var.b)).n(tm4Var.g);
        rx0.c(clogBuilder);
        tm4Var.h = true;
        i.add(tm4Var.g);
    }

    public static void f(ah8 ah8Var) {
        tm4 tm4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, ah8Var) == null) || ah8Var == null || ah8Var.getAdvertAppInfo() == null || (tm4Var = ah8Var.getAdvertAppInfo().i) == null || tm4Var.h || a(tm4Var.g)) {
            return;
        }
        ah8Var.I0 = tm4Var.d;
        ah8Var.J0 = tm4Var.e;
        ah8Var.H0 = tm4Var.c;
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.w(ClogBuilder.LogType.SHOW).o(String.valueOf(ah8Var.N0 + 1)).u(String.valueOf(ah8Var.L0)).t(tm4Var.a).p(tm4Var.d).q(tm4Var.e).r(tm4Var.c).n(tm4Var.g);
        rx0.c(clogBuilder);
        tm4Var.h = true;
        i.add(tm4Var.g);
    }

    public static void g(tm4 tm4Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{tm4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || tm4Var == null || tm4Var.h || a(tm4Var.g)) {
            return;
        }
        boolean equals = "PB_BANNER".equals(tm4Var.a);
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.w(z ? ClogBuilder.LogType.STOCK : ClogBuilder.LogType.SHOW).o(String.valueOf(equals ? -1 : i2 + 1)).u(String.valueOf(equals ? -1 : tm4Var.b)).t(tm4Var.a).p(tm4Var.d).q(tm4Var.e).r(tm4Var.c).n(tm4Var.g);
        rx0.c(clogBuilder);
        tm4Var.h = true;
        i.add(tm4Var.g);
    }
}
