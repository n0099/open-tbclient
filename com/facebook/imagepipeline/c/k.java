package com.facebook.imagepipeline.c;
/* loaded from: classes2.dex */
public class k implements com.facebook.common.internal.i<u> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: cFz */
    public u get() {
        int cFA = cFA();
        return new u(cFA, Integer.MAX_VALUE, cFA, Integer.MAX_VALUE, cFA / 8);
    }

    private int cFA() {
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
