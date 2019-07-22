package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private boolean kgd;
    private boolean kge;
    private boolean kgf;
    private boolean kgg;
    @Nullable
    private com.facebook.imagepipeline.decoder.b kgh;
    private int kgc = 100;
    private Bitmap.Config Dx = Bitmap.Config.ARGB_8888;

    public int cHK() {
        return this.kgc;
    }

    public boolean cHL() {
        return this.kgd;
    }

    public boolean cHM() {
        return this.kge;
    }

    public boolean cHN() {
        return this.kgf;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b cHO() {
        return this.kgh;
    }

    public boolean cHP() {
        return this.kgg;
    }

    public Bitmap.Config cHQ() {
        return this.Dx;
    }

    public a cHR() {
        return new a(this);
    }
}
