package com.facebook.imagepipeline.j;

import android.graphics.Bitmap;
import com.facebook.cache.common.b;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class a extends com.facebook.imagepipeline.request.a {
    private b lHT;
    private final int lUZ;
    private final int lVa;

    public a(int i, int i2) {
        g.checkArgument(i > 0);
        g.checkArgument(i2 > 0);
        this.lUZ = i;
        this.lVa = i2;
    }

    @Override // com.facebook.imagepipeline.request.a
    public void ac(Bitmap bitmap) {
        NativeBlurFilter.h(bitmap, this.lUZ, this.lVa);
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    @Nullable
    public b drw() {
        if (this.lHT == null) {
            this.lHT = new com.facebook.cache.common.g(String.format(null, "i%dr%d", Integer.valueOf(this.lUZ), Integer.valueOf(this.lVa)));
        }
        return this.lHT;
    }
}
