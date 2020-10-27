package com.google.ar.core;

import java.util.Locale;
/* loaded from: classes11.dex */
public class h {
    public static final h oTc = new h(new float[]{0.0f, 0.0f, 0.0f}, i.oTf);
    private final i oTd;
    private final float[] oTe;

    private h(float[] fArr, i iVar) {
        this.oTe = fArr;
        this.oTd = iVar;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "t:[x:%.3f, y:%.3f, z:%.3f], q:[x:%.2f, y:%.2f, z:%.2f, w:%.2f]", Float.valueOf(this.oTe[0]), Float.valueOf(this.oTe[1]), Float.valueOf(this.oTe[2]), Float.valueOf(this.oTd.a()), Float.valueOf(this.oTd.b()), Float.valueOf(this.oTd.c()), Float.valueOf(this.oTd.d()));
    }
}
