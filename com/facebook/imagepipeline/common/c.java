package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class c {
    private boolean nul;
    private boolean nun;
    private boolean nuo;
    private boolean nup;
    @Nullable
    private com.facebook.imagepipeline.decoder.b nuq;
    private int nuk = 100;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;

    public int dSh() {
        return this.nuk;
    }

    public boolean dSi() {
        return this.nul;
    }

    public boolean dSj() {
        return this.nun;
    }

    public boolean dSk() {
        return this.nuo;
    }

    public c ya(boolean z) {
        this.nup = z;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b dSl() {
        return this.nuq;
    }

    public boolean dSm() {
        return this.nup;
    }

    public Bitmap.Config dSn() {
        return this.mBitmapConfig;
    }

    public c c(Bitmap.Config config) {
        this.mBitmapConfig = config;
        return this;
    }

    public b dSo() {
        return new b(this);
    }
}
