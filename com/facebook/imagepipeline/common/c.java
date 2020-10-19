package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class c {
    private boolean nTU;
    private boolean nTV;
    private boolean nTW;
    private boolean nTX;
    @Nullable
    private com.facebook.imagepipeline.decoder.b nTY;
    private int nTT = 100;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;

    public int dZZ() {
        return this.nTT;
    }

    public boolean eaa() {
        return this.nTU;
    }

    public boolean eab() {
        return this.nTV;
    }

    public boolean eac() {
        return this.nTW;
    }

    public c yS(boolean z) {
        this.nTX = z;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b ead() {
        return this.nTY;
    }

    public boolean eae() {
        return this.nTX;
    }

    public Bitmap.Config eaf() {
        return this.mBitmapConfig;
    }

    public c c(Bitmap.Config config) {
        this.mBitmapConfig = config;
        return this;
    }

    public b eag() {
        return new b(this);
    }
}
