package com.facebook.imagepipeline.memory;
/* loaded from: classes2.dex */
public class b {
    public static final int ioT = bYl();
    private static a ioU;

    private static int bYl() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > 16777216 ? (min / 4) * 3 : min / 2;
    }

    public static a bYm() {
        if (ioU == null) {
            ioU = new a(384, ioT);
        }
        return ioU;
    }
}
