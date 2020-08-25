package com.facebook.imagepipeline.j;

import android.graphics.Bitmap;
import com.facebook.cache.common.b;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class a extends com.facebook.imagepipeline.request.a {
    private b nkn;
    private final int nxJ;
    private final int nxK;

    public a(int i, int i2) {
        g.checkArgument(i > 0);
        g.checkArgument(i2 > 0);
        this.nxJ = i;
        this.nxK = i2;
    }

    @Override // com.facebook.imagepipeline.request.a
    public void ai(Bitmap bitmap) {
        NativeBlurFilter.h(bitmap, this.nxJ, this.nxK);
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    @Nullable
    public b dVn() {
        if (this.nkn == null) {
            this.nkn = new com.facebook.cache.common.g(String.format(null, "i%dr%d", Integer.valueOf(this.nxJ), Integer.valueOf(this.nxK)));
        }
        return this.nkn;
    }
}
