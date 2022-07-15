package com.repackage;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class w63 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i73 a;

        public a(i73 i73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i73Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i73Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                o63.k("671", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755249475, "Lcom/repackage/w63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755249475, "Lcom/repackage/w63;");
                return;
            }
        }
        a = rg1.a;
    }

    public static void a(x74 x74Var, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{x74Var, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (x74Var == null) {
                if (a) {
                    Log.d("SwanStabilityUbc", "pms callback is null");
                    return;
                }
                return;
            }
            ac3 ac3Var = new ac3();
            ac3Var.k(11L);
            ac3Var.i(2331L);
            ac3Var.f("Retry=" + z + ", Scene=" + x74Var.getClass().getName());
            i73 i73Var = new i73();
            i73Var.q(a73.n(i));
            i73Var.p(ac3Var);
            if (x74Var instanceof i32) {
                i73Var.r(((i32) x74Var).I0());
            }
            b(i73Var);
            if (a) {
                Log.d("SwanStabilityUbc", "Statis: Retry=" + z + ", Scene=" + x74Var.getClass().getSimpleName());
            }
        }
    }

    public static void b(i73 i73Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, i73Var) == null) {
            if (i73Var == null) {
                if (a) {
                    Log.d("SwanStabilityUbc", "event is null");
                    return;
                }
                return;
            }
            bd3.k(new a(i73Var), "SwanStabilityUBC");
        }
    }
}
