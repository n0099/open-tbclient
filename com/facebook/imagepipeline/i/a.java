package com.facebook.imagepipeline.i;

import android.graphics.Bitmap;
import com.facebook.cache.common.b;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class a extends com.facebook.imagepipeline.request.a {
    private final int pDX;
    private final int pDY;
    private b psJ;

    public a(int i, int i2) {
        g.checkArgument(i > 0);
        g.checkArgument(i2 > 0);
        this.pDX = i;
        this.pDY = i2;
    }

    @Override // com.facebook.imagepipeline.request.a
    public void aj(Bitmap bitmap) {
        NativeBlurFilter.i(bitmap, this.pDX, this.pDY);
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    @Nullable
    public b eAc() {
        if (this.psJ == null) {
            this.psJ = new com.facebook.cache.common.g(String.format(null, "i%dr%d", Integer.valueOf(this.pDX), Integer.valueOf(this.pDY)));
        }
        return this.psJ;
    }
}
