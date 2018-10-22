package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private boolean idG;
    private boolean idH;
    private boolean idI;
    private boolean idJ;
    @Nullable
    private com.facebook.imagepipeline.decoder.b idK;
    private int idF = 100;
    private Bitmap.Config FF = Bitmap.Config.ARGB_8888;

    public int bUE() {
        return this.idF;
    }

    public boolean bUF() {
        return this.idG;
    }

    public boolean bUG() {
        return this.idH;
    }

    public boolean bUH() {
        return this.idI;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b bUI() {
        return this.idK;
    }

    public boolean bUJ() {
        return this.idJ;
    }

    public Bitmap.Config bUK() {
        return this.FF;
    }

    public a bUL() {
        return new a(this);
    }
}
