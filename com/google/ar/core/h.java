package com.google.ar.core;

import java.util.Locale;
/* loaded from: classes3.dex */
public class h {
    public static final h pKm = new h(new float[]{0.0f, 0.0f, 0.0f}, i.pKp);
    private final i pKn;
    private final float[] pKo;

    private h(float[] fArr, i iVar) {
        this.pKo = fArr;
        this.pKn = iVar;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "t:[x:%.3f, y:%.3f, z:%.3f], q:[x:%.2f, y:%.2f, z:%.2f, w:%.2f]", Float.valueOf(this.pKo[0]), Float.valueOf(this.pKo[1]), Float.valueOf(this.pKo[2]), Float.valueOf(this.pKn.a()), Float.valueOf(this.pKn.b()), Float.valueOf(this.pKn.c()), Float.valueOf(this.pKn.d()));
    }
}
