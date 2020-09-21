package com.google.ar.core;

import java.util.Locale;
/* loaded from: classes24.dex */
public class h {
    public static final h nMt = new h(new float[]{0.0f, 0.0f, 0.0f}, i.nMw);
    private final i nMu;
    private final float[] nMv;

    private h(float[] fArr, i iVar) {
        this.nMv = fArr;
        this.nMu = iVar;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "t:[x:%.3f, y:%.3f, z:%.3f], q:[x:%.2f, y:%.2f, z:%.2f, w:%.2f]", Float.valueOf(this.nMv[0]), Float.valueOf(this.nMv[1]), Float.valueOf(this.nMv[2]), Float.valueOf(this.nMu.a()), Float.valueOf(this.nMu.b()), Float.valueOf(this.nMu.c()), Float.valueOf(this.nMu.d()));
    }
}
