package com.google.ar.core;

import java.util.Locale;
/* loaded from: classes5.dex */
public class h {
    public static final h pHt = new h(new float[]{0.0f, 0.0f, 0.0f}, i.pHw);
    private final i pHu;
    private final float[] pHv;

    private h(float[] fArr, i iVar) {
        this.pHv = fArr;
        this.pHu = iVar;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "t:[x:%.3f, y:%.3f, z:%.3f], q:[x:%.2f, y:%.2f, z:%.2f, w:%.2f]", Float.valueOf(this.pHv[0]), Float.valueOf(this.pHv[1]), Float.valueOf(this.pHv[2]), Float.valueOf(this.pHu.a()), Float.valueOf(this.pHu.b()), Float.valueOf(this.pHu.c()), Float.valueOf(this.pHu.d()));
    }
}
