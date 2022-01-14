package com.tachikoma.core;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8Function;
import com.tachikoma.core.bridge.TKJSContext;
import com.tachikoma.core.utility.TKEnv;
import com.tachikoma.core.utility.V8Proxy;
/* loaded from: classes4.dex */
public class V8FunctionImpl implements IV8Function {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TKJSContext mTKJSContext;
    public V8Function mV8Function;

    public V8FunctionImpl(V8Function v8Function, TKJSContext tKJSContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8Function, tKJSContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mV8Function = null;
        if (v8Function != null) {
            this.mV8Function = v8Function.twin();
        }
        this.mTKJSContext = tKJSContext;
    }

    @Override // com.tachikoma.core.IV8Function
    public Object call(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
            V8Function v8Function = this.mV8Function;
            if (v8Function == null) {
                return null;
            }
            try {
                return v8Function.call(null, V8Proxy.createV8Array(v8Function, objArr));
            } catch (Throwable th) {
                TKJSContext tKJSContext = this.mTKJSContext;
                if (tKJSContext == null || !TKEnv.isDebug(tKJSContext)) {
                    TKJSContext tKJSContext2 = this.mTKJSContext;
                    if (tKJSContext2 != null && tKJSContext2.getExceptionHandler() != null) {
                        this.mTKJSContext.getExceptionHandler().onException(th);
                    }
                    return null;
                }
                throw th;
            }
        }
        return invokeL.objValue;
    }
}
