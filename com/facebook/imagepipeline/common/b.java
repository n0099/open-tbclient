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

    public int bWf() {
        return this.imA;
    }

    public boolean bWg() {
        return this.imB;
    }

    public boolean bWh() {
        return this.imC;
    }

    public boolean bWi() {
        return this.imD;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b bWj() {
        return this.imF;
    }

    public boolean bWk() {
        return this.imE;
    }

    public Bitmap.Config bWl() {
        return this.FJ;
    }

    public a bWm() {
        return new a(this);
    }
}
