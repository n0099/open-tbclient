package com.facebook.imagepipeline.animated.a;

import android.content.Context;
import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes13.dex */
public interface a {
    @Nullable
    com.facebook.imagepipeline.decoder.b a(Bitmap.Config config);

    @Nullable
    com.facebook.imagepipeline.decoder.b b(Bitmap.Config config);

    @Nullable
    com.facebook.imagepipeline.f.a gl(Context context);
}
