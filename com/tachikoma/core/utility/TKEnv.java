package com.tachikoma.core.utility;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.api.IHostEnvInner;
import com.tachikoma.core.bridge.TKJSContext;
import com.tachikoma.core.manager.TKModuleManager;
/* loaded from: classes7.dex */
public class TKEnv {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public TKEnv() {
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

    public static boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            IHostEnvInner iHostEnvInner = (IHostEnvInner) TKModuleManager.getInstance().getHandler(IHostEnvInner.class);
            return iHostEnvInner != null && iHostEnvInner.isDebug();
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public static boolean isDebug(TKJSContext tKJSContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, tKJSContext)) == null) {
            IHostEnvInner iHostEnvInner = (IHostEnvInner) TKModuleManager.getInstance().getHandler(tKJSContext, IHostEnvInner.class);
            return iHostEnvInner != null && iHostEnvInner.isDebug();
        }
        return invokeL.booleanValue;
    }
}
