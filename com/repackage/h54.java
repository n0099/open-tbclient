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
public class h54 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final String c;
    public static volatile h54 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<fn1, g54> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755697270, "Lcom/repackage/h54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755697270, "Lcom/repackage/h54;");
                return;
            }
        }
        b = jh1.a;
        c = h54.class.getSimpleName();
    }

    public h54() {
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
        f54.a();
        this.a = new HashMap();
    }

    public static h54 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (h54.class) {
                    if (d == null) {
                        d = new h54();
                    }
                }
            }
            return d;
        }
        return (h54) invokeV.objValue;
    }

    public static void d(fn1 fn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, fn1Var) == null) {
            synchronized (h54.class) {
                if (d != null) {
                    d.c(fn1Var).h();
                }
            }
        }
    }

    public static void e(fn1 fn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fn1Var) == null) {
            synchronized (h54.class) {
                if (d != null) {
                    d.f(fn1Var);
                } else if (b) {
                    Log.v(c, "未初始化，无需执行release");
                }
            }
        }
    }

    public static void h(fn1 fn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, fn1Var) == null) {
            synchronized (h54.class) {
                if (d != null) {
                    d.c(fn1Var).k();
                }
            }
        }
    }

    public boolean a(Context context, ln2 ln2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, ln2Var)) == null) {
            zx1.i("map", "map create start");
            if (te3.m(ln2Var.c) != null && ln2Var.isValid()) {
                hn1 A = mm2.U().A(ln2Var.c);
                if (!(A instanceof fn1)) {
                    zx1.c("map", "WebViewManager is null");
                    return false;
                }
                g54 c2 = c((fn1) A);
                if (c2.d(ln2Var.b) != null) {
                    zx1.c("map", "map with id " + ln2Var.b + " exist");
                    return false;
                }
                i64 K = i64.K(context, ln2Var);
                if (K == null) {
                    zx1.c("map", "map with id " + ln2Var.b + " model is invalid");
                    return false;
                }
                qw1 insert = K.insert();
                if (!insert.a()) {
                    zx1.c("map", "map with id " + ln2Var.b + " create fail: " + insert.b);
                    return false;
                } else if (c2.insert(K)) {
                    zx1.i("map", "map with id " + ln2Var.b + " init start");
                    b64.a(context, K, ln2Var, c2);
                    zx1.i("map", "map with id " + ln2Var.b + " init end");
                    zx1.i("map", "map create end");
                    return true;
                } else {
                    return false;
                }
            }
            zx1.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public synchronized g54 c(fn1 fn1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fn1Var)) == null) {
            synchronized (this) {
                if (fn1Var == null) {
                    return null;
                }
                g54 g54Var = this.a.get(fn1Var);
                if (g54Var == null) {
                    g54Var = new g54();
                    this.a.put(fn1Var, g54Var);
                }
                return g54Var;
            }
        }
        return (g54) invokeL.objValue;
    }

    public final synchronized void f(fn1 fn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fn1Var) == null) {
            synchronized (this) {
                if (fn1Var == null) {
                    return;
                }
                g54 remove = this.a.remove(fn1Var);
                if (remove != null) {
                    remove.i();
                }
            }
        }
    }

    public boolean g(ln2 ln2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ln2Var)) == null) {
            zx1.i("map", "map remove start");
            if (te3.m(ln2Var.c) == null) {
                zx1.c("map", "webView is null or mapModel is null");
                return false;
            }
            hn1 A = mm2.U().A(ln2Var.c);
            if (!(A instanceof fn1)) {
                zx1.c("map", "WebViewManager is null");
                return false;
            }
            g54 c2 = c((fn1) A);
            i64 d2 = c2.d(ln2Var.b);
            if (d2 == null) {
                zx1.c("map", "remove map with id " + ln2Var.b + " not exist");
                return false;
            } else if (c2.j(ln2Var.b)) {
                zx1.i("map", "map remove end");
                if (mx1.a(ln2Var) == null) {
                    sx1.a("map", "remove with a null map component");
                }
                qw1 B = d2.B();
                boolean a = B.a();
                if (!a) {
                    String str = c;
                    zx1.c(str, "map remove fail: " + B.b);
                }
                return a;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean update(Context context, ln2 ln2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, ln2Var)) == null) {
            zx1.i("map", "map update start");
            if (te3.m(ln2Var.c) == null) {
                zx1.c("map", "webView is null or mapModel is null");
                return false;
            }
            hn1 A = mm2.U().A(ln2Var.c);
            if (A != null && (A instanceof fn1)) {
                g54 c2 = c((fn1) A);
                i64 d2 = c2.d(ln2Var.b);
                if (d2 == null) {
                    zx1.c("map", "remove map with id " + ln2Var.b + " not exist");
                    return false;
                }
                d2.F();
                b64.b(context, d2, ln2Var, c2, true);
                zx1.i("map", "map update end");
                if (mx1.a(ln2Var) == null) {
                    sx1.a("map", "update with a null map component");
                }
                qw1 update = d2.update((i64) ln2Var);
                boolean a = update.a();
                if (!a) {
                    String str = c;
                    zx1.c(str, "map update fail: " + update.b);
                }
                return a;
            }
            zx1.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
