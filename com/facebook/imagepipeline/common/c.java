package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class c {
    private boolean nau;
    private boolean nav;
    private boolean naw;
    private boolean nax;
    @Nullable
    private com.facebook.imagepipeline.decoder.b nay;
    private int nat = 100;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;

    public int dGh() {
        return this.nat;
    }

    public boolean dGi() {
        return this.nau;
    }

    public boolean dGj() {
        return this.nav;
    }

    public boolean dGk() {
        return this.naw;
    }

    public c xj(boolean z) {
        this.nax = z;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b dGl() {
        return this.nay;
    }

    public boolean dGm() {
        return this.nax;
    }

    public Bitmap.Config dGn() {
        return this.mBitmapConfig;
    }

    public c c(Bitmap.Config config) {
        this.mBitmapConfig = config;
        return this;
    }

    public b dGo() {
        return new b(this);
    }
}
