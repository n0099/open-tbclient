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
public class un4 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755255210, "Lcom/repackage/un4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755255210, "Lcom/repackage/un4;");
                return;
            }
        }
        j = new HashSet();
    }

    public un4() {
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
        un4 un4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) || advertAppInfo == null || (un4Var = advertAppInfo.j) == null || un4Var.i || a(un4Var.h)) {
            return;
        }
        zc8 b = dd8.b(advertAppInfo, 3, un4Var.b);
        b.h(un4Var.a);
        b.a("isCache", un4Var.c);
        b.e(un4Var.e);
        b.f(un4Var.f);
        b.g(un4Var.d);
        b.a("vc", un4Var.g);
        b.v(un4Var.h);
        bd8.b().d(b);
        ed7.g(ed7.e(advertAppInfo));
        un4Var.i = true;
        j.add(un4Var.h);
    }

    public static void c(un4 un4Var, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{un4Var, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || un4Var == null || un4Var.i || a(un4Var.h)) {
            return;
        }
        zc8 g = dd8.g(z ? 13 : 3, i, un4Var.b);
        g.h(un4Var.a);
        g.a("isCache", String.valueOf(un4Var.c));
        g.e(un4Var.e);
        g.f(un4Var.f);
        g.g(un4Var.d);
        g.a("vc", un4Var.g);
        g.v(un4Var.h);
        bd8.b().d(g);
        un4Var.i = true;
        j.add(un4Var.h);
    }

    public static void d(zx5 zx5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, zx5Var) == null) || zx5Var == null || zx5Var.e() == null || zx5Var.e().j == null || zx5Var.e().j.i || a(zx5Var.e().j.h)) {
            return;
        }
        zx5Var.e().k = zx5Var.e().j.a;
        zc8 c = dd8.c(zx5Var.e(), 3, zx5Var.e().j.b);
        c.v(zx5Var.e().j.h);
        bd8.b().d(c);
        ed7.g(ed7.e(zx5Var.e()));
        zx5Var.e().j.i = true;
        j.add(zx5Var.e().j.h);
    }

    public static void e(un4 un4Var, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{un4Var, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || un4Var == null || un4Var.i || a(un4Var.h)) {
            return;
        }
        zc8 g = dd8.g(z ? 13 : 3, i, un4Var.b);
        g.h(un4Var.a);
        g.v(un4Var.h);
        bd8.b().d(g);
        un4Var.i = true;
        j.add(un4Var.h);
    }

    public static void f(cl8 cl8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, cl8Var) == null) || cl8Var == null || cl8Var.getAdvertAppInfo() == null) {
            return;
        }
        un4 un4Var = cl8Var.getAdvertAppInfo().j;
        if (cl8Var.O0 || !(un4Var == null || un4Var.i || a(un4Var.h))) {
            cl8Var.I0 = un4Var.e;
            cl8Var.J0 = un4Var.f;
            cl8Var.H0 = un4Var.d;
            int i = 3;
            if (cl8Var != null && cl8Var.P0() != null && cl8Var.P0().forFree()) {
                i = 103;
            }
            zc8 e = dd8.e(cl8Var, i);
            e.v(un4Var.h);
            bd8.b().d(e);
            if (!cl8Var.O0) {
                ed7.g(ed7.e(cl8Var.getAdvertAppInfo()));
            }
            un4Var.i = true;
            j.add(un4Var.h);
        }
    }

    public static void g(un4 un4Var, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{un4Var, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || un4Var == null || un4Var.i || a(un4Var.h)) {
            return;
        }
        int i2 = z ? 13 : 3;
        zc8 zc8Var = new zc8();
        zc8Var.i(i2);
        if ("PB_BANNER".equals(un4Var.a)) {
            zc8Var.d(-1);
            zc8Var.x(-1);
        } else {
            zc8Var.d(i);
            zc8Var.x(un4Var.b);
        }
        zc8Var.h(un4Var.a);
        zc8Var.e(un4Var.e);
        zc8Var.f(un4Var.f);
        zc8Var.g(un4Var.d);
        zc8Var.a("vc", un4Var.g);
        zc8Var.v(un4Var.h);
        bd8.b().d(zc8Var);
        un4Var.i = true;
        j.add(un4Var.h);
    }
}
