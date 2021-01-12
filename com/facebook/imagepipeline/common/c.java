package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class c {
    private boolean pxI;
    private boolean pxJ;
    private boolean pxK;
    private boolean pxL;
    @Nullable
    private com.facebook.imagepipeline.decoder.b pxM;
    private int pxH = 100;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;

    public int etM() {
        return this.pxH;
    }

    public boolean etN() {
        return this.pxI;
    }

    public boolean etO() {
        return this.pxJ;
    }

    public boolean etP() {
        return this.pxK;
    }

    public c AZ(boolean z) {
        this.pxL = z;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b etQ() {
        return this.pxM;
    }

    public boolean etR() {
        return this.pxL;
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
