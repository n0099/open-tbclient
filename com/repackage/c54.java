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
/* loaded from: classes5.dex */
public class c54 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final String c;
    public static volatile c54 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<an1, b54> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755846225, "Lcom/repackage/c54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755846225, "Lcom/repackage/c54;");
                return;
            }
        }
        b = eh1.a;
        c = c54.class.getSimpleName();
    }

    public c54() {
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
        a54.a();
        this.a = new HashMap();
    }

    public static c54 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (c54.class) {
                    if (d == null) {
                        d = new c54();
                    }
                }
            }
            return d;
        }
        return (c54) invokeV.objValue;
    }

    public static void d(an1 an1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, an1Var) == null) {
            synchronized (c54.class) {
                if (d != null) {
                    d.c(an1Var).h();
                }
            }
        }
    }

    public static void e(an1 an1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, an1Var) == null) {
            synchronized (c54.class) {
                if (d != null) {
                    d.f(an1Var);
                } else if (b) {
                    Log.v(c, "未初始化，无需执行release");
                }
            }
        }
    }

    public static void h(an1 an1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, an1Var) == null) {
            synchronized (c54.class) {
                if (d != null) {
                    d.c(an1Var).k();
                }
            }
        }
    }

    public boolean a(Context context, gn2 gn2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, gn2Var)) == null) {
            ux1.i("map", "map create start");
            if (oe3.m(gn2Var.c) != null && gn2Var.isValid()) {
                cn1 A = hm2.U().A(gn2Var.c);
                if (!(A instanceof an1)) {
                    ux1.c("map", "WebViewManager is null");
                    return false;
                }
                b54 c2 = c((an1) A);
                if (c2.d(gn2Var.b) != null) {
                    ux1.c("map", "map with id " + gn2Var.b + " exist");
                    return false;
                }
                d64 K = d64.K(context, gn2Var);
                if (K == null) {
                    ux1.c("map", "map with id " + gn2Var.b + " model is invalid");
                    return false;
                }
                lw1 insert = K.insert();
                if (!insert.a()) {
                    ux1.c("map", "map with id " + gn2Var.b + " create fail: " + insert.b);
                    return false;
                } else if (c2.insert(K)) {
                    ux1.i("map", "map with id " + gn2Var.b + " init start");
                    w54.a(context, K, gn2Var, c2);
                    ux1.i("map", "map with id " + gn2Var.b + " init end");
                    ux1.i("map", "map create end");
                    return true;
                } else {
                    return false;
                }
            }
            ux1.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public synchronized b54 c(an1 an1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, an1Var)) == null) {
            synchronized (this) {
                if (an1Var == null) {
                    return null;
                }
                b54 b54Var = this.a.get(an1Var);
                if (b54Var == null) {
                    b54Var = new b54();
                    this.a.put(an1Var, b54Var);
                }
                return b54Var;
            }
        }
        return (b54) invokeL.objValue;
    }

    public final synchronized void f(an1 an1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, an1Var) == null) {
            synchronized (this) {
                if (an1Var == null) {
                    return;
                }
                b54 remove = this.a.remove(an1Var);
                if (remove != null) {
                    remove.i();
                }
            }
        }
    }

    public boolean g(gn2 gn2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, gn2Var)) == null) {
            ux1.i("map", "map remove start");
            if (oe3.m(gn2Var.c) == null) {
                ux1.c("map", "webView is null or mapModel is null");
                return false;
            }
            cn1 A = hm2.U().A(gn2Var.c);
            if (!(A instanceof an1)) {
                ux1.c("map", "WebViewManager is null");
                return false;
            }
            b54 c2 = c((an1) A);
            d64 d2 = c2.d(gn2Var.b);
            if (d2 == null) {
                ux1.c("map", "remove map with id " + gn2Var.b + " not exist");
                return false;
            } else if (c2.j(gn2Var.b)) {
                ux1.i("map", "map remove end");
                if (hx1.a(gn2Var) == null) {
                    nx1.a("map", "remove with a null map component");
                }
                lw1 B = d2.B();
                boolean a = B.a();
                if (!a) {
                    String str = c;
                    ux1.c(str, "map remove fail: " + B.b);
                }
                return a;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean update(Context context, gn2 gn2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, gn2Var)) == null) {
            ux1.i("map", "map update start");
            if (oe3.m(gn2Var.c) == null) {
                ux1.c("map", "webView is null or mapModel is null");
                return false;
            }
            cn1 A = hm2.U().A(gn2Var.c);
            if (A != null && (A instanceof an1)) {
                b54 c2 = c((an1) A);
                d64 d2 = c2.d(gn2Var.b);
                if (d2 == null) {
                    ux1.c("map", "remove map with id " + gn2Var.b + " not exist");
                    return false;
                }
                d2.F();
                w54.b(context, d2, gn2Var, c2, true);
                ux1.i("map", "map update end");
                if (hx1.a(gn2Var) == null) {
                    nx1.a("map", "update with a null map component");
                }
                lw1 update = d2.update((d64) gn2Var);
                boolean a = update.a();
                if (!a) {
                    String str = c;
                    ux1.c(str, "map update fail: " + update.b);
                }
                return a;
            }
            ux1.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
