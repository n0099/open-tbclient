package com.facebook.imagepipeline.postprocessors;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.filter.InPlaceRoundFilter;
import com.facebook.imagepipeline.filter.XferRoundFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
public class RoundPostprocessor extends BasePostprocessor {
    public static final boolean ENABLE_ANTI_ALIASING = true;
    public static final boolean canUseXferRoundFilter = XferRoundFilter.canUseXferRoundFilter();
    @Nullable
    public CacheKey mCacheKey;
    public final boolean mEnableAntiAliasing;

    public RoundPostprocessor() {
        this(true);
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    @Nullable
    public CacheKey getPostprocessorCacheKey() {
        if (this.mCacheKey == null) {
            if (canUseXferRoundFilter) {
                this.mCacheKey = new SimpleCacheKey("XferRoundFilter");
            } else {
                this.mCacheKey = new SimpleCacheKey("InPlaceRoundFilter");
            }
        }
        return this.mCacheKey;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(Bitmap bitmap, Bitmap bitmap2) {
        Preconditions.checkNotNull(bitmap);
        Preconditions.checkNotNull(bitmap2);
        if (canUseXferRoundFilter) {
            XferRoundFilter.xferRoundBitmap(bitmap, bitmap2, this.mEnableAntiAliasing);
        } else {
            super.process(bitmap, bitmap2);
        }
    }

    public RoundPostprocessor(boolean z) {
        this.mEnableAntiAliasing = z;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(Bitmap bitmap) {
        InPlaceRoundFilter.roundBitmapInPlace(bitmap);
    }
}
