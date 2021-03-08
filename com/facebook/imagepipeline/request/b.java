package com.facebook.imagepipeline.request;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.a.f;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public interface b {
    com.facebook.common.references.a<Bitmap> a(Bitmap bitmap, f fVar);

    @Nullable
    com.facebook.cache.common.b ezx();

    String getName();
}
