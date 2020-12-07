package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class c {
    private boolean pkX;
    private boolean pkY;
    private boolean pkZ;
    private boolean pla;
    @Nullable
    private com.facebook.imagepipeline.decoder.b plb;
    private int pkW = 100;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;

    public int ets() {
        return this.pkW;
    }

    public boolean ett() {
        return this.pkX;
    }

    public boolean etu() {
        return this.pkY;
    }

    public boolean etv() {
        return this.pkZ;
    }

    public c AV(boolean z) {
        this.pla = z;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b etw() {
        return this.plb;
    }

    public boolean etx() {
        return this.pla;
    }

    public Bitmap.Config ety() {
        return this.mBitmapConfig;
    }

    public c c(Bitmap.Config config) {
        this.mBitmapConfig = config;
        return this;
    }

    public b etz() {
        return new b(this);
    }
}
