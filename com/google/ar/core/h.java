package com.google.ar.core;

import java.util.Locale;
/* loaded from: classes11.dex */
public class h {
    public static final h nCx = new h(new float[]{0.0f, 0.0f, 0.0f}, i.nCA);
    private final i nCy;
    private final float[] nCz;

    private h(float[] fArr, i iVar) {
        this.nCz = fArr;
        this.nCy = iVar;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "t:[x:%.3f, y:%.3f, z:%.3f], q:[x:%.2f, y:%.2f, z:%.2f, w:%.2f]", Float.valueOf(this.nCz[0]), Float.valueOf(this.nCz[1]), Float.valueOf(this.nCz[2]), Float.valueOf(this.nCy.a()), Float.valueOf(this.nCy.b()), Float.valueOf(this.nCy.c()), Float.valueOf(this.nCy.d()));
    }
}
