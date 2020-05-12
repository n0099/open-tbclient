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

    public int dqJ() {
        return this.mbj;
    }

    public boolean dqK() {
        return this.mbk;
    }

    public boolean dqL() {
        return this.mbl;
    }

    public boolean dqM() {
        return this.mbm;
    }

    public c vI(boolean z) {
        this.mbn = z;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b dqN() {
        return this.mbo;
    }

    public boolean dqO() {
        return this.mbn;
    }

    public Bitmap.Config dqP() {
        return this.mBitmapConfig;
    }

    public c c(Bitmap.Config config) {
        this.mBitmapConfig = config;
        return this;
    }

    public b dqQ() {
        return new b(this);
    }
}
