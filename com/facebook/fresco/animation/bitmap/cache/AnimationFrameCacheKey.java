package com.facebook.fresco.animation.bitmap.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
/* loaded from: classes7.dex */
public class AnimationFrameCacheKey implements CacheKey {
    public static final String URI_PREFIX = "anim://";
    public final String mAnimationUriString;

    @Override // com.facebook.cache.common.CacheKey
    public boolean isResourceIdForDebugging() {
        return false;
    }

    public AnimationFrameCacheKey(int i) {
        this.mAnimationUriString = URI_PREFIX + i;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean containsUri(Uri uri) {
        return uri.toString().startsWith(this.mAnimationUriString);
    }

    @Override // com.facebook.cache.common.CacheKey
    public String getUriString() {
        return this.mAnimationUriString;
    }
}
