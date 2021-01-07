package com.facebook.imagepipeline.a;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public abstract class f {
    public abstract com.facebook.common.references.a<Bitmap> g(int i, int i2, Bitmap.Config config);

    public com.facebook.common.references.a<Bitmap> f(int i, int i2, Bitmap.Config config) {
        return a(i, i2, config, null);
    }

    public com.facebook.common.references.a<Bitmap> a(int i, int i2, Bitmap.Config config, @Nullable Object obj) {
        return g(i, i2, config);
    }
}
