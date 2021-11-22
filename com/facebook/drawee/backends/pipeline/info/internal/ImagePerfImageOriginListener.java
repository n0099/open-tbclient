package com.facebook.drawee.backends.pipeline.info.internal;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ImagePerfMonitor;
import com.facebook.drawee.backends.pipeline.info.ImagePerfState;
/* loaded from: classes11.dex */
public class ImagePerfImageOriginListener implements ImageOriginListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ImagePerfMonitor mImagePerfMonitor;
    public final ImagePerfState mImagePerfState;

    public ImagePerfImageOriginListener(ImagePerfState imagePerfState, ImagePerfMonitor imagePerfMonitor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imagePerfState, imagePerfMonitor};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mImagePerfState = imagePerfState;
        this.mImagePerfMonitor = imagePerfMonitor;
    }

    @Override // com.facebook.drawee.backends.pipeline.info.ImageOriginListener
    public void onImageLoaded(String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.mImagePerfState.setImageOrigin(i2);
            this.mImagePerfMonitor.notifyStatusUpdated(this.mImagePerfState, 1);
        }
    }
}
