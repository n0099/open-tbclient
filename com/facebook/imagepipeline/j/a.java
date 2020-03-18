package com.facebook.imagepipeline.j;

import android.graphics.Bitmap;
import com.facebook.cache.common.b;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class a extends com.facebook.imagepipeline.request.a {
    private b lJK;
    private final int lWQ;
    private final int lWR;

    public a(int i, int i2) {
        g.checkArgument(i > 0);
        g.checkArgument(i2 > 0);
        this.lWQ = i;
        this.lWR = i2;
    }

    @Override // com.facebook.imagepipeline.request.a
    public void ac(Bitmap bitmap) {
        NativeBlurFilter.h(bitmap, this.lWQ, this.lWR);
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    @Nullable
    public b drU() {
        if (this.lJK == null) {
            this.lJK = new com.facebook.cache.common.g(String.format(null, "i%dr%d", Integer.valueOf(this.lWQ), Integer.valueOf(this.lWR)));
        }
        return this.lJK;
    }
}
