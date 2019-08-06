package com.facebook.imagepipeline.memory;
/* loaded from: classes2.dex */
public class b {
    public static final int kjE = cKq();
    private static a kjF;

    private static int cKq() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > 16777216 ? (min / 4) * 3 : min / 2;
    }

    public static a cKr() {
        if (kjF == null) {
            kjF = new a(384, kjE);
        }
        return kjF;
    }
}
