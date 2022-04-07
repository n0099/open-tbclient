package com.kwad.v8;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class V8Plugins {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ErrorHandler sJSBindingErrorHandler;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface ErrorHandler {
        void onExceptionCaptured(Throwable th);
    }

    public V8Plugins() {
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

    public static ErrorHandler getJSBindingErrorHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? sJSBindingErrorHandler : (ErrorHandler) invokeV.objValue;
    }

    public static void setJSBindingErrorHandler(ErrorHandler errorHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, errorHandler) == null) {
            sJSBindingErrorHandler = errorHandler;
        }
    }
}
