package com.facebook.imagepipeline.c;
/* loaded from: classes2.dex */
public class k implements com.facebook.common.internal.i<u> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: cIC */
    public u get() {
        int cID = cID();
        return new u(cID, Integer.MAX_VALUE, cID, Integer.MAX_VALUE, cID / 8);
    }

    private int cID() {
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
