package com.facebook.imagepipeline.j;

import android.graphics.Bitmap;
import com.facebook.cache.common.b;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class a extends com.facebook.imagepipeline.request.a {
    private b lIe;
    private final int lVk;
    private final int lVl;

    public a(int i, int i2) {
        g.checkArgument(i > 0);
        g.checkArgument(i2 > 0);
        this.lVk = i;
        this.lVl = i2;
    }

    @Override // com.facebook.imagepipeline.request.a
    public void ac(Bitmap bitmap) {
        NativeBlurFilter.h(bitmap, this.lVk, this.lVl);
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    @Nullable
    public b drx() {
        if (this.lIe == null) {
            this.lIe = new com.facebook.cache.common.g(String.format(null, "i%dr%d", Integer.valueOf(this.lVk), Integer.valueOf(this.lVl)));
        }
        return this.lIe;
    }
}
