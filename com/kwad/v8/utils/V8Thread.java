package com.kwad.v8.utils;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8;
/* loaded from: classes5.dex */
public class V8Thread extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public V8 runtime;
    public final V8Runnable target;

    public V8Thread(V8Runnable v8Runnable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8Runnable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.target = v8Runnable;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            V8 createV8Runtime = V8.createV8Runtime();
            this.runtime = createV8Runtime;
            try {
                this.target.run(createV8Runtime);
                synchronized (this) {
                    if (this.runtime.getLocker().hasLock()) {
                        this.runtime.close();
                        this.runtime = null;
                    }
                }
            } catch (Throwable th) {
                synchronized (this) {
                    if (this.runtime.getLocker().hasLock()) {
                        this.runtime.close();
                        this.runtime = null;
                    }
                    throw th;
                }
            }
        }
    }
}
