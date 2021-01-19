package com.google.ar.core;

import java.util.Locale;
/* loaded from: classes5.dex */
public class h {
    public static final h pHu = new h(new float[]{0.0f, 0.0f, 0.0f}, i.pHx);
    private final i pHv;
    private final float[] pHw;

    private h(float[] fArr, i iVar) {
        this.pHw = fArr;
        this.pHv = iVar;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "t:[x:%.3f, y:%.3f, z:%.3f], q:[x:%.2f, y:%.2f, z:%.2f, w:%.2f]", Float.valueOf(this.pHw[0]), Float.valueOf(this.pHw[1]), Float.valueOf(this.pHw[2]), Float.valueOf(this.pHv.a()), Float.valueOf(this.pHv.b()), Float.valueOf(this.pHv.c()), Float.valueOf(this.pHv.d()));
    }
}
