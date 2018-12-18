package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private boolean imB;
    private boolean imC;
    private boolean imD;
    private boolean imE;
    @Nullable
    private com.facebook.imagepipeline.decoder.b imF;
    private int imA = 100;
    private Bitmap.Config FJ = Bitmap.Config.ARGB_8888;

    public int bWe() {
        return this.imA;
    }

    public boolean bWf() {
        return this.imB;
    }

    public boolean bWg() {
        return this.imC;
    }

    public boolean bWh() {
        return this.imD;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b bWi() {
        return this.imF;
    }

    public boolean bWj() {
        return this.imE;
    }

    public Bitmap.Config bWk() {
        return this.FJ;
    }

    public a bWl() {
        return new a(this);
    }
}
