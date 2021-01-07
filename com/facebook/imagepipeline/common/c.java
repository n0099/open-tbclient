package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class c {
    private boolean pCj;
    private boolean pCk;
    private boolean pCl;
    private boolean pCm;
    @Nullable
    private com.facebook.imagepipeline.decoder.b pCn;
    private int pCi = 100;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;

    public int exE() {
        return this.pCi;
    }

    public boolean exF() {
        return this.pCj;
    }

    public boolean exG() {
        return this.pCk;
    }

    public boolean exH() {
        return this.pCl;
    }

    public c Bd(boolean z) {
        this.pCm = z;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b exI() {
        return this.pCn;
    }

    public boolean exJ() {
        return this.pCm;
    }

    public Bitmap.Config exK() {
        return this.mBitmapConfig;
    }

    public c e(Bitmap.Config config) {
        this.mBitmapConfig = config;
        return this;
    }

    public b exL() {
        return new b(this);
    }
}
