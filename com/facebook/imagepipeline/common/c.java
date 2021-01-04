package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class c {
    private boolean pAC;
    private boolean pAD;
    private boolean pAE;
    private boolean pAF;
    @Nullable
    private com.facebook.imagepipeline.decoder.b pAG;
    private int pAB = 100;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;

    public int exc() {
        return this.pAB;
    }

    public boolean exd() {
        return this.pAC;
    }

    public boolean exe() {
        return this.pAD;
    }

    public boolean exf() {
        return this.pAE;
    }

    public c Bd(boolean z) {
        this.pAF = z;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b exg() {
        return this.pAG;
    }

    public boolean exh() {
        return this.pAF;
    }

    public Bitmap.Config exi() {
        return this.mBitmapConfig;
    }

    public c e(Bitmap.Config config) {
        this.mBitmapConfig = config;
        return this;
    }

    public b exj() {
        return new b(this);
    }
}
