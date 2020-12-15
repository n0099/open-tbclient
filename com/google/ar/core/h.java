package com.google.ar.core;

import java.util.Locale;
/* loaded from: classes17.dex */
public class h {
    public static final h ptk = new h(new float[]{0.0f, 0.0f, 0.0f}, i.ptn);
    private final i ptl;
    private final float[] ptm;

    private h(float[] fArr, i iVar) {
        this.ptm = fArr;
        this.ptl = iVar;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "t:[x:%.3f, y:%.3f, z:%.3f], q:[x:%.2f, y:%.2f, z:%.2f, w:%.2f]", Float.valueOf(this.ptm[0]), Float.valueOf(this.ptm[1]), Float.valueOf(this.ptm[2]), Float.valueOf(this.ptl.a()), Float.valueOf(this.ptl.b()), Float.valueOf(this.ptl.c()), Float.valueOf(this.ptl.d()));
    }
}
