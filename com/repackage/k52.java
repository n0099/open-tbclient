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
/* loaded from: classes6.dex */
public class k52 implements j52 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile k52 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, i52> a;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ k52 b;

        public a(k52 k52Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k52Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k52Var;
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

    public k52() {
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

    public static k52 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (k52.class) {
                    if (b == null) {
                        b = new k52();
                    }
                }
            }
            return b;
        }
        return (k52) invokeV.objValue;
    }

    public synchronized k52 b(String str, UbcFlowEvent ubcFlowEvent) {
        InterceptResult invokeLL;
        i52 i52Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, ubcFlowEvent)) == null) {
            synchronized (this) {
                if (c(str) && (i52Var = this.a.get(str)) != null) {
                    i52Var.a(str, ubcFlowEvent);
                    return this;
                }
                return this;
            }
        }
        return (k52) invokeLL.objValue;
    }

    public final boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? !TextUtils.isEmpty(str) : invokeL.booleanValue;
    }

    public synchronized k52 e(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        i52 i52Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            synchronized (this) {
                if (c(str) && (i52Var = this.a.get(str)) != null) {
                    i52Var.d(str, z);
                    if (z2) {
                        i(str);
                    }
                    return this;
                }
                return this;
            }
        }
        return (k52) invokeCommon.objValue;
    }

    public synchronized k52 f(String str, l52 l52Var) {
        InterceptResult invokeLL;
        i52 i52Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, l52Var)) == null) {
            synchronized (this) {
                if (c(str) && (i52Var = this.a.get(str)) != null) {
                    i52Var.e(str, l52Var);
                    return this;
                }
                return this;
            }
        }
        return (k52) invokeLL.objValue;
    }

    public synchronized k52 g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            synchronized (this) {
                if (c(str) && !this.a.containsKey(str)) {
                    i52 i52Var = new i52();
                    this.a.put(str, i52Var);
                    i52Var.f(str);
                    return this;
                }
                return this;
            }
        }
        return (k52) invokeL.objValue;
    }

    public final synchronized void h(String str) {
        i52 i52Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            synchronized (this) {
                if (c(str) && (i52Var = this.a.get(str)) != null) {
                    this.a.remove(str);
                    i52Var.h(str);
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
