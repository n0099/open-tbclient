package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes17.dex */
public class c {
    private boolean oWi;
    private boolean oWj;
    private boolean oWk;
    private boolean oWl;
    @Nullable
    private com.facebook.imagepipeline.decoder.b oWm;
    private int oWh = 100;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;

    public int enL() {
        return this.oWh;
    }

    public boolean enM() {
        return this.oWi;
    }

    public boolean enN() {
        return this.oWj;
    }

    public boolean enO() {
        return this.oWk;
    }

    public c As(boolean z) {
        this.oWl = z;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b enP() {
        return this.oWm;
    }

    public boolean enQ() {
        return this.oWl;
    }

    public Bitmap.Config enR() {
        return this.mBitmapConfig;
    }

    public c c(Bitmap.Config config) {
        this.mBitmapConfig = config;
        return this;
    }

    public b enS() {
        return new b(this);
    }
}
