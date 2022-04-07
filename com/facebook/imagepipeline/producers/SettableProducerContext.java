package com.facebook.imagepipeline.producers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes4.dex */
public class SettableProducerContext extends BaseProducerContext {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SettableProducerContext(ProducerContext producerContext) {
        this(producerContext.getImageRequest(), producerContext.getId(), producerContext.getListener(), producerContext.getCallerContext(), producerContext.getLowestPermittedRequestLevel(), producerContext.isPrefetch(), producerContext.isIntermediateResultExpected(), producerContext.getPriority());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {producerContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((ImageRequest) objArr2[0], (String) objArr2[1], (ProducerListener) objArr2[2], objArr2[3], (ImageRequest.RequestLevel) objArr2[4], ((Boolean) objArr2[5]).booleanValue(), ((Boolean) objArr2[6]).booleanValue(), (Priority) objArr2[7]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void setIsIntermediateResultExpected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            BaseProducerContext.callOnIsIntermediateResultExpectedChanged(setIsIntermediateResultExpectedNoCallbacks(z));
        }
    }

    public void setIsPrefetch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            BaseProducerContext.callOnIsPrefetchChanged(setIsPrefetchNoCallbacks(z));
        }
    }

    public void setPriority(Priority priority) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, priority) == null) {
            BaseProducerContext.callOnPriorityChanged(setPriorityNoCallbacks(priority));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SettableProducerContext(ImageRequest imageRequest, ProducerContext producerContext) {
        this(imageRequest, producerContext.getId(), producerContext.getListener(), producerContext.getCallerContext(), producerContext.getLowestPermittedRequestLevel(), producerContext.isPrefetch(), producerContext.isIntermediateResultExpected(), producerContext.getPriority());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageRequest, producerContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((ImageRequest) objArr2[0], (String) objArr2[1], (ProducerListener) objArr2[2], objArr2[3], (ImageRequest.RequestLevel) objArr2[4], ((Boolean) objArr2[5]).booleanValue(), ((Boolean) objArr2[6]).booleanValue(), (Priority) objArr2[7]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettableProducerContext(ImageRequest imageRequest, String str, ProducerListener producerListener, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        super(imageRequest, str, producerListener, obj, requestLevel, z, z2, priority);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageRequest, str, producerListener, obj, requestLevel, Boolean.valueOf(z), Boolean.valueOf(z2), priority};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ImageRequest) objArr2[0], (String) objArr2[1], (ProducerListener) objArr2[2], objArr2[3], (ImageRequest.RequestLevel) objArr2[4], ((Boolean) objArr2[5]).booleanValue(), ((Boolean) objArr2[6]).booleanValue(), (Priority) objArr2[7]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }
}
