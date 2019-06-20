package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private boolean jYX;
    private boolean jYY;
    private boolean jYZ;
    private boolean jZa;
    @Nullable
    private com.facebook.imagepipeline.decoder.b jZb;
    private int jYW = 100;
    private Bitmap.Config Dr = Bitmap.Config.ARGB_8888;

    public int cEH() {
        return this.jYW;
    }

    public boolean cEI() {
        return this.jYX;
    }

    public boolean cEJ() {
        return this.jYY;
    }

    public boolean cEK() {
        return this.jYZ;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b cEL() {
        return this.jZb;
    }

    public boolean cEM() {
        return this.jZa;
    }

    public Bitmap.Config cEN() {
        return this.Dr;
    }

    public a cEO() {
        return new a(this);
    }
}
