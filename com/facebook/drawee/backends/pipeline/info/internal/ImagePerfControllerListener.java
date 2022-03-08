package com.facebook.drawee.backends.pipeline.info.internal;

import android.graphics.drawable.Animatable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.time.MonotonicClock;
import com.facebook.drawee.backends.pipeline.info.ImagePerfMonitor;
import com.facebook.drawee.backends.pipeline.info.ImagePerfState;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class ImagePerfControllerListener extends BaseControllerListener<ImageInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MonotonicClock mClock;
    public final ImagePerfMonitor mImagePerfMonitor;
    public final ImagePerfState mImagePerfState;

    public ImagePerfControllerListener(MonotonicClock monotonicClock, ImagePerfState imagePerfState, ImagePerfMonitor imagePerfMonitor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {monotonicClock, imagePerfState, imagePerfMonitor};
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
        this.mImagePerfMonitor = imagePerfMonitor;
    }

    @VisibleForTesting
    private void reportViewInvisible(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65537, this, j2) == null) {
            this.mImagePerfState.setVisible(false);
            this.mImagePerfState.setInvisibilityEventTimeMs(j2);
            this.mImagePerfMonitor.notifyListenersOfVisibilityStateUpdate(this.mImagePerfState, 2);
        }
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onFailure(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, th) == null) {
            long now = this.mClock.now();
            this.mImagePerfState.setControllerFailureTimeMs(now);
            this.mImagePerfState.setControllerId(str);
            this.mImagePerfMonitor.notifyStatusUpdated(this.mImagePerfState, 5);
            reportViewInvisible(now);
        }
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onRelease(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            super.onRelease(str);
            long now = this.mClock.now();
            int imageLoadStatus = this.mImagePerfState.getImageLoadStatus();
            if (imageLoadStatus != 3 && imageLoadStatus != 5) {
                this.mImagePerfState.setControllerCancelTimeMs(now);
                this.mImagePerfState.setControllerId(str);
                this.mImagePerfMonitor.notifyStatusUpdated(this.mImagePerfState, 4);
            }
            reportViewInvisible(now);
        }
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onSubmit(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, obj) == null) {
            long now = this.mClock.now();
            this.mImagePerfState.setControllerSubmitTimeMs(now);
            this.mImagePerfState.setControllerId(str);
            this.mImagePerfState.setCallerContext(obj);
            this.mImagePerfMonitor.notifyStatusUpdated(this.mImagePerfState, 0);
            reportViewVisible(now);
        }
    }

    @VisibleForTesting
    public void reportViewVisible(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            this.mImagePerfState.setVisible(true);
            this.mImagePerfState.setVisibilityEventTimeMs(j2);
            this.mImagePerfMonitor.notifyListenersOfVisibilityStateUpdate(this.mImagePerfState, 1);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onFinalImageSet(String str, @Nullable ImageInfo imageInfo, @Nullable Animatable animatable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, imageInfo, animatable) == null) {
            long now = this.mClock.now();
            this.mImagePerfState.setControllerFinalImageSetTimeMs(now);
            this.mImagePerfState.setImageRequestEndTimeMs(now);
            this.mImagePerfState.setControllerId(str);
            this.mImagePerfState.setImageInfo(imageInfo);
            this.mImagePerfMonitor.notifyStatusUpdated(this.mImagePerfState, 3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onIntermediateImageSet(String str, @Nullable ImageInfo imageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, imageInfo) == null) {
            this.mImagePerfState.setControllerIntermediateImageSetTimeMs(this.mClock.now());
            this.mImagePerfState.setControllerId(str);
            this.mImagePerfState.setImageInfo(imageInfo);
            this.mImagePerfMonitor.notifyStatusUpdated(this.mImagePerfState, 2);
        }
    }
}
