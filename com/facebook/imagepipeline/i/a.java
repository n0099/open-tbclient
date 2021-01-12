package com.facebook.imagepipeline.i;

import android.graphics.Bitmap;
import com.facebook.cache.common.b;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class a extends com.facebook.imagepipeline.request.a {
    private final int pBd;
    private final int pBe;
    private b pof;

    public a(int i, int i2) {
        g.checkArgument(i > 0);
        g.checkArgument(i2 > 0);
        this.pBd = i;
        this.pBe = i2;
    }

    @Override // com.facebook.imagepipeline.request.a
    public void aj(Bitmap bitmap) {
        NativeBlurFilter.i(bitmap, this.pBd, this.pBe);
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    @Nullable
    public b ewO() {
        if (this.pof == null) {
            this.pof = new com.facebook.cache.common.g(String.format(null, "i%dr%d", Integer.valueOf(this.pBd), Integer.valueOf(this.pBe)));
        }
        return this.pof;
    }
}
