package com.yy.hiidostatis.api;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.perf.taskexecutor.IYYTaskExecutor;
/* loaded from: classes4.dex */
public class ExecutorProvider {
    public static /* synthetic */ Interceptable $ic;
    public static IYYTaskExecutor iyyTaskExecutor;
    public transient /* synthetic */ FieldHolder $fh;

    public ExecutorProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static IYYTaskExecutor getIyyTaskExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? iyyTaskExecutor : (IYYTaskExecutor) invokeV.objValue;
    }

    public static void setIyyTaskExecutor(IYYTaskExecutor iYYTaskExecutor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, iYYTaskExecutor) == null) {
            iyyTaskExecutor = iYYTaskExecutor;
        }
    }
}
