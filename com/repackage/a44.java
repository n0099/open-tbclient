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
public class a44 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final String c;
    public static volatile a44 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<yl1, z34> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755906768, "Lcom/repackage/a44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755906768, "Lcom/repackage/a44;");
                return;
            }
        }
        b = cg1.a;
        c = a44.class.getSimpleName();
    }

    public a44() {
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
        y34.a();
        this.a = new HashMap();
    }

    public static a44 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (a44.class) {
                    if (d == null) {
                        d = new a44();
                    }
                }
            }
            return d;
        }
        return (a44) invokeV.objValue;
    }

    public static void d(yl1 yl1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, yl1Var) == null) {
            synchronized (a44.class) {
                if (d != null) {
                    d.c(yl1Var).h();
                }
            }
        }
    }

    public static void e(yl1 yl1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, yl1Var) == null) {
            synchronized (a44.class) {
                if (d != null) {
                    d.f(yl1Var);
                } else if (b) {
                    Log.v(c, "未初始化，无需执行release");
                }
            }
        }
    }

    public static void h(yl1 yl1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, yl1Var) == null) {
            synchronized (a44.class) {
                if (d != null) {
                    d.c(yl1Var).k();
                }
            }
        }
    }

    public boolean a(Context context, em2 em2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, em2Var)) == null) {
            sw1.i("map", "map create start");
            if (md3.m(em2Var.c) != null && em2Var.isValid()) {
                am1 A = fl2.U().A(em2Var.c);
                if (!(A instanceof yl1)) {
                    sw1.c("map", "WebViewManager is null");
                    return false;
                }
                z34 c2 = c((yl1) A);
                if (c2.d(em2Var.b) != null) {
                    sw1.c("map", "map with id " + em2Var.b + " exist");
                    return false;
                }
                b54 K = b54.K(context, em2Var);
                if (K == null) {
                    sw1.c("map", "map with id " + em2Var.b + " model is invalid");
                    return false;
                }
                jv1 insert = K.insert();
                if (!insert.a()) {
                    sw1.c("map", "map with id " + em2Var.b + " create fail: " + insert.b);
                    return false;
                } else if (c2.insert(K)) {
                    sw1.i("map", "map with id " + em2Var.b + " init start");
                    u44.a(context, K, em2Var, c2);
                    sw1.i("map", "map with id " + em2Var.b + " init end");
                    sw1.i("map", "map create end");
                    return true;
                } else {
                    return false;
                }
            }
            sw1.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public synchronized z34 c(yl1 yl1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yl1Var)) == null) {
            synchronized (this) {
                if (yl1Var == null) {
                    return null;
                }
                z34 z34Var = this.a.get(yl1Var);
                if (z34Var == null) {
                    z34Var = new z34();
                    this.a.put(yl1Var, z34Var);
                }
                return z34Var;
            }
        }
        return (z34) invokeL.objValue;
    }

    public final synchronized void f(yl1 yl1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yl1Var) == null) {
            synchronized (this) {
                if (yl1Var == null) {
                    return;
                }
                z34 remove = this.a.remove(yl1Var);
                if (remove != null) {
                    remove.i();
                }
            }
        }
    }

    public boolean g(em2 em2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, em2Var)) == null) {
            sw1.i("map", "map remove start");
            if (md3.m(em2Var.c) == null) {
                sw1.c("map", "webView is null or mapModel is null");
                return false;
            }
            am1 A = fl2.U().A(em2Var.c);
            if (!(A instanceof yl1)) {
                sw1.c("map", "WebViewManager is null");
                return false;
            }
            z34 c2 = c((yl1) A);
            b54 d2 = c2.d(em2Var.b);
            if (d2 == null) {
                sw1.c("map", "remove map with id " + em2Var.b + " not exist");
                return false;
            } else if (c2.j(em2Var.b)) {
                sw1.i("map", "map remove end");
                if (fw1.a(em2Var) == null) {
                    lw1.a("map", "remove with a null map component");
                }
                jv1 B = d2.B();
                boolean a = B.a();
                if (!a) {
                    String str = c;
                    sw1.c(str, "map remove fail: " + B.b);
                }
                return a;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean update(Context context, em2 em2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, em2Var)) == null) {
            sw1.i("map", "map update start");
            if (md3.m(em2Var.c) == null) {
                sw1.c("map", "webView is null or mapModel is null");
                return false;
            }
            am1 A = fl2.U().A(em2Var.c);
            if (A != null && (A instanceof yl1)) {
                z34 c2 = c((yl1) A);
                b54 d2 = c2.d(em2Var.b);
                if (d2 == null) {
                    sw1.c("map", "remove map with id " + em2Var.b + " not exist");
                    return false;
                }
                d2.F();
                u44.b(context, d2, em2Var, c2, true);
                sw1.i("map", "map update end");
                if (fw1.a(em2Var) == null) {
                    lw1.a("map", "update with a null map component");
                }
                jv1 update = d2.update((b54) em2Var);
                boolean a = update.a();
                if (!a) {
                    String str = c;
                    sw1.c(str, "map update fail: " + update.b);
                }
                return a;
            }
            sw1.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
