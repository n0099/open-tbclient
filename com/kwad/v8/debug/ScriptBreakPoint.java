package com.kwad.v8.debug;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import com.kwad.v8.Releasable;
import com.kwad.v8.V8Array;
import com.kwad.v8.V8Object;
import com.kwad.v8.V8ResultUndefined;
/* loaded from: classes2.dex */
public class ScriptBreakPoint implements Releasable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CONDITION = "condition";
    public static final String LINE = "line";
    public static final String NUMBER = "number";
    public static final String SET_CONDITION = "setCondition";
    public transient /* synthetic */ FieldHolder $fh;
    public V8Object v8Object;

    public ScriptBreakPoint(V8Object v8Object) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8Object};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v8Object = v8Object.twin();
    }

    @Override // com.kwad.v8.Releasable, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        V8Object v8Object;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (v8Object = this.v8Object) == null || v8Object.isReleased()) {
            return;
        }
        this.v8Object.close();
        this.v8Object = null;
    }

    public int getBreakPointNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.v8Object.executeIntegerFunction("number", null) : invokeV.intValue;
    }

    public String getCondition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                return this.v8Object.executeStringFunction(CONDITION, null);
            } catch (V8ResultUndefined unused) {
                return SessionMonitorEngine.PUBLIC_DATA_UNDIFNED;
            }
        }
        return (String) invokeV.objValue;
    }

    public int getLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.v8Object.executeIntegerFunction("line", null) : invokeV.intValue;
    }

    @Override // com.kwad.v8.Releasable
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            close();
        }
    }

    public void setCondition(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            V8Array v8Array = new V8Array(this.v8Object.getRuntime());
            v8Array.push(str);
            try {
                this.v8Object.executeVoidFunction(SET_CONDITION, v8Array);
            } finally {
                v8Array.close();
            }
        }
    }
}
