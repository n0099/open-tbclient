package com.facebook.drawee.debug.listener;

import android.graphics.drawable.Animatable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.controller.BaseControllerListener;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class ImageLoadingTimeControllerListener extends BaseControllerListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long mFinalImageSetTimeMs;
    @Nullable
    public ImageLoadingTimeListener mImageLoadingTimeListener;
    public long mRequestSubmitTimeMs;

    public ImageLoadingTimeControllerListener(@Nullable ImageLoadingTimeListener imageLoadingTimeListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageLoadingTimeListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRequestSubmitTimeMs = -1L;
        this.mFinalImageSetTimeMs = -1L;
        this.mImageLoadingTimeListener = imageLoadingTimeListener;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, obj, animatable) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.mFinalImageSetTimeMs = currentTimeMillis;
            ImageLoadingTimeListener imageLoadingTimeListener = this.mImageLoadingTimeListener;
            if (imageLoadingTimeListener != null) {
                imageLoadingTimeListener.onFinalImageSet(currentTimeMillis - this.mRequestSubmitTimeMs);
            }
        }
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onSubmit(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj) == null) {
            this.mRequestSubmitTimeMs = System.currentTimeMillis();
        }
    }
}
