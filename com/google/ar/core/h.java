package com.google.ar.core;

import java.util.Locale;
/* loaded from: classes15.dex */
public class h {
    public static final h pRz = new h(new float[]{0.0f, 0.0f, 0.0f}, i.pRC);
    private final i pRA;
    private final float[] pRB;

    private h(float[] fArr, i iVar) {
        this.pRB = fArr;
        this.pRA = iVar;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "t:[x:%.3f, y:%.3f, z:%.3f], q:[x:%.2f, y:%.2f, z:%.2f, w:%.2f]", Float.valueOf(this.pRB[0]), Float.valueOf(this.pRB[1]), Float.valueOf(this.pRB[2]), Float.valueOf(this.pRA.a()), Float.valueOf(this.pRA.b()), Float.valueOf(this.pRA.c()), Float.valueOf(this.pRA.d()));
    }
}
