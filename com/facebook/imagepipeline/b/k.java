package com.facebook.imagepipeline.b;
/* loaded from: classes5.dex */
public class k implements com.facebook.common.internal.j<q> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: evW */
    public q get() {
        int evX = evX();
        return new q(evX, Integer.MAX_VALUE, evX, Integer.MAX_VALUE, evX / 8);
    }

    private int evX() {
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
