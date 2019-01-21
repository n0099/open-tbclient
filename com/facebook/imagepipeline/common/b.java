package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private boolean iqU;
    private boolean iqV;
    private boolean iqW;
    private boolean iqX;
    @Nullable
    private com.facebook.imagepipeline.decoder.b iqY;
    private int iqT = 100;
    private Bitmap.Config FJ = Bitmap.Config.ARGB_8888;

    public int bXD() {
        return this.iqT;
    }

    public boolean bXE() {
        return this.iqU;
    }

    public boolean bXF() {
        return this.iqV;
    }

    public boolean bXG() {
        return this.iqW;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b bXH() {
        return this.iqY;
    }

    public boolean bXI() {
        return this.iqX;
    }

    public Bitmap.Config bXJ() {
        return this.FJ;
    }

    public a bXK() {
        return new a(this);
    }
}
