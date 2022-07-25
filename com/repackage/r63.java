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
public final class r63 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k73 a;

        public a(k73 k73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k73Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k73Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p63.k("934", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755398430, "Lcom/repackage/r63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755398430, "Lcom/repackage/r63;");
                return;
            }
        }
        a = sg1.a;
    }

    public static void a(k73 k73Var, fl2 fl2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, k73Var, fl2Var) == null) || k73Var == null || fl2Var == null) {
            return;
        }
        k73Var.a = b73.n(fl2Var.G());
        k73Var.f = fl2Var.H();
        k73Var.c = fl2Var.T();
        k73Var.a("swan", n93.h(fl2Var.G()));
        k73Var.a("appversion", fl2Var.v1());
        k73Var.a("thirdversion", fl2Var.w1());
        k73Var.b(b73.k(fl2Var.W()));
        k73Var.d(fl2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
    }

    public static void b(l73 l73Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, l73Var) == null) {
            if (l73Var == null) {
                if (a) {
                    Log.w("SwanAppFuncUbc", "event is null");
                    return;
                }
                return;
            }
            k73 k73Var = new k73();
            k73Var.f = l73Var.f;
            k73Var.a = l73Var.a;
            k73Var.g = l73Var.g;
            k73Var.c = l73Var.c;
            k73Var.b = l73Var.b;
            k73Var.e = l73Var.e;
            k73Var.e(l73Var.c());
            c(k73Var);
        }
    }

    public static void c(k73 k73Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, k73Var) == null) {
            cd3.j(new a(k73Var), "SwanAppFuncClickUBC");
        }
    }
}
