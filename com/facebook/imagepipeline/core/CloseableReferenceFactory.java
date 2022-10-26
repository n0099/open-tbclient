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
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$closeableReferenceLeakTracker = closeableReferenceLeakTracker;
            }

            @Override // com.facebook.common.references.CloseableReference.LeakHandler
            public void reportLeak(SharedReference sharedReference, @Nullable Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, sharedReference, th) == null) {
                    this.val$closeableReferenceLeakTracker.trackCloseableReferenceLeak(sharedReference, th);
                    FLog.w("Fresco", "Finalized without closing: %x %x (type = %s).\nStack:\n%s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(sharedReference)), sharedReference.get().getClass().getName(), CloseableReferenceFactory.getStackTraceString(th));
                }
            }

            @Override // com.facebook.common.references.CloseableReference.LeakHandler
            public boolean requiresStacktrace() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return this.val$closeableReferenceLeakTracker.isSet();
                }
                return invokeV.booleanValue;
            }
        };
    }

    public static String getStackTraceString(@Nullable Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, th)) == null) {
            if (th == null) {
                return "";
            }
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.toString();
        }
        return (String) invokeL.objValue;
    }

    public CloseableReference create(Closeable closeable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, closeable)) == null) {
            return CloseableReference.of(closeable, this.mLeakHandler);
        }
        return (CloseableReference) invokeL.objValue;
    }

    public CloseableReference create(Object obj, ResourceReleaser resourceReleaser) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, resourceReleaser)) == null) {
            return CloseableReference.of(obj, resourceReleaser, this.mLeakHandler);
        }
        return (CloseableReference) invokeLL.objValue;
    }
}
