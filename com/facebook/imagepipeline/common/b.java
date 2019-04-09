package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private boolean jGg;
    private boolean jGh;
    private boolean jGi;
    private boolean jGj;
    @Nullable
    private com.facebook.imagepipeline.decoder.b jGk;
    private int jGf = 100;
    private Bitmap.Config FI = Bitmap.Config.ARGB_8888;

    public int cwK() {
        return this.jGf;
    }

    public boolean cwL() {
        return this.jGg;
    }

    public boolean cwM() {
        return this.jGh;
    }

    public boolean cwN() {
        return this.jGi;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b cwO() {
        return this.jGk;
    }

    public boolean cwP() {
        return this.jGj;
    }

    public Bitmap.Config cwQ() {
        return this.FI;
    }

    public a cwR() {
        return new a(this);
    }
}
