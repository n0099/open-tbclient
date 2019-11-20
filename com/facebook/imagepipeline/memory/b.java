package com.facebook.imagepipeline.memory;
/* loaded from: classes2.dex */
public class b {
    public static final int kjw = cHZ();
    private static a kjx;

    private static int cHZ() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > 16777216 ? (min / 4) * 3 : min / 2;
    }

    public static a cIa() {
        if (kjx == null) {
            kjx = new a(384, kjw);
        }
        return kjx;
    }
}
