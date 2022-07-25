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
public class q44 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final String c;
    public static volatile q44 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<om1, p44> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755430112, "Lcom/repackage/q44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755430112, "Lcom/repackage/q44;");
                return;
            }
        }
        b = sg1.a;
        c = q44.class.getSimpleName();
    }

    public q44() {
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
        o44.a();
        this.a = new HashMap();
    }

    public static q44 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (q44.class) {
                    if (d == null) {
                        d = new q44();
                    }
                }
            }
            return d;
        }
        return (q44) invokeV.objValue;
    }

    public static void d(om1 om1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, om1Var) == null) {
            synchronized (q44.class) {
                if (d != null) {
                    d.c(om1Var).h();
                }
            }
        }
    }

    public static void e(om1 om1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, om1Var) == null) {
            synchronized (q44.class) {
                if (d != null) {
                    d.f(om1Var);
                } else if (b) {
                    Log.v(c, "未初始化，无需执行release");
                }
            }
        }
    }

    public static void h(om1 om1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, om1Var) == null) {
            synchronized (q44.class) {
                if (d != null) {
                    d.c(om1Var).k();
                }
            }
        }
    }

    public boolean a(Context context, um2 um2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, um2Var)) == null) {
            ix1.i("map", "map create start");
            if (ce3.m(um2Var.c) != null && um2Var.isValid()) {
                qm1 A = vl2.U().A(um2Var.c);
                if (!(A instanceof om1)) {
                    ix1.c("map", "WebViewManager is null");
                    return false;
                }
                p44 c2 = c((om1) A);
                if (c2.d(um2Var.b) != null) {
                    ix1.c("map", "map with id " + um2Var.b + " exist");
                    return false;
                }
                r54 K = r54.K(context, um2Var);
                if (K == null) {
                    ix1.c("map", "map with id " + um2Var.b + " model is invalid");
                    return false;
                }
                zv1 insert = K.insert();
                if (!insert.a()) {
                    ix1.c("map", "map with id " + um2Var.b + " create fail: " + insert.b);
                    return false;
                } else if (c2.insert(K)) {
                    ix1.i("map", "map with id " + um2Var.b + " init start");
                    k54.a(context, K, um2Var, c2);
                    ix1.i("map", "map with id " + um2Var.b + " init end");
                    ix1.i("map", "map create end");
                    return true;
                } else {
                    return false;
                }
            }
            ix1.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public synchronized p44 c(om1 om1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, om1Var)) == null) {
            synchronized (this) {
                if (om1Var == null) {
                    return null;
                }
                p44 p44Var = this.a.get(om1Var);
                if (p44Var == null) {
                    p44Var = new p44();
                    this.a.put(om1Var, p44Var);
                }
                return p44Var;
            }
        }
        return (p44) invokeL.objValue;
    }

    public final synchronized void f(om1 om1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, om1Var) == null) {
            synchronized (this) {
                if (om1Var == null) {
                    return;
                }
                p44 remove = this.a.remove(om1Var);
                if (remove != null) {
                    remove.i();
                }
            }
        }
    }

    public boolean g(um2 um2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, um2Var)) == null) {
            ix1.i("map", "map remove start");
            if (ce3.m(um2Var.c) == null) {
                ix1.c("map", "webView is null or mapModel is null");
                return false;
            }
            qm1 A = vl2.U().A(um2Var.c);
            if (!(A instanceof om1)) {
                ix1.c("map", "WebViewManager is null");
                return false;
            }
            p44 c2 = c((om1) A);
            r54 d2 = c2.d(um2Var.b);
            if (d2 == null) {
                ix1.c("map", "remove map with id " + um2Var.b + " not exist");
                return false;
            } else if (c2.j(um2Var.b)) {
                ix1.i("map", "map remove end");
                if (vw1.a(um2Var) == null) {
                    bx1.a("map", "remove with a null map component");
                }
                zv1 B = d2.B();
                boolean a = B.a();
                if (!a) {
                    String str = c;
                    ix1.c(str, "map remove fail: " + B.b);
                }
                return a;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean update(Context context, um2 um2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, um2Var)) == null) {
            ix1.i("map", "map update start");
            if (ce3.m(um2Var.c) == null) {
                ix1.c("map", "webView is null or mapModel is null");
                return false;
            }
            qm1 A = vl2.U().A(um2Var.c);
            if (A != null && (A instanceof om1)) {
                p44 c2 = c((om1) A);
                r54 d2 = c2.d(um2Var.b);
                if (d2 == null) {
                    ix1.c("map", "remove map with id " + um2Var.b + " not exist");
                    return false;
                }
                d2.F();
                k54.b(context, d2, um2Var, c2, true);
                ix1.i("map", "map update end");
                if (vw1.a(um2Var) == null) {
                    bx1.a("map", "update with a null map component");
                }
                zv1 update = d2.update((r54) um2Var);
                boolean a = update.a();
                if (!a) {
                    String str = c;
                    ix1.c(str, "map update fail: " + update.b);
                }
                return a;
            }
            ix1.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
