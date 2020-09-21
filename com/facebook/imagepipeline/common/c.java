package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class c {
    private boolean nEB;
    private boolean nEC;
    private boolean nED;
    private boolean nEE;
    @Nullable
    private com.facebook.imagepipeline.decoder.b nEF;
    private int nEA = 100;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;

    public int dWo() {
        return this.nEA;
    }

    public boolean dWp() {
        return this.nEB;
    }

    public boolean dWq() {
        return this.nEC;
    }

    public boolean dWr() {
        return this.nED;
    }

    public c yl(boolean z) {
        this.nEE = z;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b dWs() {
        return this.nEF;
    }

    public boolean dWt() {
        return this.nEE;
    }

    public Bitmap.Config dWu() {
        return this.mBitmapConfig;
    }

    public c c(Bitmap.Config config) {
        this.mBitmapConfig = config;
        return this;
    }

    public b dWv() {
        return new b(this);
    }
}
