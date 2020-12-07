package com.facebook.imagepipeline.i;

import android.graphics.Bitmap;
import com.facebook.cache.common.b;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class a extends com.facebook.imagepipeline.request.a {
    private b pbw;
    private final int pov;
    private final int pow;

    public a(int i, int i2) {
        g.checkArgument(i > 0);
        g.checkArgument(i2 > 0);
        this.pov = i;
        this.pow = i2;
    }

    @Override // com.facebook.imagepipeline.request.a
    public void al(Bitmap bitmap) {
        NativeBlurFilter.h(bitmap, this.pov, this.pow);
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    @Nullable
    public b ewu() {
        if (this.pbw == null) {
            this.pbw = new com.facebook.cache.common.g(String.format(null, "i%dr%d", Integer.valueOf(this.pov), Integer.valueOf(this.pow)));
        }
        return this.pbw;
    }
}
