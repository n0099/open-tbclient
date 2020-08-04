package com.facebook.imagepipeline.j;

import android.graphics.Bitmap;
import com.facebook.cache.common.b;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class a extends com.facebook.imagepipeline.request.a {
    private b mQs;
    private final int ndT;
    private final int ndU;

    public a(int i, int i2) {
        g.checkArgument(i > 0);
        g.checkArgument(i2 > 0);
        this.ndT = i;
        this.ndU = i2;
    }

    @Override // com.facebook.imagepipeline.request.a
    public void ai(Bitmap bitmap) {
        NativeBlurFilter.h(bitmap, this.ndT, this.ndU);
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    @Nullable
    public b dJo() {
        if (this.mQs == null) {
            this.mQs = new com.facebook.cache.common.g(String.format(null, "i%dr%d", Integer.valueOf(this.ndT), Integer.valueOf(this.ndU)));
        }
        return this.mQs;
    }
}
