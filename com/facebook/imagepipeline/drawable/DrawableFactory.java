package com.facebook.imagepipeline.drawable;

import android.graphics.drawable.Drawable;
import com.facebook.imagepipeline.image.CloseableImage;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public interface DrawableFactory {
    @Nullable
    Drawable createDrawable(CloseableImage closeableImage);

    boolean supportsImageType(CloseableImage closeableImage);
}
