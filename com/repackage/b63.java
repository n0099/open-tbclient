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
public final class b63 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u63 a;

        public a(u63 u63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u63Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                z53.k("934", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755875086, "Lcom/repackage/b63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755875086, "Lcom/repackage/b63;");
                return;
            }
        }
        a = cg1.a;
    }

    public static void a(u63 u63Var, pk2 pk2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, u63Var, pk2Var) == null) || u63Var == null || pk2Var == null) {
            return;
        }
        u63Var.a = l63.n(pk2Var.G());
        u63Var.f = pk2Var.H();
        u63Var.c = pk2Var.T();
        u63Var.a("swan", x83.h(pk2Var.G()));
        u63Var.a("appversion", pk2Var.v1());
        u63Var.a("thirdversion", pk2Var.w1());
        u63Var.b(l63.k(pk2Var.W()));
        u63Var.d(pk2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
    }

    public static void b(v63 v63Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, v63Var) == null) {
            if (v63Var == null) {
                if (a) {
                    Log.w("SwanAppFuncUbc", "event is null");
                    return;
                }
                return;
            }
            u63 u63Var = new u63();
            u63Var.f = v63Var.f;
            u63Var.a = v63Var.a;
            u63Var.g = v63Var.g;
            u63Var.c = v63Var.c;
            u63Var.b = v63Var.b;
            u63Var.e = v63Var.e;
            u63Var.e(v63Var.c());
            c(u63Var);
        }
    }

    public static void c(u63 u63Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, u63Var) == null) {
            mc3.j(new a(u63Var), "SwanAppFuncClickUBC");
        }
    }
}
