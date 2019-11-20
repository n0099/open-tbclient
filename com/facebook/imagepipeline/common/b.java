package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private boolean khb;
    private boolean khc;
    private boolean khd;
    private boolean khe;
    @Nullable
    private com.facebook.imagepipeline.decoder.b khf;
    private int kha = 100;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;

    public int cFO() {
        return this.kha;
    }

    public boolean cFP() {
        return this.khb;
    }

    public boolean cFQ() {
        return this.khc;
    }

    public boolean cFR() {
        return this.khd;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b cFS() {
        return this.khf;
    }

    public boolean cFT() {
        return this.khe;
    }

    public Bitmap.Config cFU() {
        return this.mBitmapConfig;
    }

    public a cFV() {
        return new a(this);
    }
}
