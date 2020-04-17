package com.facebook.imagepipeline.j;

import android.graphics.Bitmap;
import com.facebook.cache.common.b;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class a extends com.facebook.imagepipeline.request.a {
    private b lRf;
    private final int meB;
    private final int meC;

    public a(int i, int i2) {
        g.checkArgument(i > 0);
        g.checkArgument(i2 > 0);
        this.meB = i;
        this.meC = i2;
    }

    @Override // com.facebook.imagepipeline.request.a
    public void ad(Bitmap bitmap) {
        NativeBlurFilter.h(bitmap, this.meB, this.meC);
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    @Nullable
    public b dtS() {
        if (this.lRf == null) {
            this.lRf = new com.facebook.cache.common.g(String.format(null, "i%dr%d", Integer.valueOf(this.meB), Integer.valueOf(this.meC)));
        }
        return this.lRf;
    }
}
