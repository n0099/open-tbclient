package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class c {
    private boolean lQT;
    private boolean lQU;
    private boolean lQV;
    private boolean lQW;
    @Nullable
    private com.facebook.imagepipeline.decoder.b lQX;
    private int lQS = 100;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;

    public int dmZ() {
        return this.lQS;
    }

    public c vj(boolean z) {
        this.lQT = z;
        return this;
    }

    public boolean dna() {
        return this.lQT;
    }

    public boolean dnb() {
        return this.lQU;
    }

    public boolean dnc() {
        return this.lQV;
    }

    public c vk(boolean z) {
        this.lQW = z;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b dnd() {
        return this.lQX;
    }

    public boolean dne() {
        return this.lQW;
    }

    public Bitmap.Config dnf() {
        return this.mBitmapConfig;
    }

    public b dng() {
        return new b(this);
    }
}
