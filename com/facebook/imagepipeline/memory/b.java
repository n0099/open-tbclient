package com.facebook.imagepipeline.memory;
/* loaded from: classes2.dex */
public class b {
    public static final int kbo = cGS();
    private static a kbp;

    private static int cGS() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > 16777216 ? (min / 4) * 3 : min / 2;
    }

    public static a cGT() {
        if (kbp == null) {
            kbp = new a(384, kbo);
        }
        return kbp;
    }
}
