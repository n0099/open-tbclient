package com.facebook.imagepipeline.memory;
/* loaded from: classes2.dex */
public class b {
    public static final int jJf = czb();
    private static a jJg;

    private static int czb() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > 16777216 ? (min / 4) * 3 : min / 2;
    }

    public static a czc() {
        if (jJg == null) {
            jJg = new a(384, jJf);
        }
        return jJg;
    }
}
