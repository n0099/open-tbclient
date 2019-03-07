package com.facebook.imagepipeline.memory;
/* loaded from: classes2.dex */
public class b {
    public static final int jIU = cyO();
    private static a jIV;

    private static int cyO() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > 16777216 ? (min / 4) * 3 : min / 2;
    }

    public static a cyP() {
        if (jIV == null) {
            jIV = new a(384, jIU);
        }
        return jIV;
    }
}
