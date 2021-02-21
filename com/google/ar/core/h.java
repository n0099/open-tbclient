package com.google.ar.core;

import java.util.Locale;
/* loaded from: classes15.dex */
public class h {
    public static final h pRZ = new h(new float[]{0.0f, 0.0f, 0.0f}, i.pSc);
    private final i pSa;
    private final float[] pSb;

    private h(float[] fArr, i iVar) {
        this.pSb = fArr;
        this.pSa = iVar;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "t:[x:%.3f, y:%.3f, z:%.3f], q:[x:%.2f, y:%.2f, z:%.2f, w:%.2f]", Float.valueOf(this.pSb[0]), Float.valueOf(this.pSb[1]), Float.valueOf(this.pSb[2]), Float.valueOf(this.pSa.a()), Float.valueOf(this.pSa.b()), Float.valueOf(this.pSa.c()), Float.valueOf(this.pSa.d()));
    }
}
