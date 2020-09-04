package com.facebook.imagepipeline.j;

import android.graphics.Bitmap;
import com.facebook.cache.common.b;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class a extends com.facebook.imagepipeline.request.a {
    private b nkF;
    private final int nyb;
    private final int nyc;

    public a(int i, int i2) {
        g.checkArgument(i > 0);
        g.checkArgument(i2 > 0);
        this.nyb = i;
        this.nyc = i2;
    }

    @Override // com.facebook.imagepipeline.request.a
    public void ai(Bitmap bitmap) {
        NativeBlurFilter.h(bitmap, this.nyb, this.nyc);
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    @Nullable
    public b dVw() {
        if (this.nkF == null) {
            this.nkF = new com.facebook.cache.common.g(String.format(null, "i%dr%d", Integer.valueOf(this.nyb), Integer.valueOf(this.nyc)));
        }
        return this.nkF;
    }
}
