package com.facebook.imagepipeline.memory;
/* loaded from: classes2.dex */
public class b {
    public static final int ihH = bWf();
    private static a ihI;

    private static int bWf() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > 16777216 ? (min / 4) * 3 : min / 2;
    }

    public static a bWg() {
        if (ihI == null) {
            ihI = new a(384, ihH);
        }
        return ihI;
    }
}
