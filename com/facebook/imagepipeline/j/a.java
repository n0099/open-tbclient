package com.facebook.imagepipeline.j;

import android.graphics.Bitmap;
import com.facebook.cache.common.b;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class a extends com.facebook.imagepipeline.request.a {
    private b mlb;
    private final int myw;
    private final int myx;

    public a(int i, int i2) {
        g.checkArgument(i > 0);
        g.checkArgument(i2 > 0);
        this.myw = i;
        this.myx = i2;
    }

    @Override // com.facebook.imagepipeline.request.a
    public void af(Bitmap bitmap) {
        NativeBlurFilter.h(bitmap, this.myw, this.myx);
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    @Nullable
    public b dBh() {
        if (this.mlb == null) {
            this.mlb = new com.facebook.cache.common.g(String.format(null, "i%dr%d", Integer.valueOf(this.myw), Integer.valueOf(this.myx)));
        }
        return this.mlb;
    }
}
