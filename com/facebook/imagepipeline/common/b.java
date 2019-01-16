package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private boolean iqT;
    private boolean iqU;
    private boolean iqV;
    private boolean iqW;
    @Nullable
    private com.facebook.imagepipeline.decoder.b iqX;
    private int iqS = 100;
    private Bitmap.Config FJ = Bitmap.Config.ARGB_8888;

    public int bXD() {
        return this.iqS;
    }

    public boolean bXE() {
        return this.iqT;
    }

    public boolean bXF() {
        return this.iqU;
    }

    public boolean bXG() {
        return this.iqV;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b bXH() {
        return this.iqX;
    }

    public boolean bXI() {
        return this.iqW;
    }

    public Bitmap.Config bXJ() {
        return this.FJ;
    }

    public a bXK() {
        return new a(this);
    }
}
