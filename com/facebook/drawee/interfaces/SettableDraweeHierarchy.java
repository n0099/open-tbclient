package com.facebook.drawee.interfaces;

import android.graphics.drawable.Drawable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes3.dex */
public interface SettableDraweeHierarchy extends DraweeHierarchy {
    void reset();

    void setControllerOverlay(Drawable drawable);

    void setFailure(Throwable th);

    void setImage(Drawable drawable, float f2, boolean z);

    void setProgress(float f2, boolean z);

    void setRetry(Throwable th);
}
