package com.facebook.imagepipeline.request;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.b.f;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public interface a {
    com.facebook.common.references.a<Bitmap> a(Bitmap bitmap, f fVar);

    @Nullable
    com.facebook.cache.common.b dqa();

    String getName();
}
