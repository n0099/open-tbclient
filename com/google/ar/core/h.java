package com.google.ar.core;

import java.util.Locale;
/* loaded from: classes14.dex */
public class h {
    public static final h pSO = new h(new float[]{0.0f, 0.0f, 0.0f}, i.pSR);
    private final i pSP;
    private final float[] pSQ;

    private h(float[] fArr, i iVar) {
        this.pSQ = fArr;
        this.pSP = iVar;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "t:[x:%.3f, y:%.3f, z:%.3f], q:[x:%.2f, y:%.2f, z:%.2f, w:%.2f]", Float.valueOf(this.pSQ[0]), Float.valueOf(this.pSQ[1]), Float.valueOf(this.pSQ[2]), Float.valueOf(this.pSP.a()), Float.valueOf(this.pSP.b()), Float.valueOf(this.pSP.c()), Float.valueOf(this.pSP.d()));
    }
}
