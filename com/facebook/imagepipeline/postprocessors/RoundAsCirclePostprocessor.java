package com.facebook.imagepipeline.postprocessors;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.nativecode.NativeRoundingFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class RoundAsCirclePostprocessor extends BasePostprocessor {
    public static final boolean ENABLE_ANTI_ALIASING = true;
    @Nullable
    public CacheKey mCacheKey;
    public final boolean mEnableAntiAliasing;

    public RoundAsCirclePostprocessor() {
        this(true);
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    @Nullable
    public CacheKey getPostprocessorCacheKey() {
        if (this.mCacheKey == null) {
            if (this.mEnableAntiAliasing) {
                this.mCacheKey = new SimpleCacheKey("RoundAsCirclePostprocessor#AntiAliased");
            } else {
                this.mCacheKey = new SimpleCacheKey("RoundAsCirclePostprocessor");
            }
        }
        return this.mCacheKey;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(Bitmap bitmap) {
        NativeRoundingFilter.toCircle(bitmap, this.mEnableAntiAliasing);
    }

    public RoundAsCirclePostprocessor(boolean z) {
        this.mEnableAntiAliasing = z;
    }
}
