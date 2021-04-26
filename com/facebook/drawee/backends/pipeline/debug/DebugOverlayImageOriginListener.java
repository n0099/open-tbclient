package com.facebook.drawee.backends.pipeline.debug;

import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
/* loaded from: classes6.dex */
public class DebugOverlayImageOriginListener implements ImageOriginListener {
    public int mImageOrigin = 1;

    public String getImageOrigin() {
        return ImageOriginUtils.toString(this.mImageOrigin);
    }

    @Override // com.facebook.drawee.backends.pipeline.info.ImageOriginListener
    public void onImageLoaded(String str, int i2, boolean z) {
        this.mImageOrigin = i2;
    }
}
