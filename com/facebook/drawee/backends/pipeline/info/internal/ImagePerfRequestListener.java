package com.facebook.drawee.backends.pipeline.info.internal;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.time.MonotonicClock;
import com.facebook.drawee.backends.pipeline.info.ImagePerfState;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class ImagePerfRequestListener extends BaseRequestListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MonotonicClock mClock;
    public final ImagePerfState mImagePerfState;

    public ImagePerfRequestListener(MonotonicClock monotonicClock, ImagePerfState imagePerfState) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {monotonicClock, imagePerfState};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mClock = monotonicClock;
        this.mImagePerfState = imagePerfState;
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public void onRequestCancellation(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.mImagePerfState.setImageRequestEndTimeMs(this.mClock.now());
            this.mImagePerfState.setRequestId(str);
        }
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public void onRequestFailure(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imageRequest, str, th, Boolean.valueOf(z)}) == null) {
            this.mImagePerfState.setImageRequestEndTimeMs(this.mClock.now());
            this.mImagePerfState.setImageRequest(imageRequest);
            this.mImagePerfState.setRequestId(str);
            this.mImagePerfState.setPrefetch(z);
        }
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public void onRequestStart(ImageRequest imageRequest, Object obj, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{imageRequest, obj, str, Boolean.valueOf(z)}) == null) {
            this.mImagePerfState.setImageRequestStartTimeMs(this.mClock.now());
            this.mImagePerfState.setImageRequest(imageRequest);
            this.mImagePerfState.setCallerContext(obj);
            this.mImagePerfState.setRequestId(str);
            this.mImagePerfState.setPrefetch(z);
        }
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public void onRequestSuccess(ImageRequest imageRequest, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, imageRequest, str, z) == null) {
            this.mImagePerfState.setImageRequestEndTimeMs(this.mClock.now());
            this.mImagePerfState.setImageRequest(imageRequest);
            this.mImagePerfState.setRequestId(str);
            this.mImagePerfState.setPrefetch(z);
        }
    }
}
