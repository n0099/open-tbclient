package com.facebook.imagepipeline.producers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.listener.RequestListener2;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class InternalRequestListener extends InternalProducerListener implements RequestListener2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final RequestListener mRequestListener;
    @Nullable
    public final RequestListener2 mRequestListener2;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InternalRequestListener(@Nullable RequestListener requestListener, @Nullable RequestListener2 requestListener2) {
        super(requestListener, requestListener2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {requestListener, requestListener2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ProducerListener) objArr2[0], (ProducerListener2) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRequestListener = requestListener;
        this.mRequestListener2 = requestListener2;
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestCancellation(ProducerContext producerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, producerContext) == null) {
            RequestListener requestListener = this.mRequestListener;
            if (requestListener != null) {
                requestListener.onRequestCancellation(producerContext.getId());
            }
            RequestListener2 requestListener2 = this.mRequestListener2;
            if (requestListener2 != null) {
                requestListener2.onRequestCancellation(producerContext);
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestStart(ProducerContext producerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, producerContext) == null) {
            RequestListener requestListener = this.mRequestListener;
            if (requestListener != null) {
                requestListener.onRequestStart(producerContext.getImageRequest(), producerContext.getCallerContext(), producerContext.getId(), producerContext.isPrefetch());
            }
            RequestListener2 requestListener2 = this.mRequestListener2;
            if (requestListener2 != null) {
                requestListener2.onRequestStart(producerContext);
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestSuccess(ProducerContext producerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, producerContext) == null) {
            RequestListener requestListener = this.mRequestListener;
            if (requestListener != null) {
                requestListener.onRequestSuccess(producerContext.getImageRequest(), producerContext.getId(), producerContext.isPrefetch());
            }
            RequestListener2 requestListener2 = this.mRequestListener2;
            if (requestListener2 != null) {
                requestListener2.onRequestSuccess(producerContext);
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestFailure(ProducerContext producerContext, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, producerContext, th) == null) {
            RequestListener requestListener = this.mRequestListener;
            if (requestListener != null) {
                requestListener.onRequestFailure(producerContext.getImageRequest(), producerContext.getId(), th, producerContext.isPrefetch());
            }
            RequestListener2 requestListener2 = this.mRequestListener2;
            if (requestListener2 != null) {
                requestListener2.onRequestFailure(producerContext, th);
            }
        }
    }
}
