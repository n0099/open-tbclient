package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class c {
    @Nullable
    private com.facebook.imagepipeline.decoder.b pKA;
    private boolean pKw;
    private boolean pKx;
    private boolean pKy;
    private boolean pKz;
    private int pKv = 100;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;

    public int ewv() {
        return this.pKv;
    }

    public boolean eww() {
        return this.pKw;
    }

    public boolean ewx() {
        return this.pKx;
    }

    public boolean ewy() {
        return this.pKy;
    }

    public c Bq(boolean z) {
        this.pKz = z;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b ewz() {
        return this.pKA;
    }

    public boolean ewA() {
        return this.pKz;
    }

    public Bitmap.Config ewB() {
        return this.mBitmapConfig;
    }

    public c e(Bitmap.Config config) {
        this.mBitmapConfig = config;
        return this;
    }

    public b ewC() {
        return new b(this);
    }
}
