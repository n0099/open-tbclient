package com.kwad.v8.debug;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.Releasable;
import com.kwad.v8.V8Array;
import com.kwad.v8.V8Object;
import com.kwad.v8.debug.mirror.Frame;
/* loaded from: classes5.dex */
public class ExecutionState implements Releasable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FRAME = "frame";
    public static final String FRAME_COUNT = "frameCount";
    public static final String PREPARE_STEP = "prepareStep";
    public transient /* synthetic */ FieldHolder $fh;
    public V8Object v8Object;

    public ExecutionState(V8Object v8Object) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8Object};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public Frame getFrame(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            V8Array v8Array = new V8Array(this.v8Object.getRuntime());
            v8Array.push(i);
            V8Object v8Object = null;
            try {
                v8Object = this.v8Object.executeObjectFunction(FRAME, v8Array);
                return new Frame(v8Object);
            } finally {
                v8Array.close();
                if (v8Object != null) {
                    v8Object.close();
                }
            }
        }
        return (Frame) invokeI.objValue;
    }

    public int getFrameCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.v8Object.executeIntegerFunction(FRAME_COUNT, null) : invokeV.intValue;
    }

    public void prepareStep(StepAction stepAction) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, stepAction) == null) {
            V8Array v8Array = new V8Array(this.v8Object.getRuntime());
            v8Array.push(stepAction.index);
            try {
                this.v8Object.executeVoidFunction(PREPARE_STEP, v8Array);
            } finally {
                v8Array.close();
            }
        }
    }

    @Override // com.kwad.v8.Releasable
    @Deprecated
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            close();
        }
    }
}
