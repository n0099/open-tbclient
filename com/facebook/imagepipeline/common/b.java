package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private boolean jGL;
    private boolean jGM;
    private boolean jGN;
    private boolean jGO;
    @Nullable
    private com.facebook.imagepipeline.decoder.b jGP;
    private int jGK = 100;
    private Bitmap.Config FI = Bitmap.Config.ARGB_8888;

    public int cwR() {
        return this.jGK;
    }

    public boolean cwS() {
        return this.jGL;
    }

    public boolean cwT() {
        return this.jGM;
    }

    public boolean cwU() {
        return this.jGN;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b cwV() {
        return this.jGP;
    }

    public boolean cwW() {
        return this.jGO;
    }

    public Bitmap.Config cwX() {
        return this.FI;
    }

    public a cwY() {
        return new a(this);
    }
}
