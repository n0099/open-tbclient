package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class c {
    private boolean pHR;
    private boolean pHS;
    private boolean pHT;
    private boolean pHU;
    @Nullable
    private com.facebook.imagepipeline.decoder.b pHV;
    private int pHQ = 100;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;

    public int ewe() {
        return this.pHQ;
    }

    public boolean ewf() {
        return this.pHR;
    }

    public boolean ewg() {
        return this.pHS;
    }

    public boolean ewh() {
        return this.pHT;
    }

    public c Bs(boolean z) {
        this.pHU = z;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b ewi() {
        return this.pHV;
    }

    public boolean ewj() {
        return this.pHU;
    }

    public Bitmap.Config ewk() {
        return this.mBitmapConfig;
    }

    public c e(Bitmap.Config config) {
        this.mBitmapConfig = config;
        return this;
    }

    public b ewl() {
        return new b(this);
    }
}
