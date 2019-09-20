package com.facebook.imagepipeline.memory;
/* loaded from: classes2.dex */
public class b {
    public static final int kmb = cLe();
    private static a kmc;

    private static int cLe() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > 16777216 ? (min / 4) * 3 : min / 2;
    }

    public static a cLf() {
        if (kmc == null) {
            kmc = new a(384, kmb);
        }
        return kmc;
    }
}
