package com.google.ar.core;

import java.util.Locale;
/* loaded from: classes6.dex */
public class h {
    public static final h pLU = new h(new float[]{0.0f, 0.0f, 0.0f}, i.pLX);
    private final i pLV;
    private final float[] pLW;

    private h(float[] fArr, i iVar) {
        this.pLW = fArr;
        this.pLV = iVar;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "t:[x:%.3f, y:%.3f, z:%.3f], q:[x:%.2f, y:%.2f, z:%.2f, w:%.2f]", Float.valueOf(this.pLW[0]), Float.valueOf(this.pLW[1]), Float.valueOf(this.pLW[2]), Float.valueOf(this.pLV.a()), Float.valueOf(this.pLV.b()), Float.valueOf(this.pLV.c()), Float.valueOf(this.pLV.d()));
    }
}
