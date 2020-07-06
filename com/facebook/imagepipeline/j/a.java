package com.facebook.imagepipeline.j;

import android.graphics.Bitmap;
import com.facebook.cache.common.b;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class a extends com.facebook.imagepipeline.request.a {
    private b mIl;
    private final int mVQ;
    private final int mVR;

    public a(int i, int i2) {
        g.checkArgument(i > 0);
        g.checkArgument(i2 > 0);
        this.mVQ = i;
        this.mVR = i2;
    }

    @Override // com.facebook.imagepipeline.request.a
    public void af(Bitmap bitmap) {
        NativeBlurFilter.h(bitmap, this.mVQ, this.mVR);
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    @Nullable
    public b dGb() {
        if (this.mIl == null) {
            this.mIl = new com.facebook.cache.common.g(String.format(null, "i%dr%d", Integer.valueOf(this.mVQ), Integer.valueOf(this.mVR)));
        }
        return this.mIl;
    }
}
