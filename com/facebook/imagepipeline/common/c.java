package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class c {
    private boolean lQO;
    private boolean lQP;
    private boolean lQQ;
    private boolean lQR;
    @Nullable
    private com.facebook.imagepipeline.decoder.b lQS;
    private int lQN = 100;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;

    public int dmX() {
        return this.lQN;
    }

    public c vj(boolean z) {
        this.lQO = z;
        return this;
    }

    public boolean dmY() {
        return this.lQO;
    }

    public boolean dmZ() {
        return this.lQP;
    }

    public boolean dna() {
        return this.lQQ;
    }

    public c vk(boolean z) {
        this.lQR = z;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b dnb() {
        return this.lQS;
    }

    public boolean dnc() {
        return this.lQR;
    }

    public Bitmap.Config dnd() {
        return this.mBitmapConfig;
    }

    public b dne() {
        return new b(this);
    }
}
