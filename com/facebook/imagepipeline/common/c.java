package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class c {
    private boolean pxJ;
    private boolean pxK;
    private boolean pxL;
    private boolean pxM;
    @Nullable
    private com.facebook.imagepipeline.decoder.b pxN;
    private int pxI = 100;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;

    public int etM() {
        return this.pxI;
    }

    public boolean etN() {
        return this.pxJ;
    }

    public boolean etO() {
        return this.pxK;
    }

    public boolean etP() {
        return this.pxL;
    }

    public c AZ(boolean z) {
        this.pxM = z;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b etQ() {
        return this.pxN;
    }

    public boolean etR() {
        return this.pxM;
    }

    public Bitmap.Config etS() {
        return this.mBitmapConfig;
    }

    public c e(Bitmap.Config config) {
        this.mBitmapConfig = config;
        return this;
    }

    public b etT() {
        return new b(this);
    }
}
