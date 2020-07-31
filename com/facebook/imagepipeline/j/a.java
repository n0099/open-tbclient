package com.facebook.imagepipeline.j;

import android.graphics.Bitmap;
import com.facebook.cache.common.b;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class a extends com.facebook.imagepipeline.request.a {
    private b mQq;
    private final int ndR;
    private final int ndS;

    public a(int i, int i2) {
        g.checkArgument(i > 0);
        g.checkArgument(i2 > 0);
        this.ndR = i;
        this.ndS = i2;
    }

    @Override // com.facebook.imagepipeline.request.a
    public void ai(Bitmap bitmap) {
        NativeBlurFilter.h(bitmap, this.ndR, this.ndS);
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    @Nullable
    public b dJn() {
        if (this.mQq == null) {
            this.mQq = new com.facebook.cache.common.g(String.format(null, "i%dr%d", Integer.valueOf(this.ndR), Integer.valueOf(this.ndS)));
        }
        return this.mQq;
    }
}
