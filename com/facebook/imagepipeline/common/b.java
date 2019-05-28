package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private boolean jYU;
    private boolean jYV;
    private boolean jYW;
    private boolean jYX;
    @Nullable
    private com.facebook.imagepipeline.decoder.b jYY;
    private int jYT = 100;
    private Bitmap.Config Ds = Bitmap.Config.ARGB_8888;

    public int cEI() {
        return this.jYT;
    }

    public boolean cEJ() {
        return this.jYU;
    }

    public boolean cEK() {
        return this.jYV;
    }

    public boolean cEL() {
        return this.jYW;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b cEM() {
        return this.jYY;
    }

    public boolean cEN() {
        return this.jYX;
    }

    public Bitmap.Config cEO() {
        return this.Ds;
    }

    public a cEP() {
        return new a(this);
    }
}
