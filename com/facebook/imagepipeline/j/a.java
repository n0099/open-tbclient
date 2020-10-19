package com.facebook.imagepipeline.j;

import android.graphics.Bitmap;
import com.facebook.cache.common.b;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class a extends com.facebook.imagepipeline.request.a {
    private b nJY;
    private final int nXp;
    private final int nXq;

    public a(int i, int i2) {
        g.checkArgument(i > 0);
        g.checkArgument(i2 > 0);
        this.nXp = i;
        this.nXq = i2;
    }

    @Override // com.facebook.imagepipeline.request.a
    public void ah(Bitmap bitmap) {
        NativeBlurFilter.h(bitmap, this.nXp, this.nXq);
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    @Nullable
    public b edf() {
        if (this.nJY == null) {
            this.nJY = new com.facebook.cache.common.g(String.format(null, "i%dr%d", Integer.valueOf(this.nXp), Integer.valueOf(this.nXq)));
        }
        return this.nJY;
    }
}
