package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c {
    private boolean lRC;
    private boolean lRD;
    private boolean lRE;
    private boolean lRF;
    @Nullable
    private com.facebook.imagepipeline.decoder.b lRG;
    private int lRB = 100;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;

    public int doo() {
        return this.lRB;
    }

    public c vn(boolean z) {
        this.lRC = z;
        return this;
    }

    public boolean dop() {
        return this.lRC;
    }

    public boolean doq() {
        return this.lRD;
    }

    public boolean dor() {
        return this.lRE;
    }

    public c vo(boolean z) {
        this.lRF = z;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b dos() {
        return this.lRG;
    }

    public boolean dot() {
        return this.lRF;
    }

    public Bitmap.Config dou() {
        return this.mBitmapConfig;
    }

    public b dov() {
        return new b(this);
    }
}
