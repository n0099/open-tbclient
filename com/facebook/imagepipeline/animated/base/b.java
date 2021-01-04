package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class b {
    private final a pzl;
    @Nullable
    private com.facebook.common.references.a<Bitmap> pzm;
    @Nullable
    private List<com.facebook.common.references.a<Bitmap>> pzn;

    public a ewA() {
        return this.pzl;
    }

    public synchronized void dispose() {
        com.facebook.common.references.a.c(this.pzm);
        this.pzm = null;
        com.facebook.common.references.a.b(this.pzn);
        this.pzn = null;
    }
}
