package com.facebook.imagepipeline.j;

import android.graphics.Bitmap;
import com.facebook.cache.common.b;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class a extends com.facebook.imagepipeline.request.a {
    private b mIi;
    private final int mVN;
    private final int mVO;

    public a(int i, int i2) {
        g.checkArgument(i > 0);
        g.checkArgument(i2 > 0);
        this.mVN = i;
        this.mVO = i2;
    }

    @Override // com.facebook.imagepipeline.request.a
    public void af(Bitmap bitmap) {
        NativeBlurFilter.h(bitmap, this.mVN, this.mVO);
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    @Nullable
    public b dFX() {
        if (this.mIi == null) {
            this.mIi = new com.facebook.cache.common.g(String.format(null, "i%dr%d", Integer.valueOf(this.mVN), Integer.valueOf(this.mVO)));
        }
        return this.mIi;
    }
}
