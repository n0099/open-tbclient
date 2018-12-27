package com.facebook.imagepipeline.memory;
/* loaded from: classes2.dex */
public class b {
    public static final int isd = bZb();
    private static a ise;

    private static int bZb() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > 16777216 ? (min / 4) * 3 : min / 2;
    }

    public static a bZc() {
        if (ise == null) {
            ise = new a(384, isd);
        }
        return ise;
    }
}
