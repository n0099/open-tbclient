package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class it2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, Map<String, HybridUbcFlow>> a;
    public final Map<String, cf3<HybridUbcFlow>> b;
    public final cf3<HybridUbcFlow> c;

    /* loaded from: classes6.dex */
    public class a implements cf3<HybridUbcFlow> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ it2 a;

        public a(it2 it2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {it2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = it2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.cf3
        /* renamed from: a */
        public void onCallback(HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hybridUbcFlow) == null) {
                this.a.g(hybridUbcFlow.p);
            }
        }
    }

    public it2() {
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
        this.b = new HashMap();
        this.c = new a(this);
    }

    public final HybridUbcFlow a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            HybridUbcFlow hybridUbcFlow = new HybridUbcFlow(str);
            hybridUbcFlow.H("callback_on_submit", this.c);
            cf3<HybridUbcFlow> cf3Var = this.b.get(str);
            if (cf3Var != null) {
                cf3Var.onCallback(hybridUbcFlow);
            }
            return hybridUbcFlow;
        }
        return (HybridUbcFlow) invokeL.objValue;
    }

    public HybridUbcFlow b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? c(str, "default") : (HybridUbcFlow) invokeL.objValue;
    }

    public HybridUbcFlow c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            synchronized (this.a) {
                Map<String, HybridUbcFlow> map = this.a.get(str);
                if (map == null) {
                    return null;
                }
                return map.get(str2);
            }
        }
        return (HybridUbcFlow) invokeLL.objValue;
    }

    public it2 d(String str, cf3<HybridUbcFlow> cf3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, cf3Var)) == null) {
            synchronized (this.b) {
                this.b.put(str, cf3Var);
            }
            return this;
        }
        return (it2) invokeLL.objValue;
    }

    public synchronized HybridUbcFlow e(String str) {
        InterceptResult invokeL;
        HybridUbcFlow f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            synchronized (this) {
                f = f(str, "default");
            }
            return f;
        }
        return (HybridUbcFlow) invokeL.objValue;
    }

    public synchronized HybridUbcFlow f(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            synchronized (this) {
                synchronized (this.a) {
                    Map<String, HybridUbcFlow> map = this.a.get(str);
                    if (map == null) {
                        HashMap hashMap = new HashMap();
                        HybridUbcFlow a2 = a(str);
                        hashMap.put(str2, a2);
                        this.a.put(str, hashMap);
                        return a2;
                    }
                    HybridUbcFlow hybridUbcFlow = map.get(str2);
                    if (hybridUbcFlow == null) {
                        hybridUbcFlow = a(str);
                        map.put(str2, hybridUbcFlow);
                    }
                    return hybridUbcFlow;
                }
            }
        }
        return (HybridUbcFlow) invokeLL.objValue;
    }

    public it2 g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            synchronized (this.a) {
                this.a.remove(str);
            }
            return this;
        }
        return (it2) invokeL.objValue;
    }

    public it2 h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
            synchronized (this.a) {
                Map<String, HybridUbcFlow> map = this.a.get(str);
                if (map != null) {
                    map.remove(str2);
                }
            }
            return this;
        }
        return (it2) invokeLL.objValue;
    }
}
