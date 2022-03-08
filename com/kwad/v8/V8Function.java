package com.kwad.v8;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class V8Function extends V8Object {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public V8Function(V8 v8) {
        this(v8, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((V8) objArr2[0], (JavaCallback) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V8Function(V8 v8, JavaCallback javaCallback) {
        super(v8, javaCallback);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8, javaCallback};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((V8) objArr2[0], objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public Object call(V8Object v8Object, V8Array v8Array) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, v8Object, v8Array)) == null) {
            this.v8.checkThread();
            checkReleased();
            this.v8.checkRuntime(v8Object);
            this.v8.checkRuntime(v8Array);
            if (v8Object == null) {
                v8Object = this.v8;
            }
            long handle = v8Array == null ? 0L : v8Array.getHandle();
            if (v8Object.isUndefined()) {
                v8Object = this.v8;
            }
            long handle2 = v8Object.getHandle();
            V8 v8 = this.v8;
            return v8.executeFunction(v8.getV8RuntimePtr(), handle2, this.objectHandle, handle);
        }
        return invokeLL.objValue;
    }

    @Override // com.kwad.v8.V8Object, com.kwad.v8.V8Value
    public V8Value createTwin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new V8Function(this.v8) : (V8Value) invokeV.objValue;
    }

    @Override // com.kwad.v8.V8Value
    public void initialize(long j2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j2, obj) == null) {
            if (obj == null) {
                super.initialize(j2, null);
                return;
            }
            long[] initNewV8Function = this.v8.initNewV8Function(j2);
            this.v8.createAndRegisterMethodDescriptor((JavaCallback) obj, initNewV8Function[1]);
            this.released = false;
            addObjectReference(initNewV8Function[0]);
        }
    }

    @Override // com.kwad.v8.V8Object
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.released || this.v8.isReleased()) ? "[Function released]" : super.toString() : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.v8.V8Object, com.kwad.v8.V8Value
    public V8Function twin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (V8Function) super.twin() : (V8Function) invokeV.objValue;
    }
}
