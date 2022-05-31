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
/* loaded from: classes6.dex */
public final class q53 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j63 a;

        public a(j63 j63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j63Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                o53.k("934", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755429182, "Lcom/repackage/q53;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755429182, "Lcom/repackage/q53;");
                return;
            }
        }
        a = rf1.a;
    }

    public static void a(j63 j63Var, ek2 ek2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, j63Var, ek2Var) == null) || j63Var == null || ek2Var == null) {
            return;
        }
        j63Var.a = a63.n(ek2Var.G());
        j63Var.f = ek2Var.H();
        j63Var.c = ek2Var.T();
        j63Var.a("swan", m83.h(ek2Var.G()));
        j63Var.a("appversion", ek2Var.v1());
        j63Var.a("thirdversion", ek2Var.w1());
        j63Var.b(a63.k(ek2Var.W()));
        j63Var.d(ek2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
    }

    public static void b(k63 k63Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, k63Var) == null) {
            if (k63Var == null) {
                if (a) {
                    Log.w("SwanAppFuncUbc", "event is null");
                    return;
                }
                return;
            }
            j63 j63Var = new j63();
            j63Var.f = k63Var.f;
            j63Var.a = k63Var.a;
            j63Var.g = k63Var.g;
            j63Var.c = k63Var.c;
            j63Var.b = k63Var.b;
            j63Var.e = k63Var.e;
            j63Var.e(k63Var.c());
            c(j63Var);
        }
    }

    public static void c(j63 j63Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, j63Var) == null) {
            bc3.j(new a(j63Var), "SwanAppFuncClickUBC");
        }
    }
}
