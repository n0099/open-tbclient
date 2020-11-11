package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class c {
    private boolean oUF;
    private boolean oUG;
    private boolean oUH;
    private boolean oUI;
    @Nullable
    private com.facebook.imagepipeline.decoder.b oUJ;
    private int oUE = 100;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;

    public int enN() {
        return this.oUE;
    }

    public boolean enO() {
        return this.oUF;
    }

    public boolean enP() {
        return this.oUG;
    }

    public boolean enQ() {
        return this.oUH;
    }

    public c Al(boolean z) {
        this.oUI = z;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b enR() {
        return this.oUJ;
    }

    public boolean enS() {
        return this.oUI;
    }

    public Bitmap.Config enT() {
        return this.mBitmapConfig;
    }

    public c c(Bitmap.Config config) {
        this.mBitmapConfig = config;
        return this;
    }

    public b enU() {
        return new b(this);
    }
}
