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
public class ko4 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755552159, "Lcom/repackage/ko4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755552159, "Lcom/repackage/ko4;");
                return;
            }
        }
        i = new HashSet();
    }

    public ko4() {
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
        ko4 ko4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) || advertAppInfo == null || (ko4Var = advertAppInfo.i) == null || ko4Var.h || a(ko4Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).r(ko4Var.d).s(ko4Var.e).t(ko4Var.c).w(String.valueOf(ko4Var.b)).p(advertAppInfo.g);
        hy0.b(clogBuilder);
        we7.b(we7.a(advertAppInfo));
        ko4Var.h = true;
        i.add(ko4Var.g);
    }

    public static void c(ko4 ko4Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{ko4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || ko4Var == null || ko4Var.h || a(ko4Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(z ? ClogBuilder.LogType.STOCK : ClogBuilder.LogType.SHOW).v(ko4Var.a).q(String.valueOf(i2 + 1)).r(ko4Var.d).s(ko4Var.e).t(ko4Var.c).w(String.valueOf(ko4Var.b)).p(ko4Var.g);
        hy0.b(clogBuilder);
        ko4Var.h = true;
        i.add(ko4Var.g);
    }

    public static void d(h06 h06Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, h06Var) == null) || h06Var == null || h06Var.c() == null || h06Var.c().i == null || h06Var.c().i.h || a(h06Var.c().i.g)) {
            return;
        }
        h06Var.c().j = h06Var.c().i.a;
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(ClogBuilder.LogType.SHOW).v(h06Var.c().j).q(String.valueOf(h06Var.c().position + 1)).w(String.valueOf(h06Var.c().i.b)).p(h06Var.c().i.g);
        hy0.b(clogBuilder);
        we7.b(we7.a(h06Var.c()));
        h06Var.c().i.h = true;
        i.add(h06Var.c().i.g);
    }

    public static void e(ko4 ko4Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{ko4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || ko4Var == null || ko4Var.h || a(ko4Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(z ? ClogBuilder.LogType.STOCK : ClogBuilder.LogType.SHOW).v(ko4Var.a).q(String.valueOf(i2 + 1)).w(String.valueOf(ko4Var.b)).p(ko4Var.g);
        hy0.b(clogBuilder);
        ko4Var.h = true;
        i.add(ko4Var.g);
    }

    public static void f(bl8 bl8Var) {
        ko4 ko4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, bl8Var) == null) || bl8Var == null || bl8Var.getAdvertAppInfo() == null || (ko4Var = bl8Var.getAdvertAppInfo().i) == null || ko4Var.h || a(ko4Var.g)) {
            return;
        }
        bl8Var.W0 = ko4Var.d;
        bl8Var.X0 = ko4Var.e;
        bl8Var.V0 = ko4Var.c;
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(ClogBuilder.LogType.SHOW).q(String.valueOf(bl8Var.b1 + 1)).w(String.valueOf(bl8Var.Z0)).v(ko4Var.a).r(ko4Var.d).s(ko4Var.e).t(ko4Var.c).p(ko4Var.g);
        hy0.b(clogBuilder);
        ko4Var.h = true;
        i.add(ko4Var.g);
    }

    public static void g(ko4 ko4Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{ko4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || ko4Var == null || ko4Var.h || a(ko4Var.g)) {
            return;
        }
        boolean equals = "PB_BANNER".equals(ko4Var.a);
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(z ? ClogBuilder.LogType.STOCK : ClogBuilder.LogType.SHOW).q(String.valueOf(equals ? -1 : i2 + 1)).w(String.valueOf(equals ? -1 : ko4Var.b)).v(ko4Var.a).r(ko4Var.d).s(ko4Var.e).t(ko4Var.c).p(ko4Var.g);
        hy0.b(clogBuilder);
        ko4Var.h = true;
        i.add(ko4Var.g);
    }
}
