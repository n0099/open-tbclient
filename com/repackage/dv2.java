package com.repackage;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dv2 implements nf3<HybridUbcFlow> {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean b = true;
    public static int c = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(dv2 dv2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                oe3.Y();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755754031, "Lcom/repackage/dv2;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755754031, "Lcom/repackage/dv2;");
        }
    }

    public dv2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str;
    }

    public final void a(@NonNull HybridUbcFlow hybridUbcFlow) {
        UbcFlowEvent g;
        UbcFlowEvent a2;
        UbcFlowEvent a3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, hybridUbcFlow) == null) || (g = hybridUbcFlow.g("na_first_meaningful_paint")) == null) {
            return;
        }
        h72 h72Var = (h72) hybridUbcFlow.k("fmp_data_record");
        if ("fmp_callback".equals(this.a)) {
            String name = dv2.class.getName();
            Log.d(name, "Current Record FMP - " + g.a + ":" + g.g());
            if (h72Var == null || (a3 = h72Var.a()) == null) {
                return;
            }
            String name2 = dv2.class.getName();
            Log.d(name2, "First Page Record FMP - " + a3.a + ":" + a3.g());
        } else if ("callback_on_submit".equals(this.a)) {
            String name3 = dv2.class.getName();
            Log.d(name3, "Real Report FMP - " + g.a + ":" + g.g());
            if (h72Var == null || (a2 = h72Var.a()) == null) {
                return;
            }
            String name4 = dv2.class.getName();
            Log.d(name4, "First Page Report FMP - " + a2.a + ":" + a2.g());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.nf3
    /* renamed from: b */
    public synchronized void onCallback(HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hybridUbcFlow) == null) {
            synchronized (this) {
                if (b) {
                    if (c == -1) {
                        bk2.g0().getSwitch("swan_next_env_delay", 600);
                        c = 600;
                    }
                    oe3.b0(new a(this), c);
                }
                if (eh1.a) {
                    String name = getClass().getName();
                    Log.d(name, "enable=" + b + ", delay=" + c);
                }
                if ("fmp_callback".equals(this.a)) {
                    b = false;
                } else if ("callback_on_submit".equals(this.a)) {
                    b = true;
                }
                if (eh1.a && hybridUbcFlow != null) {
                    a(hybridUbcFlow);
                }
            }
        }
    }
}
