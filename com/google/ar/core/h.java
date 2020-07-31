package com.google.ar.core;

import java.util.Locale;
/* loaded from: classes5.dex */
public class h {
    public static final h nim = new h(new float[]{0.0f, 0.0f, 0.0f}, i.nip);
    private final i nin;
    private final float[] nio;

    private h(float[] fArr, i iVar) {
        this.nio = fArr;
        this.nin = iVar;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "t:[x:%.3f, y:%.3f, z:%.3f], q:[x:%.2f, y:%.2f, z:%.2f, w:%.2f]", Float.valueOf(this.nio[0]), Float.valueOf(this.nio[1]), Float.valueOf(this.nio[2]), Float.valueOf(this.nin.a()), Float.valueOf(this.nin.b()), Float.valueOf(this.nin.c()), Float.valueOf(this.nin.d()));
    }
}
