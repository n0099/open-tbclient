package com.kwad.sdk.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public interface l {
    @Nullable
    Bitmap a();

    @Nullable
    Bitmap a(int i, int i2, Bitmap.Config config);

    void a(Bitmap bitmap);

    String b(int i, int i2, Bitmap.Config config);

    String b(Bitmap bitmap);

    int c(Bitmap bitmap);
}
