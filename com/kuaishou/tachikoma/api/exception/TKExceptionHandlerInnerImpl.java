package com.kuaishou.tachikoma.api.exception;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.tachikoma.api.model.TKBundle;
import com.kwad.v8.V8ScriptCompilationException;
import com.kwad.v8.V8ScriptExecutionException;
import com.tachikoma.core.api.ITKExceptionHandlerInner;
/* loaded from: classes3.dex */
public class TKExceptionHandlerInnerImpl implements ITKExceptionHandlerInner {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ITKExceptionHandler mHandler;

    public TKExceptionHandlerInnerImpl(ITKExceptionHandler iTKExceptionHandler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iTKExceptionHandler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mHandler = iTKExceptionHandler;
    }

    @Override // com.tachikoma.core.api.ITKExceptionHandlerInner
    public void handleException(Throwable th, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, th, i2) == null) || this.mHandler == null) {
            return;
        }
        this.mHandler.handleException(new TKException(th), BundleContextMap.get(i2));
    }

    @Override // com.tachikoma.core.api.ITKExceptionHandlerInner
    public void handleJSException(Throwable th, int i2) {
        ITKExceptionHandler iTKExceptionHandler;
        Throwable tKJSCompilationException;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, i2) == null) || this.mHandler == null) {
            return;
        }
        TKBundle tKBundle = BundleContextMap.get(i2);
        if (th instanceof V8ScriptExecutionException) {
            V8ScriptExecutionException v8ScriptExecutionException = (V8ScriptExecutionException) th;
            iTKExceptionHandler = this.mHandler;
            tKJSCompilationException = new TKJSExecutionException(v8ScriptExecutionException.getFileName(), v8ScriptExecutionException.getLineNumber(), v8ScriptExecutionException.getJSMessage(), v8ScriptExecutionException.getSourceLine(), v8ScriptExecutionException.getStartColumn(), v8ScriptExecutionException.getEndColumn(), v8ScriptExecutionException.getJSStackTrace(), v8ScriptExecutionException.getCause());
        } else if (!(th instanceof V8ScriptCompilationException)) {
            this.mHandler.handleException(new TKException(th), tKBundle);
            return;
        } else {
            V8ScriptCompilationException v8ScriptCompilationException = (V8ScriptCompilationException) th;
            iTKExceptionHandler = this.mHandler;
            tKJSCompilationException = new TKJSCompilationException(v8ScriptCompilationException.getFileName(), v8ScriptCompilationException.getLineNumber(), v8ScriptCompilationException.getJSMessage(), v8ScriptCompilationException.getSourceLine(), v8ScriptCompilationException.getStartColumn(), v8ScriptCompilationException.getEndColumn(), v8ScriptCompilationException.getJSStackTrace(), v8ScriptCompilationException.getCause());
        }
        iTKExceptionHandler.handleException(tKJSCompilationException, tKBundle);
    }

    @Override // com.tachikoma.core.api.ITKExceptionHandlerInner
    public void handleJSException(Throwable th, String str, int i2) {
        ITKExceptionHandler iTKExceptionHandler;
        Throwable tKJSCompilationException;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, th, str, i2) == null) || this.mHandler == null) {
            return;
        }
        TKBundle tKBundle = BundleContextMap.get(i2);
        if (th instanceof V8ScriptExecutionException) {
            V8ScriptExecutionException v8ScriptExecutionException = (V8ScriptExecutionException) th;
            iTKExceptionHandler = this.mHandler;
            String fileName = v8ScriptExecutionException.getFileName();
            int lineNumber = v8ScriptExecutionException.getLineNumber();
            tKJSCompilationException = new TKJSExecutionException(fileName, lineNumber, str + "_" + v8ScriptExecutionException.getJSMessage(), v8ScriptExecutionException.getSourceLine(), v8ScriptExecutionException.getStartColumn(), v8ScriptExecutionException.getEndColumn(), v8ScriptExecutionException.getJSStackTrace(), v8ScriptExecutionException.getCause());
        } else if (!(th instanceof V8ScriptCompilationException)) {
            this.mHandler.handleException(new TKException(th), tKBundle);
            return;
        } else {
            V8ScriptCompilationException v8ScriptCompilationException = (V8ScriptCompilationException) th;
            iTKExceptionHandler = this.mHandler;
            String fileName2 = v8ScriptCompilationException.getFileName();
            int lineNumber2 = v8ScriptCompilationException.getLineNumber();
            tKJSCompilationException = new TKJSCompilationException(fileName2, lineNumber2, str + "_" + v8ScriptCompilationException.getJSMessage(), v8ScriptCompilationException.getSourceLine(), v8ScriptCompilationException.getStartColumn(), v8ScriptCompilationException.getEndColumn(), v8ScriptCompilationException.getJSStackTrace(), v8ScriptCompilationException.getCause());
        }
        iTKExceptionHandler.handleException(tKJSCompilationException, tKBundle);
    }
}
