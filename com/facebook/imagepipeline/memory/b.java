package com.facebook.imagepipeline.memory;
/* loaded from: classes2.dex */
public class b {
    public static final int kbn = cGQ();
    private static a kbo;

    private static int cGQ() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > 16777216 ? (min / 4) * 3 : min / 2;
    }

    public static a cGR() {
        if (kbo == null) {
            kbo = new a(384, kbn);
        }
        return kbo;
    }
}
