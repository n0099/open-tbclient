package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c {
    private boolean mbk;
    private boolean mbl;
    private boolean mbm;
    private boolean mbn;
    @Nullable
    private com.facebook.imagepipeline.decoder.b mbo;
    private int mbj = 100;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;

    public int dqI() {
        return this.mbj;
    }

    public boolean dqJ() {
        return this.mbk;
    }

    public boolean dqK() {
        return this.mbl;
    }

    public boolean dqL() {
        return this.mbm;
    }

    public c vI(boolean z) {
        this.mbn = z;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b dqM() {
        return this.mbo;
    }

    public boolean dqN() {
        return this.mbn;
    }

    public Bitmap.Config dqO() {
        return this.mBitmapConfig;
    }

    public c c(Bitmap.Config config) {
        this.mBitmapConfig = config;
        return this;
    }

    public b dqP() {
        return new b(this);
    }
}
