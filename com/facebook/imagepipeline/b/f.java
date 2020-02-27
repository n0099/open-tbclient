package com.facebook.imagepipeline.b;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public abstract class f {
    public abstract com.facebook.common.references.a<Bitmap> c(int i, int i2, Bitmap.Config config);

    public com.facebook.common.references.a<Bitmap> b(int i, int i2, Bitmap.Config config) {
        return a(i, i2, config, null);
    }

    public com.facebook.common.references.a<Bitmap> a(int i, int i2, Bitmap.Config config, @Nullable Object obj) {
        return c(i, i2, config);
    }
}
