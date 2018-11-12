package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private boolean ifq;
    private boolean ifr;
    private boolean ifs;
    private boolean ift;
    @Nullable
    private com.facebook.imagepipeline.decoder.b ifu;
    private int ifp = 100;
    private Bitmap.Config FJ = Bitmap.Config.ARGB_8888;

    public int bTZ() {
        return this.ifp;
    }

    public boolean bUa() {
        return this.ifq;
    }

    public boolean bUb() {
        return this.ifr;
    }

    public boolean bUc() {
        return this.ifs;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b bUd() {
        return this.ifu;
    }

    public boolean bUe() {
        return this.ift;
    }

    public Bitmap.Config bUf() {
        return this.FJ;
    }

    public a bUg() {
        return new a(this);
    }
}
