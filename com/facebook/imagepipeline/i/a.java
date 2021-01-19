package com.facebook.imagepipeline.i;

import android.graphics.Bitmap;
import com.facebook.cache.common.b;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class a extends com.facebook.imagepipeline.request.a {
    private final int pBe;
    private final int pBf;
    private b pog;

    public a(int i, int i2) {
        g.checkArgument(i > 0);
        g.checkArgument(i2 > 0);
        this.pBe = i;
        this.pBf = i2;
    }

    @Override // com.facebook.imagepipeline.request.a
    public void aj(Bitmap bitmap) {
        NativeBlurFilter.i(bitmap, this.pBe, this.pBf);
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    @Nullable
    public b ewO() {
        if (this.pog == null) {
            this.pog = new com.facebook.cache.common.g(String.format(null, "i%dr%d", Integer.valueOf(this.pBe), Integer.valueOf(this.pBf)));
        }
        return this.pog;
    }
}
