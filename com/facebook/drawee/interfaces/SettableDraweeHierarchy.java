package com.facebook.drawee.interfaces;

import android.graphics.drawable.Drawable;
/* loaded from: classes7.dex */
public interface SettableDraweeHierarchy extends DraweeHierarchy {
    void reset();

    void setControllerOverlay(Drawable drawable);

    void setFailure(Throwable th);

    void setImage(Drawable drawable, float f, boolean z);

    void setProgress(float f, boolean z);

    void setRetry(Throwable th);
}
