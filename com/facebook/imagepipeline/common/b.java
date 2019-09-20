package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private boolean kjH;
    private boolean kjI;
    private boolean kjJ;
    private boolean kjK;
    @Nullable
    private com.facebook.imagepipeline.decoder.b kjL;
    private int kjG = 100;
    private Bitmap.Config Dx = Bitmap.Config.ARGB_8888;

    public int cIT() {
        return this.kjG;
    }

    public boolean cIU() {
        return this.kjH;
    }

    public boolean cIV() {
        return this.kjI;
    }

    public boolean cIW() {
        return this.kjJ;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b cIX() {
        return this.kjL;
    }

    public boolean cIY() {
        return this.kjK;
    }

    public Bitmap.Config cIZ() {
        return this.Dx;
    }

    public a cJa() {
        return new a(this);
    }
}
