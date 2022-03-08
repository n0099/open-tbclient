package com.tachikoma.core.bridge;

import android.os.Handler;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8;
import com.kwad.v8.V8Array;
import com.kwad.v8.V8Object;
/* loaded from: classes8.dex */
public class TKV8 extends V8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isRelease;
    public int jsCallJavaStack;

    public TKV8() {
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
        this.jsCallJavaStack = 0;
        this.isRelease = false;
    }

    public static TKV8 createV8Runtime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new TKV8() : (TKV8) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realRelease(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65539, this, z) == null) || this.isRelease) {
            return;
        }
        this.isRelease = true;
        super.release(z);
    }

    @Override // com.kwad.v8.V8
    public Object callObjectJavaMethod(long j2, V8Object v8Object, V8Array v8Array) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), v8Object, v8Array})) == null) {
            try {
                this.jsCallJavaStack++;
                return super.callObjectJavaMethod(j2, v8Object, v8Array);
            } finally {
                this.jsCallJavaStack--;
            }
        }
        return invokeCommon.objValue;
    }

    @Override // com.kwad.v8.V8
    public void callVoidJavaMethod(long j2, V8Object v8Object, V8Array v8Array) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), v8Object, v8Array}) == null) {
            try {
                this.jsCallJavaStack++;
                super.callVoidJavaMethod(j2, v8Object, v8Array);
            } finally {
                this.jsCallJavaStack--;
            }
        }
    }

    @Override // com.kwad.v8.V8
    public void release(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (this.jsCallJavaStack <= 0) {
                realRelease(z);
                return;
            }
            Handler handler = new Handler();
            handler.sendMessageAtFrontOfQueue(Message.obtain(handler, new Runnable(this, z) { // from class: com.tachikoma.core.bridge.TKV8.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TKV8 this$0;
                public final /* synthetic */ boolean val$reportMemoryLeaks;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
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
                    this.val$reportMemoryLeaks = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.realRelease(this.val$reportMemoryLeaks);
                    }
                }
            }));
        }
    }
}
