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
public final class i73 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b83 a;

        public a(b83 b83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b83Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b83Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g73.k("934", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755665588, "Lcom/repackage/i73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755665588, "Lcom/repackage/i73;");
                return;
            }
        }
        a = jh1.a;
    }

    public static void a(b83 b83Var, wl2 wl2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, b83Var, wl2Var) == null) || b83Var == null || wl2Var == null) {
            return;
        }
        b83Var.a = s73.n(wl2Var.G());
        b83Var.f = wl2Var.H();
        b83Var.c = wl2Var.T();
        b83Var.a("swan", ea3.h(wl2Var.G()));
        b83Var.a("appversion", wl2Var.v1());
        b83Var.a("thirdversion", wl2Var.w1());
        b83Var.b(s73.k(wl2Var.W()));
        b83Var.d(wl2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
    }

    public static void b(c83 c83Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, c83Var) == null) {
            if (c83Var == null) {
                if (a) {
                    Log.w("SwanAppFuncUbc", "event is null");
                    return;
                }
                return;
            }
            b83 b83Var = new b83();
            b83Var.f = c83Var.f;
            b83Var.a = c83Var.a;
            b83Var.g = c83Var.g;
            b83Var.c = c83Var.c;
            b83Var.b = c83Var.b;
            b83Var.e = c83Var.e;
            b83Var.e(c83Var.c());
            c(b83Var);
        }
    }

    public static void c(b83 b83Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, b83Var) == null) {
            td3.j(new a(b83Var), "SwanAppFuncClickUBC");
        }
    }
}
