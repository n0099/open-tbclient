package com.google.ar.core;

import java.util.Locale;
/* loaded from: classes17.dex */
public class h {
    public static final h pti = new h(new float[]{0.0f, 0.0f, 0.0f}, i.ptl);
    private final i ptj;
    private final float[] ptk;

    private h(float[] fArr, i iVar) {
        this.ptk = fArr;
        this.ptj = iVar;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "t:[x:%.3f, y:%.3f, z:%.3f], q:[x:%.2f, y:%.2f, z:%.2f, w:%.2f]", Float.valueOf(this.ptk[0]), Float.valueOf(this.ptk[1]), Float.valueOf(this.ptk[2]), Float.valueOf(this.ptj.a()), Float.valueOf(this.ptj.b()), Float.valueOf(this.ptj.c()), Float.valueOf(this.ptj.d()));
    }
}
