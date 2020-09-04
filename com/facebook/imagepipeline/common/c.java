package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class c {
    private boolean nuE;
    private boolean nuF;
    private boolean nuG;
    private boolean nuH;
    @Nullable
    private com.facebook.imagepipeline.decoder.b nuI;
    private int nuD = 100;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;

    public int dSq() {
        return this.nuD;
    }

    public boolean dSr() {
        return this.nuE;
    }

    public boolean dSs() {
        return this.nuF;
    }

    public boolean dSt() {
        return this.nuG;
    }

    public c yc(boolean z) {
        this.nuH = z;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b dSu() {
        return this.nuI;
    }

    public boolean dSv() {
        return this.nuH;
    }

    public Bitmap.Config dSw() {
        return this.mBitmapConfig;
    }

    public c c(Bitmap.Config config) {
        this.mBitmapConfig = config;
        return this;
    }

    public b dSx() {
        return new b(this);
    }
}
