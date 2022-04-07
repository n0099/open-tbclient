package com.repackage;

import androidx.core.view.InputDeviceCompat;
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
public class vn4 {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> j;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public boolean i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755225419, "Lcom/repackage/vn4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755225419, "Lcom/repackage/vn4;");
                return;
            }
        }
        j = new HashSet();
    }

    public vn4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? j.contains(str) : invokeL.booleanValue;
    }

    public static void b(AdvertAppInfo advertAppInfo) {
        vn4 vn4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) || advertAppInfo == null || (vn4Var = advertAppInfo.j) == null || vn4Var.i || a(vn4Var.h)) {
            return;
        }
        sc8 b = wc8.b(advertAppInfo, 3, vn4Var.b);
        b.h(vn4Var.a);
        b.a("isCache", vn4Var.c);
        b.e(vn4Var.e);
        b.f(vn4Var.f);
        b.g(vn4Var.d);
        b.a("vc", vn4Var.g);
        b.v(vn4Var.h);
        uc8.b().d(b);
        bd7.g(bd7.e(advertAppInfo));
        vn4Var.i = true;
        j.add(vn4Var.h);
    }

    public static void c(vn4 vn4Var, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{vn4Var, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || vn4Var == null || vn4Var.i || a(vn4Var.h)) {
            return;
        }
        sc8 g = wc8.g(z ? 13 : 3, i, vn4Var.b);
        g.h(vn4Var.a);
        g.a("isCache", String.valueOf(vn4Var.c));
        g.e(vn4Var.e);
        g.f(vn4Var.f);
        g.g(vn4Var.d);
        g.a("vc", vn4Var.g);
        g.v(vn4Var.h);
        uc8.b().d(g);
        vn4Var.i = true;
        j.add(vn4Var.h);
    }

    public static void d(xx5 xx5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, xx5Var) == null) || xx5Var == null || xx5Var.e() == null || xx5Var.e().j == null || xx5Var.e().j.i || a(xx5Var.e().j.h)) {
            return;
        }
        xx5Var.e().k = xx5Var.e().j.a;
        sc8 c = wc8.c(xx5Var.e(), 3, xx5Var.e().j.b);
        c.v(xx5Var.e().j.h);
        uc8.b().d(c);
        bd7.g(bd7.e(xx5Var.e()));
        xx5Var.e().j.i = true;
        j.add(xx5Var.e().j.h);
    }

    public static void e(vn4 vn4Var, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{vn4Var, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || vn4Var == null || vn4Var.i || a(vn4Var.h)) {
            return;
        }
        sc8 g = wc8.g(z ? 13 : 3, i, vn4Var.b);
        g.h(vn4Var.a);
        g.v(vn4Var.h);
        uc8.b().d(g);
        vn4Var.i = true;
        j.add(vn4Var.h);
    }

    public static void f(vk8 vk8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, vk8Var) == null) || vk8Var == null || vk8Var.getAdvertAppInfo() == null) {
            return;
        }
        vn4 vn4Var = vk8Var.getAdvertAppInfo().j;
        if (vk8Var.O0 || !(vn4Var == null || vn4Var.i || a(vn4Var.h))) {
            vk8Var.I0 = vn4Var.e;
            vk8Var.J0 = vn4Var.f;
            vk8Var.H0 = vn4Var.d;
            int i = 3;
            if (vk8Var != null && vk8Var.P0() != null && vk8Var.P0().forFree()) {
                i = 103;
            }
            sc8 e = wc8.e(vk8Var, i);
            e.v(vn4Var.h);
            uc8.b().d(e);
            if (!vk8Var.O0) {
                bd7.g(bd7.e(vk8Var.getAdvertAppInfo()));
            }
            vn4Var.i = true;
            j.add(vn4Var.h);
        }
    }

    public static void g(vn4 vn4Var, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{vn4Var, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || vn4Var == null || vn4Var.i || a(vn4Var.h)) {
            return;
        }
        int i2 = z ? 13 : 3;
        sc8 sc8Var = new sc8();
        sc8Var.i(i2);
        if ("PB_BANNER".equals(vn4Var.a)) {
            sc8Var.d(-1);
            sc8Var.x(-1);
        } else {
            sc8Var.d(i);
            sc8Var.x(vn4Var.b);
        }
        sc8Var.h(vn4Var.a);
        sc8Var.e(vn4Var.e);
        sc8Var.f(vn4Var.f);
        sc8Var.g(vn4Var.d);
        sc8Var.a("vc", vn4Var.g);
        sc8Var.v(vn4Var.h);
        uc8.b().d(sc8Var);
        vn4Var.i = true;
        j.add(vn4Var.h);
    }
}
