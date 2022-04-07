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
public final class s63 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l73 a;

        public a(l73 l73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l73Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l73Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                q63.k("934", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755368639, "Lcom/repackage/s63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755368639, "Lcom/repackage/s63;");
                return;
            }
        }
        a = tg1.a;
    }

    public static void a(l73 l73Var, gl2 gl2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, l73Var, gl2Var) == null) || l73Var == null || gl2Var == null) {
            return;
        }
        l73Var.a = c73.n(gl2Var.G());
        l73Var.f = gl2Var.H();
        l73Var.c = gl2Var.T();
        l73Var.a("swan", o93.h(gl2Var.G()));
        l73Var.a("appversion", gl2Var.v1());
        l73Var.a("thirdversion", gl2Var.w1());
        l73Var.b(c73.k(gl2Var.W()));
        l73Var.d(gl2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
    }

    public static void b(m73 m73Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, m73Var) == null) {
            if (m73Var == null) {
                if (a) {
                    Log.w("SwanAppFuncUbc", "event is null");
                    return;
                }
                return;
            }
            l73 l73Var = new l73();
            l73Var.f = m73Var.f;
            l73Var.a = m73Var.a;
            l73Var.g = m73Var.g;
            l73Var.c = m73Var.c;
            l73Var.b = m73Var.b;
            l73Var.e = m73Var.e;
            l73Var.e(m73Var.c());
            c(l73Var);
        }
    }

    public static void c(l73 l73Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, l73Var) == null) {
            dd3.j(new a(l73Var), "SwanAppFuncClickUBC");
        }
    }
}
