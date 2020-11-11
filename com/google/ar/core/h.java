package com.google.ar.core;

import java.util.Locale;
/* loaded from: classes11.dex */
public class h {
    public static final h pcx = new h(new float[]{0.0f, 0.0f, 0.0f}, i.pcA);
    private final i pcy;
    private final float[] pcz;

    private h(float[] fArr, i iVar) {
        this.pcz = fArr;
        this.pcy = iVar;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "t:[x:%.3f, y:%.3f, z:%.3f], q:[x:%.2f, y:%.2f, z:%.2f, w:%.2f]", Float.valueOf(this.pcz[0]), Float.valueOf(this.pcz[1]), Float.valueOf(this.pcz[2]), Float.valueOf(this.pcy.a()), Float.valueOf(this.pcy.b()), Float.valueOf(this.pcy.c()), Float.valueOf(this.pcy.d()));
    }
}
