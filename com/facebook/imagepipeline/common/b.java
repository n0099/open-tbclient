package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private boolean jYT;
    private boolean jYU;
    private boolean jYV;
    private boolean jYW;
    @Nullable
    private com.facebook.imagepipeline.decoder.b jYX;
    private int jYS = 100;
    private Bitmap.Config Ds = Bitmap.Config.ARGB_8888;

    public int cEG() {
        return this.jYS;
    }

    public boolean cEH() {
        return this.jYT;
    }

    public boolean cEI() {
        return this.jYU;
    }

    public boolean cEJ() {
        return this.jYV;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b cEK() {
        return this.jYX;
    }

    public boolean cEL() {
        return this.jYW;
    }

    public Bitmap.Config cEM() {
        return this.Ds;
    }

    public a cEN() {
        return new a(this);
    }
}
