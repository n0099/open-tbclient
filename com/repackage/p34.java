package com.repackage;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class p34 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final String c;
    public static volatile p34 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<nl1, o34> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755460864, "Lcom/repackage/p34;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755460864, "Lcom/repackage/p34;");
                return;
            }
        }
        b = rf1.a;
        c = p34.class.getSimpleName();
    }

    public p34() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        n34.a();
        this.a = new HashMap();
    }

    public static p34 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (p34.class) {
                    if (d == null) {
                        d = new p34();
                    }
                }
            }
            return d;
        }
        return (p34) invokeV.objValue;
    }

    public static void d(nl1 nl1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, nl1Var) == null) {
            synchronized (p34.class) {
                if (d != null) {
                    d.c(nl1Var).h();
                }
            }
        }
    }

    public static void e(nl1 nl1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, nl1Var) == null) {
            synchronized (p34.class) {
                if (d != null) {
                    d.f(nl1Var);
                } else if (b) {
                    Log.v(c, "未初始化，无需执行release");
                }
            }
        }
    }

    public static void h(nl1 nl1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, nl1Var) == null) {
            synchronized (p34.class) {
                if (d != null) {
                    d.c(nl1Var).k();
                }
            }
        }
    }

    public boolean a(Context context, tl2 tl2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, tl2Var)) == null) {
            hw1.i("map", "map create start");
            if (bd3.m(tl2Var.c) != null && tl2Var.isValid()) {
                pl1 A = uk2.U().A(tl2Var.c);
                if (!(A instanceof nl1)) {
                    hw1.c("map", "WebViewManager is null");
                    return false;
                }
                o34 c2 = c((nl1) A);
                if (c2.d(tl2Var.b) != null) {
                    hw1.c("map", "map with id " + tl2Var.b + " exist");
                    return false;
                }
                q44 K = q44.K(context, tl2Var);
                if (K == null) {
                    hw1.c("map", "map with id " + tl2Var.b + " model is invalid");
                    return false;
                }
                yu1 insert = K.insert();
                if (!insert.a()) {
                    hw1.c("map", "map with id " + tl2Var.b + " create fail: " + insert.b);
                    return false;
                } else if (c2.insert(K)) {
                    hw1.i("map", "map with id " + tl2Var.b + " init start");
                    j44.a(context, K, tl2Var, c2);
                    hw1.i("map", "map with id " + tl2Var.b + " init end");
                    hw1.i("map", "map create end");
                    return true;
                } else {
                    return false;
                }
            }
            hw1.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public synchronized o34 c(nl1 nl1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nl1Var)) == null) {
            synchronized (this) {
                if (nl1Var == null) {
                    return null;
                }
                o34 o34Var = this.a.get(nl1Var);
                if (o34Var == null) {
                    o34Var = new o34();
                    this.a.put(nl1Var, o34Var);
                }
                return o34Var;
            }
        }
        return (o34) invokeL.objValue;
    }

    public final synchronized void f(nl1 nl1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nl1Var) == null) {
            synchronized (this) {
                if (nl1Var == null) {
                    return;
                }
                o34 remove = this.a.remove(nl1Var);
                if (remove != null) {
                    remove.i();
                }
            }
        }
    }

    public boolean g(tl2 tl2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, tl2Var)) == null) {
            hw1.i("map", "map remove start");
            if (bd3.m(tl2Var.c) == null) {
                hw1.c("map", "webView is null or mapModel is null");
                return false;
            }
            pl1 A = uk2.U().A(tl2Var.c);
            if (!(A instanceof nl1)) {
                hw1.c("map", "WebViewManager is null");
                return false;
            }
            o34 c2 = c((nl1) A);
            q44 d2 = c2.d(tl2Var.b);
            if (d2 == null) {
                hw1.c("map", "remove map with id " + tl2Var.b + " not exist");
                return false;
            } else if (c2.j(tl2Var.b)) {
                hw1.i("map", "map remove end");
                if (uv1.a(tl2Var) == null) {
                    aw1.a("map", "remove with a null map component");
                }
                yu1 B = d2.B();
                boolean a = B.a();
                if (!a) {
                    String str = c;
                    hw1.c(str, "map remove fail: " + B.b);
                }
                return a;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean update(Context context, tl2 tl2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, tl2Var)) == null) {
            hw1.i("map", "map update start");
            if (bd3.m(tl2Var.c) == null) {
                hw1.c("map", "webView is null or mapModel is null");
                return false;
            }
            pl1 A = uk2.U().A(tl2Var.c);
            if (A != null && (A instanceof nl1)) {
                o34 c2 = c((nl1) A);
                q44 d2 = c2.d(tl2Var.b);
                if (d2 == null) {
                    hw1.c("map", "remove map with id " + tl2Var.b + " not exist");
                    return false;
                }
                d2.F();
                j44.b(context, d2, tl2Var, c2, true);
                hw1.i("map", "map update end");
                if (uv1.a(tl2Var) == null) {
                    aw1.a("map", "update with a null map component");
                }
                yu1 update = d2.update((q44) tl2Var);
                boolean a = update.a();
                if (!a) {
                    String str = c;
                    hw1.c(str, "map update fail: " + update.b);
                }
                return a;
            }
            hw1.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
