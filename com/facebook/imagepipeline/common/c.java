package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c {
    private boolean lTt;
    private boolean lTu;
    private boolean lTv;
    private boolean lTw;
    @Nullable
    private com.facebook.imagepipeline.decoder.b lTx;
    private int lTs = 100;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;

    public int doM() {
        return this.lTs;
    }

    public c vu(boolean z) {
        this.lTt = z;
        return this;
    }

    public boolean doN() {
        return this.lTt;
    }

    public boolean doO() {
        return this.lTu;
    }

    public boolean doP() {
        return this.lTv;
    }

    public c vv(boolean z) {
        this.lTw = z;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b doQ() {
        return this.lTx;
    }

    public boolean doR() {
        return this.lTw;
    }

    public Bitmap.Config doS() {
        return this.mBitmapConfig;
    }

    public b doT() {
        return new b(this);
    }
}
