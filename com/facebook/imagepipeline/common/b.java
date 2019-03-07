package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private boolean jGA;
    private boolean jGB;
    private boolean jGC;
    private boolean jGD;
    @Nullable
    private com.facebook.imagepipeline.decoder.b jGE;
    private int jGz = 100;
    private Bitmap.Config FI = Bitmap.Config.ARGB_8888;

    public int cwE() {
        return this.jGz;
    }

    public boolean cwF() {
        return this.jGA;
    }

    public boolean cwG() {
        return this.jGB;
    }

    public boolean cwH() {
        return this.jGC;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b cwI() {
        return this.jGE;
    }

    public boolean cwJ() {
        return this.jGD;
    }

    public Bitmap.Config cwK() {
        return this.FI;
    }

    public a cwL() {
        return new a(this);
    }
}
