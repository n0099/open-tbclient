package com.facebook.imagepipeline.c;
/* loaded from: classes10.dex */
public class k implements com.facebook.common.internal.j<q> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: czw */
    public q get() {
        int czx = czx();
        return new q(czx, Integer.MAX_VALUE, czx, Integer.MAX_VALUE, czx / 8);
    }

    private int czx() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (min < 16777216) {
            return 1048576;
        }
        if (min < 33554432) {
            return 2097152;
        }
        return 4194304;
    }
}
