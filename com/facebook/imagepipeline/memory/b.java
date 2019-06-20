package com.facebook.imagepipeline.memory;
/* loaded from: classes2.dex */
public class b {
    public static final int kbr = cGR();
    private static a kbs;

    private static int cGR() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > 16777216 ? (min / 4) * 3 : min / 2;
    }

    public static a cGS() {
        if (kbs == null) {
            kbs = new a(384, kbr);
        }
        return kbs;
    }
}
