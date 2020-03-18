package com.facebook.imagepipeline.c;
/* loaded from: classes12.dex */
public class k implements com.facebook.common.internal.j<q> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: cBq */
    public q get() {
        int cBr = cBr();
        return new q(cBr, Integer.MAX_VALUE, cBr, Integer.MAX_VALUE, cBr / 8);
    }

    private int cBr() {
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
