package com.facebook.imagepipeline.b;
/* loaded from: classes5.dex */
public class k implements com.facebook.common.internal.j<q> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: evO */
    public q get() {
        int evP = evP();
        return new q(evP, Integer.MAX_VALUE, evP, Integer.MAX_VALUE, evP / 8);
    }

    private int evP() {
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
