package com.facebook.imagepipeline.j;

import android.graphics.Bitmap;
import com.facebook.cache.common.b;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class a extends com.facebook.imagepipeline.request.a {
    private b mml;
    private final int mzG;
    private final int mzH;

    public a(int i, int i2) {
        g.checkArgument(i > 0);
        g.checkArgument(i2 > 0);
        this.mzG = i;
        this.mzH = i2;
    }

    @Override // com.facebook.imagepipeline.request.a
    public void af(Bitmap bitmap) {
        NativeBlurFilter.h(bitmap, this.mzG, this.mzH);
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    @Nullable
    public b dBv() {
        if (this.mml == null) {
            this.mml = new com.facebook.cache.common.g(String.format(null, "i%dr%d", Integer.valueOf(this.mzG), Integer.valueOf(this.mzH)));
        }
        return this.mml;
    }
}
