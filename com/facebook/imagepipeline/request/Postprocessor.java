package com.facebook.imagepipeline.request;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public interface Postprocessor {
    String getName();

    @Nullable
    CacheKey getPostprocessorCacheKey();

    CloseableReference process(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory);
}
