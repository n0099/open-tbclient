package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public interface CacheKeyFactory {
    CacheKey getBitmapCacheKey(ImageRequest imageRequest, @Nullable Object obj);

    CacheKey getEncodedCacheKey(ImageRequest imageRequest, Uri uri, @Nullable Object obj);

    CacheKey getEncodedCacheKey(ImageRequest imageRequest, @Nullable Object obj);

    CacheKey getPostprocessedBitmapCacheKey(ImageRequest imageRequest, @Nullable Object obj);
}
