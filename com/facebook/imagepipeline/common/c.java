package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c {
    private boolean lRA;
    private boolean lRB;
    private boolean lRC;
    private boolean lRD;
    @Nullable
    private com.facebook.imagepipeline.decoder.b lRE;
    private int lRz = 100;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;

    public int dom() {
        return this.lRz;
    }

    public c vn(boolean z) {
        this.lRA = z;
        return this;
    }

    public boolean don() {
        return this.lRA;
    }

    public boolean doo() {
        return this.lRB;
    }

    public boolean dop() {
        return this.lRC;
    }

    public c vo(boolean z) {
        this.lRD = z;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b doq() {
        return this.lRE;
    }

    public boolean dor() {
        return this.lRD;
    }

    public Bitmap.Config dos() {
        return this.mBitmapConfig;
    }

    public b dot() {
        return new b(this);
    }
}
