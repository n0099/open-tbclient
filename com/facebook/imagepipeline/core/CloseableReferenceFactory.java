package com.facebook.imagepipeline.core;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.common.references.SharedReference;
import com.facebook.imagepipeline.debug.CloseableReferenceLeakTracker;
import java.io.Closeable;
/* loaded from: classes3.dex */
public class CloseableReferenceFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CloseableReference.LeakHandler mLeakHandler;

    public CloseableReferenceFactory(CloseableReferenceLeakTracker closeableReferenceLeakTracker) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {closeableReferenceLeakTracker};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLeakHandler = new CloseableReference.LeakHandler(this, closeableReferenceLeakTracker) { // from class: com.facebook.imagepipeline.core.CloseableReferenceFactory.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CloseableReferenceFactory this$0;
            public final /* synthetic */ CloseableReferenceLeakTracker val$closeableReferenceLeakTracker;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, closeableReferenceLeakTracker};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$closeableReferenceLeakTracker = closeableReferenceLeakTracker;
            }

            @Override // com.facebook.common.references.CloseableReference.LeakHandler
            public void reportLeak(SharedReference<Object> sharedReference) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, sharedReference) == null) {
                    this.val$closeableReferenceLeakTracker.trackCloseableReferenceLeak(sharedReference);
                    FLog.w("Fresco", "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(sharedReference)), sharedReference.get().getClass().getName());
                }
            }
        };
    }

    public <U extends Closeable> CloseableReference<U> create(U u) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, u)) == null) ? CloseableReference.of(u, this.mLeakHandler) : (CloseableReference) invokeL.objValue;
    }

    public <T> CloseableReference<T> create(T t, ResourceReleaser<T> resourceReleaser) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t, resourceReleaser)) == null) ? CloseableReference.of(t, resourceReleaser, this.mLeakHandler) : (CloseableReference) invokeLL.objValue;
    }
}
