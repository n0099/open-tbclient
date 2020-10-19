package com.google.ar.core;

import java.util.Locale;
/* loaded from: classes11.dex */
public class h {
    public static final h obL = new h(new float[]{0.0f, 0.0f, 0.0f}, i.obO);
    private final i obM;
    private final float[] obN;

    private h(float[] fArr, i iVar) {
        this.obN = fArr;
        this.obM = iVar;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "t:[x:%.3f, y:%.3f, z:%.3f], q:[x:%.2f, y:%.2f, z:%.2f, w:%.2f]", Float.valueOf(this.obN[0]), Float.valueOf(this.obN[1]), Float.valueOf(this.obN[2]), Float.valueOf(this.obM.a()), Float.valueOf(this.obM.b()), Float.valueOf(this.obM.c()), Float.valueOf(this.obM.d()));
    }
}
