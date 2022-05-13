package com.repackage;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class j73 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v73 a;

        public a(v73 v73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v73Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v73Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b73.k("671", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755635797, "Lcom/repackage/j73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755635797, "Lcom/repackage/j73;");
                return;
            }
        }
        a = eh1.a;
    }

    public static void a(k84 k84Var, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{k84Var, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (k84Var == null) {
                if (a) {
                    Log.d("SwanStabilityUbc", "pms callback is null");
                    return;
                }
                return;
            }
            nc3 nc3Var = new nc3();
            nc3Var.k(11L);
            nc3Var.i(2331L);
            nc3Var.f("Retry=" + z + ", Scene=" + k84Var.getClass().getName());
            v73 v73Var = new v73();
            v73Var.q(n73.n(i));
            v73Var.p(nc3Var);
            if (k84Var instanceof v32) {
                v73Var.r(((v32) k84Var).J0());
            }
            b(v73Var);
            if (a) {
                Log.d("SwanStabilityUbc", "Statis: Retry=" + z + ", Scene=" + k84Var.getClass().getSimpleName());
            }
        }
    }

    public static void b(v73 v73Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, v73Var) == null) {
            if (v73Var == null) {
                if (a) {
                    Log.d("SwanStabilityUbc", "event is null");
                    return;
                }
                return;
            }
            od3.k(new a(v73Var), "SwanStabilityUBC");
        }
    }
}
