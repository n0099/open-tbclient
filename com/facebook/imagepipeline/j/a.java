package com.facebook.imagepipeline.j;

import android.graphics.Bitmap;
import com.facebook.cache.common.b;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class a extends com.facebook.imagepipeline.request.a {
    private b oBr;
    private final int oOH;
    private final int oOI;

    public a(int i, int i2) {
        g.checkArgument(i > 0);
        g.checkArgument(i2 > 0);
        this.oOH = i;
        this.oOI = i2;
    }

    @Override // com.facebook.imagepipeline.request.a
    public void al(Bitmap bitmap) {
        NativeBlurFilter.h(bitmap, this.oOH, this.oOI);
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    @Nullable
    public b ene() {
        if (this.oBr == null) {
            this.oBr = new com.facebook.cache.common.g(String.format(null, "i%dr%d", Integer.valueOf(this.oOH), Integer.valueOf(this.oOI)));
        }
        return this.oBr;
    }
}
