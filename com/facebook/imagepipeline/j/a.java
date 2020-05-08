package com.facebook.imagepipeline.j;

import android.graphics.Bitmap;
import com.facebook.cache.common.b;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class a extends com.facebook.imagepipeline.request.a {
    private b lRj;
    private final int meF;
    private final int meG;

    public a(int i, int i2) {
        g.checkArgument(i > 0);
        g.checkArgument(i2 > 0);
        this.meF = i;
        this.meG = i2;
    }

    @Override // com.facebook.imagepipeline.request.a
    public void ad(Bitmap bitmap) {
        NativeBlurFilter.h(bitmap, this.meF, this.meG);
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    @Nullable
    public b dtP() {
        if (this.lRj == null) {
            this.lRj = new com.facebook.cache.common.g(String.format(null, "i%dr%d", Integer.valueOf(this.meF), Integer.valueOf(this.meG)));
        }
        return this.lRj;
    }
}
