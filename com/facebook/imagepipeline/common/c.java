package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class c {
    @Nullable
    private com.facebook.imagepipeline.decoder.b naA;
    private boolean naw;
    private boolean nax;
    private boolean nay;
    private boolean naz;
    private int nav = 100;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;

    public int dGi() {
        return this.nav;
    }

    public boolean dGj() {
        return this.naw;
    }

    public boolean dGk() {
        return this.nax;
    }

    public boolean dGl() {
        return this.nay;
    }

    public c xj(boolean z) {
        this.naz = z;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b dGm() {
        return this.naA;
    }

    public boolean dGn() {
        return this.naz;
    }

    public Bitmap.Config dGo() {
        return this.mBitmapConfig;
    }

    public c c(Bitmap.Config config) {
        this.mBitmapConfig = config;
        return this;
    }

    public b dGp() {
        return new b(this);
    }
}
