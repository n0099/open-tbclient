package com.facebook.drawee.debug.listener;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
public class ImageLoadingTimeControllerListener extends BaseControllerListener {
    @Nullable
    public ImageLoadingTimeListener mImageLoadingTimeListener;
    public long mRequestSubmitTimeMs = -1;
    public long mFinalImageSetTimeMs = -1;

    public ImageLoadingTimeControllerListener(@Nullable ImageLoadingTimeListener imageLoadingTimeListener) {
        this.mImageLoadingTimeListener = imageLoadingTimeListener;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        long currentTimeMillis = System.currentTimeMillis();
        this.mFinalImageSetTimeMs = currentTimeMillis;
        ImageLoadingTimeListener imageLoadingTimeListener = this.mImageLoadingTimeListener;
        if (imageLoadingTimeListener != null) {
            imageLoadingTimeListener.onFinalImageSet(currentTimeMillis - this.mRequestSubmitTimeMs);
        }
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onSubmit(String str, Object obj) {
        this.mRequestSubmitTimeMs = System.currentTimeMillis();
    }
}
