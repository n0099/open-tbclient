package com.facebook.imagepipeline.i;

import android.graphics.Bitmap;
import com.facebook.cache.common.b;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class a extends com.facebook.imagepipeline.request.a {
    private final int pFE;
    private final int pFF;
    private b psK;

    public a(int i, int i2) {
        g.checkArgument(i > 0);
        g.checkArgument(i2 > 0);
        this.pFE = i;
        this.pFF = i2;
    }

    @Override // com.facebook.imagepipeline.request.a
    public void aj(Bitmap bitmap) {
        NativeBlurFilter.i(bitmap, this.pFE, this.pFF);
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    @Nullable
    public b eAG() {
        if (this.psK == null) {
            this.psK = new com.facebook.cache.common.g(String.format(null, "i%dr%d", Integer.valueOf(this.pFE), Integer.valueOf(this.pFF)));
        }
        return this.psK;
    }
}
