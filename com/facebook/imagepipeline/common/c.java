package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c {
    private boolean mvb;
    private boolean mvc;
    private boolean mvd;
    private boolean mve;
    @Nullable
    private com.facebook.imagepipeline.decoder.b mvf;
    private int mva = 100;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;

    public int dyb() {
        return this.mva;
    }

    public boolean dyc() {
        return this.mvb;
    }

    public boolean dyd() {
        return this.mvc;
    }

    public boolean dye() {
        return this.mvd;
    }

    public c wg(boolean z) {
        this.mve = z;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b dyf() {
        return this.mvf;
    }

    public boolean dyg() {
        return this.mve;
    }

    public Bitmap.Config dyh() {
        return this.mBitmapConfig;
    }

    public c c(Bitmap.Config config) {
        this.mBitmapConfig = config;
        return this;
    }

    public b dyi() {
        return new b(this);
    }
}
