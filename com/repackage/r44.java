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
/* loaded from: classes7.dex */
public class r44 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final String c;
    public static volatile r44 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<pm1, q44> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755400321, "Lcom/repackage/r44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755400321, "Lcom/repackage/r44;");
                return;
            }
        }
        b = tg1.a;
        c = r44.class.getSimpleName();
    }

    public r44() {
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
        p44.a();
        this.a = new HashMap();
    }

    public static r44 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (r44.class) {
                    if (d == null) {
                        d = new r44();
                    }
                }
            }
            return d;
        }
        return (r44) invokeV.objValue;
    }

    public static void d(pm1 pm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, pm1Var) == null) {
            synchronized (r44.class) {
                if (d != null) {
                    d.c(pm1Var).h();
                }
            }
        }
    }

    public static void e(pm1 pm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, pm1Var) == null) {
            synchronized (r44.class) {
                if (d != null) {
                    d.f(pm1Var);
                } else if (b) {
                    Log.v(c, "未初始化，无需执行release");
                }
            }
        }
    }

    public static void h(pm1 pm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, pm1Var) == null) {
            synchronized (r44.class) {
                if (d != null) {
                    d.c(pm1Var).k();
                }
            }
        }
    }

    public boolean a(Context context, vm2 vm2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, vm2Var)) == null) {
            jx1.i("map", "map create start");
            if (de3.m(vm2Var.c) != null && vm2Var.isValid()) {
                rm1 A = wl2.U().A(vm2Var.c);
                if (!(A instanceof pm1)) {
                    jx1.c("map", "WebViewManager is null");
                    return false;
                }
                q44 c2 = c((pm1) A);
                if (c2.d(vm2Var.b) != null) {
                    jx1.c("map", "map with id " + vm2Var.b + " exist");
                    return false;
                }
                s54 K = s54.K(context, vm2Var);
                if (K == null) {
                    jx1.c("map", "map with id " + vm2Var.b + " model is invalid");
                    return false;
                }
                aw1 insert = K.insert();
                if (!insert.a()) {
                    jx1.c("map", "map with id " + vm2Var.b + " create fail: " + insert.b);
                    return false;
                } else if (c2.insert(K)) {
                    jx1.i("map", "map with id " + vm2Var.b + " init start");
                    l54.a(context, K, vm2Var, c2);
                    jx1.i("map", "map with id " + vm2Var.b + " init end");
                    jx1.i("map", "map create end");
                    return true;
                } else {
                    return false;
                }
            }
            jx1.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public synchronized q44 c(pm1 pm1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pm1Var)) == null) {
            synchronized (this) {
                if (pm1Var == null) {
                    return null;
                }
                q44 q44Var = this.a.get(pm1Var);
                if (q44Var == null) {
                    q44Var = new q44();
                    this.a.put(pm1Var, q44Var);
                }
                return q44Var;
            }
        }
        return (q44) invokeL.objValue;
    }

    public final synchronized void f(pm1 pm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pm1Var) == null) {
            synchronized (this) {
                if (pm1Var == null) {
                    return;
                }
                q44 remove = this.a.remove(pm1Var);
                if (remove != null) {
                    remove.i();
                }
            }
        }
    }

    public boolean g(vm2 vm2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, vm2Var)) == null) {
            jx1.i("map", "map remove start");
            if (de3.m(vm2Var.c) == null) {
                jx1.c("map", "webView is null or mapModel is null");
                return false;
            }
            rm1 A = wl2.U().A(vm2Var.c);
            if (!(A instanceof pm1)) {
                jx1.c("map", "WebViewManager is null");
                return false;
            }
            q44 c2 = c((pm1) A);
            s54 d2 = c2.d(vm2Var.b);
            if (d2 == null) {
                jx1.c("map", "remove map with id " + vm2Var.b + " not exist");
                return false;
            } else if (c2.j(vm2Var.b)) {
                jx1.i("map", "map remove end");
                if (ww1.a(vm2Var) == null) {
                    cx1.a("map", "remove with a null map component");
                }
                aw1 B = d2.B();
                boolean a = B.a();
                if (!a) {
                    String str = c;
                    jx1.c(str, "map remove fail: " + B.b);
                }
                return a;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean update(Context context, vm2 vm2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, vm2Var)) == null) {
            jx1.i("map", "map update start");
            if (de3.m(vm2Var.c) == null) {
                jx1.c("map", "webView is null or mapModel is null");
                return false;
            }
            rm1 A = wl2.U().A(vm2Var.c);
            if (A != null && (A instanceof pm1)) {
                q44 c2 = c((pm1) A);
                s54 d2 = c2.d(vm2Var.b);
                if (d2 == null) {
                    jx1.c("map", "remove map with id " + vm2Var.b + " not exist");
                    return false;
                }
                d2.F();
                l54.b(context, d2, vm2Var, c2, true);
                jx1.i("map", "map update end");
                if (ww1.a(vm2Var) == null) {
                    cx1.a("map", "update with a null map component");
                }
                aw1 update = d2.update((s54) vm2Var);
                boolean a = update.a();
                if (!a) {
                    String str = c;
                    jx1.c(str, "map update fail: " + update.b);
                }
                return a;
            }
            jx1.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
