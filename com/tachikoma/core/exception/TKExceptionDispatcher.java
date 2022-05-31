package com.tachikoma.core.exception;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.api.ITKExceptionHandlerInner;
import com.tachikoma.core.bridge.TKJSContext;
import com.tachikoma.core.utility.TKEnv;
/* loaded from: classes7.dex */
public class TKExceptionDispatcher {
    public static /* synthetic */ Interceptable $ic;
    public static ITKExceptionHandlerInner sExceptionHandler;
    public transient /* synthetic */ FieldHolder $fh;

    public TKExceptionDispatcher() {
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

    public static void dispatchException(Throwable th, int i) {
        ITKExceptionHandlerInner iTKExceptionHandlerInner;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65537, null, th, i) == null) || (iTKExceptionHandlerInner = sExceptionHandler) == null || th == null) {
            return;
        }
        iTKExceptionHandlerInner.handleException(th, i);
    }

    public static void dispatchJSException(Throwable th, int i) {
        ITKExceptionHandlerInner iTKExceptionHandlerInner;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65538, null, th, i) == null) || (iTKExceptionHandlerInner = sExceptionHandler) == null || th == null) {
            return;
        }
        iTKExceptionHandlerInner.handleJSException(th, i);
    }

    public static void dispatchJSException(Throwable th, String str, int i) {
        ITKExceptionHandlerInner iTKExceptionHandlerInner;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65539, null, th, str, i) == null) || (iTKExceptionHandlerInner = sExceptionHandler) == null || th == null) {
            return;
        }
        iTKExceptionHandlerInner.handleJSException(th, str, i);
    }

    public static void reportException(TKJSContext tKJSContext, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tKJSContext, th) == null) || th == null) {
            return;
        }
        if (TKEnv.isDebug(tKJSContext)) {
            throw new RuntimeException("reportException", th);
        }
        dispatchJSException(th, tKJSContext != null ? tKJSContext.hashCode() : -1);
    }

    public static void setExceptionHandler(ITKExceptionHandlerInner iTKExceptionHandlerInner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, iTKExceptionHandlerInner) == null) {
            sExceptionHandler = iTKExceptionHandlerInner;
        }
    }
}
