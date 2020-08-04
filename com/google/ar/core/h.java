package com.google.ar.core;

import java.util.Locale;
/* loaded from: classes5.dex */
public class h {
    public static final h nio = new h(new float[]{0.0f, 0.0f, 0.0f}, i.nir);
    private final i nip;
    private final float[] niq;

    private h(float[] fArr, i iVar) {
        this.niq = fArr;
        this.nip = iVar;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "t:[x:%.3f, y:%.3f, z:%.3f], q:[x:%.2f, y:%.2f, z:%.2f, w:%.2f]", Float.valueOf(this.niq[0]), Float.valueOf(this.niq[1]), Float.valueOf(this.niq[2]), Float.valueOf(this.nip.a()), Float.valueOf(this.nip.b()), Float.valueOf(this.nip.c()), Float.valueOf(this.nip.d()));
    }
}
