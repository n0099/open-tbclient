package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public interface f {
    com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj);

    com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj);

    com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj);

    com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj);
}
