package com.kuaishou.tachikoma.api;

import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.tachikoma.api.page.IFunction;
import com.kwad.v8.V8Array;
import com.kwad.v8.V8Function;
import com.tachikoma.core.exception.TKExceptionDispatcher;
import com.tachikoma.core.utility.V8Proxy;
/* loaded from: classes2.dex */
public class FunctionCallImpl implements IFunction {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public V8Function mV8Function;

    public FunctionCallImpl(@Nullable V8Function v8Function) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8Function};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (v8Function != null) {
            this.mV8Function = v8Function.twin();
        }
    }

    @Override // com.kuaishou.tachikoma.api.page.IFunction
    @Nullable
    public Object call(@Nullable Object... objArr) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
            if (V8Proxy.isV8Valid(this.mV8Function)) {
                try {
                    V8Array createV8Array = V8Proxy.createV8Array(this.mV8Function, objArr);
                    obj = this.mV8Function.call(null, createV8Array);
                    try {
                        V8Proxy.release(createV8Array);
                    } catch (Throwable th) {
                        th = th;
                        TKExceptionDispatcher.reportException(null, th);
                        return obj;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obj = null;
                }
                return obj;
            }
            return null;
        }
        return invokeL.objValue;
    }
}
