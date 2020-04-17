package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c {
    private boolean mbg;
    private boolean mbh;
    private boolean mbi;
    private boolean mbj;
    @Nullable
    private com.facebook.imagepipeline.decoder.b mbk;
    private int mbf = 100;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;

    public int dqL() {
        return this.mbf;
    }

    public boolean dqM() {
        return this.mbg;
    }

    public boolean dqN() {
        return this.mbh;
    }

    public boolean dqO() {
        return this.mbi;
    }

    public c vI(boolean z) {
        this.mbj = z;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b dqP() {
        return this.mbk;
    }

    public boolean dqQ() {
        return this.mbj;
    }

    public Bitmap.Config dqR() {
        return this.mBitmapConfig;
    }

    public c c(Bitmap.Config config) {
        this.mBitmapConfig = config;
        return this;
    }

    public b dqS() {
        return new b(this);
    }
}
