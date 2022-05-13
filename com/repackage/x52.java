package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class x52 implements w52 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile x52 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, v52> a;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ x52 b;

        public a(x52 x52Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x52Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x52Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.h(this.a);
            }
        }
    }

    public x52() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
    }

    public static x52 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (x52.class) {
                    if (b == null) {
                        b = new x52();
                    }
                }
            }
            return b;
        }
        return (x52) invokeV.objValue;
    }

    public synchronized x52 b(String str, UbcFlowEvent ubcFlowEvent) {
        InterceptResult invokeLL;
        v52 v52Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, ubcFlowEvent)) == null) {
            synchronized (this) {
                if (c(str) && (v52Var = this.a.get(str)) != null) {
                    v52Var.a(str, ubcFlowEvent);
                    return this;
                }
                return this;
            }
        }
        return (x52) invokeLL.objValue;
    }

    public final boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? !TextUtils.isEmpty(str) : invokeL.booleanValue;
    }

    public synchronized x52 e(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        v52 v52Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            synchronized (this) {
                if (c(str) && (v52Var = this.a.get(str)) != null) {
                    v52Var.d(str, z);
                    if (z2) {
                        i(str);
                    }
                    return this;
                }
                return this;
            }
        }
        return (x52) invokeCommon.objValue;
    }

    public synchronized x52 f(String str, y52 y52Var) {
        InterceptResult invokeLL;
        v52 v52Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, y52Var)) == null) {
            synchronized (this) {
                if (c(str) && (v52Var = this.a.get(str)) != null) {
                    v52Var.e(str, y52Var);
                    return this;
                }
                return this;
            }
        }
        return (x52) invokeLL.objValue;
    }

    public synchronized x52 g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            synchronized (this) {
                if (c(str) && !this.a.containsKey(str)) {
                    v52 v52Var = new v52();
                    this.a.put(str, v52Var);
                    v52Var.f(str);
                    return this;
                }
                return this;
            }
        }
        return (x52) invokeL.objValue;
    }

    public final synchronized void h(String str) {
        v52 v52Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            synchronized (this) {
                if (c(str) && (v52Var = this.a.get(str)) != null) {
                    this.a.remove(str);
                    v52Var.h(str);
                }
            }
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            j(str, 0L);
        }
    }

    public void j(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048583, this, str, j) == null) {
            ExecutorUtilsExt.delayPostOnElastic(new a(this, str), "PrefetchStageRecorder", 3, j);
        }
    }
}
