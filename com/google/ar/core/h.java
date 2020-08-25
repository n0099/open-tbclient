package com.google.ar.core;

import java.util.Locale;
/* loaded from: classes11.dex */
public class h {
    public static final h nCf = new h(new float[]{0.0f, 0.0f, 0.0f}, i.nCi);
    private final i nCg;
    private final float[] nCh;

    private h(float[] fArr, i iVar) {
        this.nCh = fArr;
        this.nCg = iVar;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "t:[x:%.3f, y:%.3f, z:%.3f], q:[x:%.2f, y:%.2f, z:%.2f, w:%.2f]", Float.valueOf(this.nCh[0]), Float.valueOf(this.nCh[1]), Float.valueOf(this.nCh[2]), Float.valueOf(this.nCg.a()), Float.valueOf(this.nCg.b()), Float.valueOf(this.nCg.c()), Float.valueOf(this.nCg.d()));
    }
}
