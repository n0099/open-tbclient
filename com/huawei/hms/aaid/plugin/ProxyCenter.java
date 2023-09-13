package com.huawei.hms.aaid.plugin;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class ProxyCenter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PushProxy proxy;

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static ProxyCenter a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1867473038, "Lcom/huawei/hms/aaid/plugin/ProxyCenter$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1867473038, "Lcom/huawei/hms/aaid/plugin/ProxyCenter$a;");
                    return;
                }
            }
            a = new ProxyCenter();
        }
    }

    public ProxyCenter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static ProxyCenter getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a.a;
        }
        return (ProxyCenter) invokeV.objValue;
    }

    public static PushProxy getProxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return getInstance().proxy;
        }
        return (PushProxy) invokeV.objValue;
    }

    public static void register(PushProxy pushProxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, pushProxy) == null) {
            getInstance().proxy = pushProxy;
        }
    }
}
