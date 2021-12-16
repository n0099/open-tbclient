package com.kwad.v8.utils;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8;
/* loaded from: classes3.dex */
public final class ConcurrentV8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public V8 v8;

    public ConcurrentV8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v8 = null;
        V8 createV8Runtime = V8.createV8Runtime();
        this.v8 = createV8Runtime;
        createV8Runtime.getLocker().release();
    }

    public V8 getV8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.v8 : (V8) invokeV.objValue;
    }

    public void release() {
        V8 v8;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (v8 = this.v8) == null || v8.isReleased()) {
            return;
        }
        run(new V8Runnable(this) { // from class: com.kwad.v8.utils.ConcurrentV8.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ConcurrentV8 this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.kwad.v8.utils.V8Runnable
            public void run(V8 v82) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, v82) == null) || v82 == null || v82.isReleased()) {
                    return;
                }
                v82.close();
            }
        });
    }

    public synchronized void run(V8Runnable v8Runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, v8Runnable) == null) {
            synchronized (this) {
                this.v8.getLocker().acquire();
                v8Runnable.run(this.v8);
                if (this.v8 != null && this.v8.getLocker() != null && this.v8.getLocker().hasLock()) {
                    this.v8.getLocker().release();
                }
            }
        }
    }
}
