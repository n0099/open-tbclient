package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class c {
    private boolean oLm;
    private boolean oLn;
    private boolean oLo;
    private boolean oLp;
    @Nullable
    private com.facebook.imagepipeline.decoder.b oLq;
    private int oLl = 100;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;

    public int ejX() {
        return this.oLl;
    }

    public boolean ejY() {
        return this.oLm;
    }

    public boolean ejZ() {
        return this.oLn;
    }

    public boolean eka() {
        return this.oLo;
    }

    public c Aa(boolean z) {
        this.oLp = z;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b ekb() {
        return this.oLq;
    }

    public boolean ekc() {
        return this.oLp;
    }

    public Bitmap.Config ekd() {
        return this.mBitmapConfig;
    }

    public c c(Bitmap.Config config) {
        this.mBitmapConfig = config;
        return this;
    }

    public b eke() {
        return new b(this);
    }
}
