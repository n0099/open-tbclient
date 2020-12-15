package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class c {
    private boolean pkZ;
    private boolean pla;
    private boolean plb;
    private boolean plc;
    @Nullable
    private com.facebook.imagepipeline.decoder.b pld;
    private int pkY = 100;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;

    public int ett() {
        return this.pkY;
    }

    public boolean etu() {
        return this.pkZ;
    }

    public boolean etv() {
        return this.pla;
    }

    public boolean etw() {
        return this.plb;
    }

    public c AV(boolean z) {
        this.plc = z;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b etx() {
        return this.pld;
    }

    public boolean ety() {
        return this.plc;
    }

    public Bitmap.Config etz() {
        return this.mBitmapConfig;
    }

    public c c(Bitmap.Config config) {
        this.mBitmapConfig = config;
        return this;
    }

    public b etA() {
        return new b(this);
    }
}
