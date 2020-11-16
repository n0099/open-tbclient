package com.facebook.imagepipeline.j;

import android.graphics.Bitmap;
import com.facebook.cache.common.b;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class a extends com.facebook.imagepipeline.request.a {
    private b oMo;
    private final int oZD;
    private final int oZE;

    public a(int i, int i2) {
        g.checkArgument(i > 0);
        g.checkArgument(i2 > 0);
        this.oZD = i;
        this.oZE = i2;
    }

    @Override // com.facebook.imagepipeline.request.a
    public void al(Bitmap bitmap) {
        NativeBlurFilter.h(bitmap, this.oZD, this.oZE);
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    @Nullable
    public b eqS() {
        if (this.oMo == null) {
            this.oMo = new com.facebook.cache.common.g(String.format(null, "i%dr%d", Integer.valueOf(this.oZD), Integer.valueOf(this.oZE)));
        }
        return this.oMo;
    }
}
