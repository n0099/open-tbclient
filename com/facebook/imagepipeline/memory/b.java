package com.facebook.imagepipeline.memory;
/* loaded from: classes2.dex */
public class b {
    private static a jIA;
    public static final int jIz = cyU();

    private static int cyU() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > 16777216 ? (min / 4) * 3 : min / 2;
    }

    public static a cyV() {
        if (jIA == null) {
            jIA = new a(384, jIz);
        }
        return jIA;
    }
}
