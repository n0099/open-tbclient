package com.facebook.imagepipeline.j;

import android.graphics.Bitmap;
import com.facebook.cache.common.b;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class a extends com.facebook.imagepipeline.request.a {
    private b lHR;
    private final int lUX;
    private final int lUY;

    public a(int i, int i2) {
        g.checkArgument(i > 0);
        g.checkArgument(i2 > 0);
        this.lUX = i;
        this.lUY = i2;
    }

    @Override // com.facebook.imagepipeline.request.a
    public void ac(Bitmap bitmap) {
        NativeBlurFilter.h(bitmap, this.lUX, this.lUY);
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    @Nullable
    public b dru() {
        if (this.lHR == null) {
            this.lHR = new com.facebook.cache.common.g(String.format(null, "i%dr%d", Integer.valueOf(this.lUX), Integer.valueOf(this.lUY)));
        }
        return this.lHR;
    }
}
