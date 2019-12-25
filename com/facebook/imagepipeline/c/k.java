package com.facebook.imagepipeline.c;
/* loaded from: classes9.dex */
public class k implements com.facebook.common.internal.j<q> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: cyp */
    public q get() {
        int cyq = cyq();
        return new q(cyq, Integer.MAX_VALUE, cyq, Integer.MAX_VALUE, cyq / 8);
    }

    private int cyq() {
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
