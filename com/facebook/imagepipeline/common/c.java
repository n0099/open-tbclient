package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c {
    private boolean mSn;
    private boolean mSo;
    private boolean mSq;
    private boolean mSr;
    @Nullable
    private com.facebook.imagepipeline.decoder.b mSs;
    private int mSm = 100;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;

    public int dCV() {
        return this.mSm;
    }

    public boolean dCW() {
        return this.mSn;
    }

    public boolean dCX() {
        return this.mSo;
    }

    public boolean dCY() {
        return this.mSq;
    }

    public c wE(boolean z) {
        this.mSr = z;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b dCZ() {
        return this.mSs;
    }

    public boolean dDa() {
        return this.mSr;
    }

    public Bitmap.Config dDb() {
        return this.mBitmapConfig;
    }

    public c c(Bitmap.Config config) {
        this.mBitmapConfig = config;
        return this;
    }

    public b dDc() {
        return new b(this);
    }
}
