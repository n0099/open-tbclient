package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class c {
    private boolean lNc;
    private boolean lNd;
    private boolean lNe;
    private boolean lNf;
    @Nullable
    private com.facebook.imagepipeline.decoder.b lNg;
    private int lNb = 100;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;

    public int dlS() {
        return this.lNb;
    }

    public c uX(boolean z) {
        this.lNc = z;
        return this;
    }

    public boolean dlT() {
        return this.lNc;
    }

    public boolean dlU() {
        return this.lNd;
    }

    public boolean dlV() {
        return this.lNe;
    }

    public c uY(boolean z) {
        this.lNf = z;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b dlW() {
        return this.lNg;
    }

    public boolean dlX() {
        return this.lNf;
    }

    public Bitmap.Config dlY() {
        return this.mBitmapConfig;
    }

    public b dlZ() {
        return new b(this);
    }
}
