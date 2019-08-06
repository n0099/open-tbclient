package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private boolean khj;
    private boolean khk;
    private boolean khl;
    private boolean khm;
    @Nullable
    private com.facebook.imagepipeline.decoder.b khn;
    private int khi = 100;
    private Bitmap.Config Dx = Bitmap.Config.ARGB_8888;

    public int cIf() {
        return this.khi;
    }

    public boolean cIg() {
        return this.khj;
    }

    public boolean cIh() {
        return this.khk;
    }

    public boolean cIi() {
        return this.khl;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b cIj() {
        return this.khn;
    }

    public boolean cIk() {
        return this.khm;
    }

    public Bitmap.Config cIl() {
        return this.Dx;
    }

    public a cIm() {
        return new a(this);
    }
}
