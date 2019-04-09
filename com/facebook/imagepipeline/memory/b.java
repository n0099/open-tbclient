package com.facebook.imagepipeline.memory;
/* loaded from: classes2.dex */
public class b {
    public static final int jIA = cyU();
    private static a jIB;

    private static int cyU() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > 16777216 ? (min / 4) * 3 : min / 2;
    }

    public static a cyV() {
        if (jIB == null) {
            jIB = new a(384, jIA);
        }
        return jIB;
    }
}
