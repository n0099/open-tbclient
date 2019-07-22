package com.facebook.imagepipeline.memory;
/* loaded from: classes2.dex */
public class b {
    public static final int kiy = cJV();
    private static a kiz;

    private static int cJV() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > 16777216 ? (min / 4) * 3 : min / 2;
    }

    public static a cJW() {
        if (kiz == null) {
            kiz = new a(384, kiy);
        }
        return kiz;
    }
}
