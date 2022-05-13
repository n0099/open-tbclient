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
/* loaded from: classes5.dex */
public final class d73 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w73 a;

        public a(w73 w73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w73Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w73Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b73.k("934", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755814543, "Lcom/repackage/d73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755814543, "Lcom/repackage/d73;");
                return;
            }
        }
        a = eh1.a;
    }

    public static void a(w73 w73Var, rl2 rl2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, w73Var, rl2Var) == null) || w73Var == null || rl2Var == null) {
            return;
        }
        w73Var.a = n73.n(rl2Var.G());
        w73Var.f = rl2Var.H();
        w73Var.c = rl2Var.T();
        w73Var.a("swan", z93.h(rl2Var.G()));
        w73Var.a("appversion", rl2Var.v1());
        w73Var.a("thirdversion", rl2Var.w1());
        w73Var.b(n73.k(rl2Var.W()));
        w73Var.d(rl2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
    }

    public static void b(x73 x73Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, x73Var) == null) {
            if (x73Var == null) {
                if (a) {
                    Log.w("SwanAppFuncUbc", "event is null");
                    return;
                }
                return;
            }
            w73 w73Var = new w73();
            w73Var.f = x73Var.f;
            w73Var.a = x73Var.a;
            w73Var.g = x73Var.g;
            w73Var.c = x73Var.c;
            w73Var.b = x73Var.b;
            w73Var.e = x73Var.e;
            w73Var.e(x73Var.c());
            c(w73Var);
        }
    }

    public static void c(w73 w73Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, w73Var) == null) {
            od3.j(new a(w73Var), "SwanAppFuncClickUBC");
        }
    }
}
