package com.facebook.c;

import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements c.a {
    private static final byte[] jEC = {-1, -40, -1};
    private static final int jED = jEC.length;
    private static final byte[] jEE = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int jEF = jEE.length;
    private static final byte[] jEG = e.FC("GIF87a");
    private static final byte[] jEH = e.FC("GIF89a");
    private static final byte[] jEI = e.FC("BM");
    private static final int jEJ = jEI.length;
    final int jEB = com.facebook.common.internal.e.l(21, 20, jED, jEF, 6, jEJ);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.jEB;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c j(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.n(bArr, 0, i)) {
            return k(bArr, i);
        }
        if (l(bArr, i)) {
            return b.jEK;
        }
        if (m(bArr, i)) {
            return b.jEL;
        }
        if (n(bArr, i)) {
            return b.jEM;
        }
        if (o(bArr, i)) {
            return b.jEN;
        }
        return c.jET;
    }

    private static c k(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.n(bArr, 0, i));
        if (com.facebook.common.g.c.g(bArr, 0)) {
            return b.jEO;
        }
        if (com.facebook.common.g.c.h(bArr, 0)) {
            return b.jEP;
        }
        if (com.facebook.common.g.c.m(bArr, 0, i)) {
            if (com.facebook.common.g.c.f(bArr, 0)) {
                return b.jES;
            }
            if (com.facebook.common.g.c.i(bArr, 0)) {
                return b.jER;
            }
            return b.jEQ;
        }
        return c.jET;
    }

    private static boolean l(byte[] bArr, int i) {
        return i >= jEC.length && e.c(bArr, jEC);
    }

    private static boolean m(byte[] bArr, int i) {
        return i >= jEE.length && e.c(bArr, jEE);
    }

    private static boolean n(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.c(bArr, jEG) || e.c(bArr, jEH);
    }

    private static boolean o(byte[] bArr, int i) {
        if (i < jEI.length) {
            return false;
        }
        return e.c(bArr, jEI);
    }
}
