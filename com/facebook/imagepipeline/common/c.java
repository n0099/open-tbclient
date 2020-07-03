package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c {
    private boolean mSk;
    private boolean mSl;
    private boolean mSm;
    private boolean mSn;
    @Nullable
    private com.facebook.imagepipeline.decoder.b mSo;
    private int mSj = 100;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;

    public int dCR() {
        return this.mSj;
    }

    public boolean dCS() {
        return this.mSk;
    }

    public boolean dCT() {
        return this.mSl;
    }

    public boolean dCU() {
        return this.mSm;
    }

    public c wE(boolean z) {
        this.mSn = z;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b dCV() {
        return this.mSo;
    }

    public boolean dCW() {
        return this.mSn;
    }

    public Bitmap.Config dCX() {
        return this.mBitmapConfig;
    }

    public c c(Bitmap.Config config) {
        this.mBitmapConfig = config;
        return this;
    }

    public b dCY() {
        return new b(this);
    }
}
