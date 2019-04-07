package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private boolean jGf;
    private boolean jGg;
    private boolean jGh;
    private boolean jGi;
    @Nullable
    private com.facebook.imagepipeline.decoder.b jGj;
    private int jGe = 100;
    private Bitmap.Config FI = Bitmap.Config.ARGB_8888;

    public int cwK() {
        return this.jGe;
    }

    public boolean cwL() {
        return this.jGf;
    }

    public boolean cwM() {
        return this.jGg;
    }

    public boolean cwN() {
        return this.jGh;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b cwO() {
        return this.jGj;
    }

    public boolean cwP() {
        return this.jGi;
    }

    public Bitmap.Config cwQ() {
        return this.FI;
    }

    public a cwR() {
        return new a(this);
    }
}
