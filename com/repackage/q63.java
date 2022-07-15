package com.repackage;

import android.util.Log;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class q63 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j73 a;

        public a(j73 j73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j73Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j73Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                o63.k("934", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755428221, "Lcom/repackage/q63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755428221, "Lcom/repackage/q63;");
                return;
            }
        }
        a = rg1.a;
    }

    public static void a(j73 j73Var, el2 el2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, j73Var, el2Var) == null) || j73Var == null || el2Var == null) {
            return;
        }
        j73Var.a = a73.n(el2Var.G());
        j73Var.f = el2Var.H();
        j73Var.c = el2Var.T();
        j73Var.a("swan", m93.h(el2Var.G()));
        j73Var.a("appversion", el2Var.v1());
        j73Var.a("thirdversion", el2Var.w1());
        j73Var.b(a73.k(el2Var.W()));
        j73Var.d(el2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
    }

    public static void b(k73 k73Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, k73Var) == null) {
            if (k73Var == null) {
                if (a) {
                    Log.w("SwanAppFuncUbc", "event is null");
                    return;
                }
                return;
            }
            j73 j73Var = new j73();
            j73Var.f = k73Var.f;
            j73Var.a = k73Var.a;
            j73Var.g = k73Var.g;
            j73Var.c = k73Var.c;
            j73Var.b = k73Var.b;
            j73Var.e = k73Var.e;
            j73Var.e(k73Var.c());
            c(j73Var);
        }
    }

    public static void c(j73 j73Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, j73Var) == null) {
            bd3.j(new a(j73Var), "SwanAppFuncClickUBC");
        }
    }
}
