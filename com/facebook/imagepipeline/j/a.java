package com.facebook.imagepipeline.j;

import android.graphics.Bitmap;
import com.facebook.cache.common.b;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class a extends com.facebook.imagepipeline.request.a {
    private b oKK;
    private final int oYa;
    private final int oYb;

    public a(int i, int i2) {
        g.checkArgument(i > 0);
        g.checkArgument(i2 > 0);
        this.oYa = i;
        this.oYb = i2;
    }

    @Override // com.facebook.imagepipeline.request.a
    public void al(Bitmap bitmap) {
        NativeBlurFilter.h(bitmap, this.oYa, this.oYb);
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    @Nullable
    public b eqU() {
        if (this.oKK == null) {
            this.oKK = new com.facebook.cache.common.g(String.format(null, "i%dr%d", Integer.valueOf(this.oYa), Integer.valueOf(this.oYb)));
        }
        return this.oKK;
    }
}
