package com.facebook.imagepipeline.j;

import android.graphics.Bitmap;
import com.facebook.cache.common.b;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import javax.annotation.Nullable;
/* loaded from: classes10.dex */
public class a extends com.facebook.imagepipeline.request.a {
    private b lHk;
    private final int lUq;
    private final int lUr;

    public a(int i, int i2) {
        g.checkArgument(i > 0);
        g.checkArgument(i2 > 0);
        this.lUq = i;
        this.lUr = i2;
    }

    @Override // com.facebook.imagepipeline.request.a
    public void ac(Bitmap bitmap) {
        NativeBlurFilter.h(bitmap, this.lUq, this.lUr);
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    @Nullable
    public b dqi() {
        if (this.lHk == null) {
            this.lHk = new com.facebook.cache.common.g(String.format(null, "i%dr%d", Integer.valueOf(this.lUq), Integer.valueOf(this.lUr)));
        }
        return this.lHk;
    }
}
