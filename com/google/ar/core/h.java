package com.google.ar.core;

import java.util.Locale;
/* loaded from: classes5.dex */
public class h {
    public static final h pea = new h(new float[]{0.0f, 0.0f, 0.0f}, i.ped);
    private final i peb;
    private final float[] pec;

    private h(float[] fArr, i iVar) {
        this.pec = fArr;
        this.peb = iVar;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "t:[x:%.3f, y:%.3f, z:%.3f], q:[x:%.2f, y:%.2f, z:%.2f, w:%.2f]", Float.valueOf(this.pec[0]), Float.valueOf(this.pec[1]), Float.valueOf(this.pec[2]), Float.valueOf(this.peb.a()), Float.valueOf(this.peb.b()), Float.valueOf(this.peb.c()), Float.valueOf(this.peb.d()));
    }
}
