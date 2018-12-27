package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private boolean ipM;
    private boolean ipN;
    private boolean ipO;
    private boolean ipP;
    @Nullable
    private com.facebook.imagepipeline.decoder.b ipQ;
    private int ipL = 100;
    private Bitmap.Config FJ = Bitmap.Config.ARGB_8888;

    public int bWV() {
        return this.ipL;
    }

    public boolean bWW() {
        return this.ipM;
    }

    public boolean bWX() {
        return this.ipN;
    }

    public boolean bWY() {
        return this.ipO;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b bWZ() {
        return this.ipQ;
    }

    public boolean bXa() {
        return this.ipP;
    }

    public Bitmap.Config bXb() {
        return this.FJ;
    }

    public a bXc() {
        return new a(this);
    }
}
