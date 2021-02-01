package com.facebook.imagepipeline.i;

import android.graphics.Bitmap;
import com.facebook.cache.common.b;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class a extends com.facebook.imagepipeline.request.a {
    private final int pLm;
    private final int pLn;
    private b pyv;

    public a(int i, int i2) {
        g.checkArgument(i > 0);
        g.checkArgument(i2 > 0);
        this.pLm = i;
        this.pLn = i2;
    }

    @Override // com.facebook.imagepipeline.request.a
    public void ai(Bitmap bitmap) {
        NativeBlurFilter.i(bitmap, this.pLm, this.pLn);
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    @Nullable
    public b ezg() {
        if (this.pyv == null) {
            this.pyv = new com.facebook.cache.common.g(String.format(null, "i%dr%d", Integer.valueOf(this.pLm), Integer.valueOf(this.pLn)));
        }
        return this.pyv;
    }
}
