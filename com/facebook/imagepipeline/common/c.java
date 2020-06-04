package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c {
    private boolean mwl;
    private boolean mwm;
    private boolean mwn;
    private boolean mwo;
    @Nullable
    private com.facebook.imagepipeline.decoder.b mwp;
    private int mwk = 100;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;

    public int dyp() {
        return this.mwk;
    }

    public boolean dyq() {
        return this.mwl;
    }

    public boolean dyr() {
        return this.mwm;
    }

    public boolean dys() {
        return this.mwn;
    }

    public c wi(boolean z) {
        this.mwo = z;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b dyt() {
        return this.mwp;
    }

    public boolean dyu() {
        return this.mwo;
    }

    public Bitmap.Config dyv() {
        return this.mBitmapConfig;
    }

    public c c(Bitmap.Config config) {
        this.mBitmapConfig = config;
        return this;
    }

    public b dyw() {
        return new b(this);
    }
}
