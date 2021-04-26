package com.facebook.imagepipeline.postprocessors;

import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.filter.IterativeBoxBlurFilter;
import com.facebook.imagepipeline.filter.RenderScriptBlurFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class BlurPostProcessor extends BasePostprocessor {
    public static final int DEFAULT_ITERATIONS = 3;
    public static final boolean canUseRenderScript = RenderScriptBlurFilter.canUseRenderScript();
    public final int mBlurRadius;
    public CacheKey mCacheKey;
    public final Context mContext;
    public final int mIterations;

    public BlurPostProcessor(int i2, Context context, int i3) {
        Preconditions.checkArgument(i2 > 0 && i2 <= 25);
        Preconditions.checkArgument(i3 > 0);
        Preconditions.checkNotNull(context);
        this.mIterations = i3;
        this.mBlurRadius = i2;
        this.mContext = context;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    @Nullable
    public CacheKey getPostprocessorCacheKey() {
        if (this.mCacheKey == null) {
            this.mCacheKey = new SimpleCacheKey(canUseRenderScript ? String.format(null, "IntrinsicBlur;%d", Integer.valueOf(this.mBlurRadius)) : String.format(null, "IterativeBoxBlur;%d;%d", Integer.valueOf(this.mIterations), Integer.valueOf(this.mBlurRadius)));
        }
        return this.mCacheKey;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(Bitmap bitmap, Bitmap bitmap2) {
        if (canUseRenderScript) {
            RenderScriptBlurFilter.blurBitmap(bitmap, bitmap2, this.mContext, this.mBlurRadius);
        } else {
            super.process(bitmap, bitmap2);
        }
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(Bitmap bitmap) {
        IterativeBoxBlurFilter.boxBlurBitmapInPlace(bitmap, this.mIterations, this.mBlurRadius);
    }

    public BlurPostProcessor(int i2, Context context) {
        this(i2, context, 3);
    }
}
