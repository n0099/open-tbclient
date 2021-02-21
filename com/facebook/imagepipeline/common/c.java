package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class c {
    private boolean pIr;
    private boolean pIs;
    private boolean pIt;
    private boolean pIu;
    @Nullable
    private com.facebook.imagepipeline.decoder.b pIv;
    private int pIq = 100;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;

    public int ewm() {
        return this.pIq;
    }

    public boolean ewn() {
        return this.pIr;
    }

    public boolean ewo() {
        return this.pIs;
    }

    public boolean ewp() {
        return this.pIt;
    }

    public c Bs(boolean z) {
        this.pIu = z;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b ewq() {
        return this.pIv;
    }

    public boolean ewr() {
        return this.pIu;
    }

    public Bitmap.Config ews() {
        return this.mBitmapConfig;
    }

    public c e(Bitmap.Config config) {
        this.mBitmapConfig = config;
        return this;
    }

    public b ewt() {
        return new b(this);
    }
}
