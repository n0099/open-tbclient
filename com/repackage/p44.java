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
public class p44 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final String c;
    public static volatile p44 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<nm1, o44> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755459903, "Lcom/repackage/p44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755459903, "Lcom/repackage/p44;");
                return;
            }
        }
        b = rg1.a;
        c = p44.class.getSimpleName();
    }

    public p44() {
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
        n44.a();
        this.a = new HashMap();
    }

    public static p44 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (p44.class) {
                    if (d == null) {
                        d = new p44();
                    }
                }
            }
            return d;
        }
        return (p44) invokeV.objValue;
    }

    public static void d(nm1 nm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, nm1Var) == null) {
            synchronized (p44.class) {
                if (d != null) {
                    d.c(nm1Var).h();
                }
            }
        }
    }

    public static void e(nm1 nm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, nm1Var) == null) {
            synchronized (p44.class) {
                if (d != null) {
                    d.f(nm1Var);
                } else if (b) {
                    Log.v(c, "未初始化，无需执行release");
                }
            }
        }
    }

    public static void h(nm1 nm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, nm1Var) == null) {
            synchronized (p44.class) {
                if (d != null) {
                    d.c(nm1Var).k();
                }
            }
        }
    }

    public boolean a(Context context, tm2 tm2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, tm2Var)) == null) {
            hx1.i("map", "map create start");
            if (be3.m(tm2Var.c) != null && tm2Var.isValid()) {
                pm1 A = ul2.U().A(tm2Var.c);
                if (!(A instanceof nm1)) {
                    hx1.c("map", "WebViewManager is null");
                    return false;
                }
                o44 c2 = c((nm1) A);
                if (c2.d(tm2Var.b) != null) {
                    hx1.c("map", "map with id " + tm2Var.b + " exist");
                    return false;
                }
                q54 K = q54.K(context, tm2Var);
                if (K == null) {
                    hx1.c("map", "map with id " + tm2Var.b + " model is invalid");
                    return false;
                }
                yv1 insert = K.insert();
                if (!insert.a()) {
                    hx1.c("map", "map with id " + tm2Var.b + " create fail: " + insert.b);
                    return false;
                } else if (c2.insert(K)) {
                    hx1.i("map", "map with id " + tm2Var.b + " init start");
                    j54.a(context, K, tm2Var, c2);
                    hx1.i("map", "map with id " + tm2Var.b + " init end");
                    hx1.i("map", "map create end");
                    return true;
                } else {
                    return false;
                }
            }
            hx1.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public synchronized o44 c(nm1 nm1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nm1Var)) == null) {
            synchronized (this) {
                if (nm1Var == null) {
                    return null;
                }
                o44 o44Var = this.a.get(nm1Var);
                if (o44Var == null) {
                    o44Var = new o44();
                    this.a.put(nm1Var, o44Var);
                }
                return o44Var;
            }
        }
        return (o44) invokeL.objValue;
    }

    public final synchronized void f(nm1 nm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nm1Var) == null) {
            synchronized (this) {
                if (nm1Var == null) {
                    return;
                }
                o44 remove = this.a.remove(nm1Var);
                if (remove != null) {
                    remove.i();
                }
            }
        }
    }

    public boolean g(tm2 tm2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, tm2Var)) == null) {
            hx1.i("map", "map remove start");
            if (be3.m(tm2Var.c) == null) {
                hx1.c("map", "webView is null or mapModel is null");
                return false;
            }
            pm1 A = ul2.U().A(tm2Var.c);
            if (!(A instanceof nm1)) {
                hx1.c("map", "WebViewManager is null");
                return false;
            }
            o44 c2 = c((nm1) A);
            q54 d2 = c2.d(tm2Var.b);
            if (d2 == null) {
                hx1.c("map", "remove map with id " + tm2Var.b + " not exist");
                return false;
            } else if (c2.j(tm2Var.b)) {
                hx1.i("map", "map remove end");
                if (uw1.a(tm2Var) == null) {
                    ax1.a("map", "remove with a null map component");
                }
                yv1 B = d2.B();
                boolean a = B.a();
                if (!a) {
                    String str = c;
                    hx1.c(str, "map remove fail: " + B.b);
                }
                return a;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean update(Context context, tm2 tm2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, tm2Var)) == null) {
            hx1.i("map", "map update start");
            if (be3.m(tm2Var.c) == null) {
                hx1.c("map", "webView is null or mapModel is null");
                return false;
            }
            pm1 A = ul2.U().A(tm2Var.c);
            if (A != null && (A instanceof nm1)) {
                o44 c2 = c((nm1) A);
                q54 d2 = c2.d(tm2Var.b);
                if (d2 == null) {
                    hx1.c("map", "remove map with id " + tm2Var.b + " not exist");
                    return false;
                }
                d2.F();
                j54.b(context, d2, tm2Var, c2, true);
                hx1.i("map", "map update end");
                if (uw1.a(tm2Var) == null) {
                    ax1.a("map", "update with a null map component");
                }
                yv1 update = d2.update((q54) tm2Var);
                boolean a = update.a();
                if (!a) {
                    String str = c;
                    hx1.c(str, "map update fail: " + update.b);
                }
                return a;
            }
            hx1.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
