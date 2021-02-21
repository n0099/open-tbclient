package com.facebook.imagepipeline.i;

import android.graphics.Bitmap;
import com.facebook.cache.common.b;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class a extends com.facebook.imagepipeline.request.a {
    private final int pLM;
    private final int pLN;
    private b pyV;

    public a(int i, int i2) {
        g.checkArgument(i > 0);
        g.checkArgument(i2 > 0);
        this.pLM = i;
        this.pLN = i2;
    }

    @Override // com.facebook.imagepipeline.request.a
    public void ai(Bitmap bitmap) {
        NativeBlurFilter.i(bitmap, this.pLM, this.pLN);
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    @Nullable
    public b ezo() {
        if (this.pyV == null) {
            this.pyV = new com.facebook.cache.common.g(String.format(null, "i%dr%d", Integer.valueOf(this.pLM), Integer.valueOf(this.pLN)));
        }
        return this.pyV;
    }
}
