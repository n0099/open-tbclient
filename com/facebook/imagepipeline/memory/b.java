package com.facebook.imagepipeline.memory;
/* loaded from: classes2.dex */
public class b {
    public static final int itl = bZJ();
    private static a itm;

    private static int bZJ() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > 16777216 ? (min / 4) * 3 : min / 2;
    }

    public static a bZK() {
        if (itm == null) {
            itm = new a(384, itl);
        }
        return itm;
    }
}
