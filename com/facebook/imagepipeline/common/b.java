package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private boolean khS;
    private boolean khT;
    private boolean khU;
    private boolean khV;
    @Nullable
    private com.facebook.imagepipeline.decoder.b khW;
    private int khR = 100;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;

    public int cFQ() {
        return this.khR;
    }

    public boolean cFR() {
        return this.khS;
    }

    public boolean cFS() {
        return this.khT;
    }

    public boolean cFT() {
        return this.khU;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b cFU() {
        return this.khW;
    }

    public boolean cFV() {
        return this.khV;
    }

    public Bitmap.Config cFW() {
        return this.mBitmapConfig;
    }

    public a cFX() {
        return new a(this);
    }
}
