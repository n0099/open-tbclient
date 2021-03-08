package com.facebook.imagepipeline.i;

import android.graphics.Bitmap;
import com.facebook.cache.common.b;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class a extends com.facebook.imagepipeline.request.a {
    private b pBa;
    private final int pNR;
    private final int pNS;

    public a(int i, int i2) {
        g.checkArgument(i > 0);
        g.checkArgument(i2 > 0);
        this.pNR = i;
        this.pNS = i2;
    }

    @Override // com.facebook.imagepipeline.request.a
    public void ai(Bitmap bitmap) {
        NativeBlurFilter.h(bitmap, this.pNR, this.pNS);
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    @Nullable
    public b ezx() {
        if (this.pBa == null) {
            this.pBa = new com.facebook.cache.common.g(String.format(null, "i%dr%d", Integer.valueOf(this.pNR), Integer.valueOf(this.pNS)));
        }
        return this.pBa;
    }
}
