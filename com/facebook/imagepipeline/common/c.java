package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c {
    private boolean lRN;
    private boolean lRO;
    private boolean lRP;
    private boolean lRQ;
    @Nullable
    private com.facebook.imagepipeline.decoder.b lRR;
    private int lRM = 100;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;

    public int dop() {
        return this.lRM;
    }

    public c vn(boolean z) {
        this.lRN = z;
        return this;
    }

    public boolean doq() {
        return this.lRN;
    }

    public boolean dor() {
        return this.lRO;
    }

    public boolean dos() {
        return this.lRP;
    }

    public c vo(boolean z) {
        this.lRQ = z;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b dot() {
        return this.lRR;
    }

    public boolean dou() {
        return this.lRQ;
    }

    public Bitmap.Config dov() {
        return this.mBitmapConfig;
    }

    public b dow() {
        return new b(this);
    }
}
