package com.facebook.imagepipeline.j;

import android.graphics.Bitmap;
import com.facebook.cache.common.b;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import javax.annotation.Nullable;
/* loaded from: classes25.dex */
public class a extends com.facebook.imagepipeline.request.a {
    private final int nHY;
    private final int nHZ;
    private b nuF;

    public a(int i, int i2) {
        g.checkArgument(i > 0);
        g.checkArgument(i2 > 0);
        this.nHY = i;
        this.nHZ = i2;
    }

    @Override // com.facebook.imagepipeline.request.a
    public void ah(Bitmap bitmap) {
        NativeBlurFilter.h(bitmap, this.nHY, this.nHZ);
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    @Nullable
    public b dZu() {
        if (this.nuF == null) {
            this.nuF = new com.facebook.cache.common.g(String.format(null, "i%dr%d", Integer.valueOf(this.nHY), Integer.valueOf(this.nHZ)));
        }
        return this.nuF;
    }
}
