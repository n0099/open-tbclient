package com.facebook.imagepipeline.j;

import android.graphics.Bitmap;
import com.facebook.cache.common.b;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import javax.annotation.Nullable;
/* loaded from: classes10.dex */
public class a extends com.facebook.imagepipeline.request.a {
    private b lHf;
    private final int lUl;
    private final int lUm;

    public a(int i, int i2) {
        g.checkArgument(i > 0);
        g.checkArgument(i2 > 0);
        this.lUl = i;
        this.lUm = i2;
    }

    @Override // com.facebook.imagepipeline.request.a
    public void ac(Bitmap bitmap) {
        NativeBlurFilter.h(bitmap, this.lUl, this.lUm);
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    @Nullable
    public b dqg() {
        if (this.lHf == null) {
            this.lHf = new com.facebook.cache.common.g(String.format(null, "i%dr%d", Integer.valueOf(this.lUl), Integer.valueOf(this.lUm)));
        }
        return this.lHf;
    }
}
