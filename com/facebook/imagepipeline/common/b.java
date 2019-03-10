package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private boolean jGT;
    private boolean jGU;
    private boolean jGV;
    private boolean jGW;
    @Nullable
    private com.facebook.imagepipeline.decoder.b jGX;
    private int jGS = 100;
    private Bitmap.Config FI = Bitmap.Config.ARGB_8888;

    public int cwO() {
        return this.jGS;
    }

    public boolean cwP() {
        return this.jGT;
    }

    public boolean cwQ() {
        return this.jGU;
    }

    public boolean cwR() {
        return this.jGV;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b cwS() {
        return this.jGX;
    }

    public boolean cwT() {
        return this.jGW;
    }

    public Bitmap.Config cwU() {
        return this.FI;
    }

    public a cwV() {
        return new a(this);
    }
}
