package com.facebook.c;

import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements c.a {
    private static final byte[] jEN = {-1, -40, -1};
    private static final int jEO = jEN.length;
    private static final byte[] jEP = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int jEQ = jEP.length;
    private static final byte[] jER = e.FD("GIF87a");
    private static final byte[] jES = e.FD("GIF89a");
    private static final byte[] jET = e.FD("BM");
    private static final int jEU = jET.length;
    final int jEM = com.facebook.common.internal.e.l(21, 20, jEO, jEQ, 6, jEU);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.jEM;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c j(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.n(bArr, 0, i)) {
            return k(bArr, i);
        }
        if (l(bArr, i)) {
            return b.jEV;
        }
        if (m(bArr, i)) {
            return b.jEW;
        }
        if (n(bArr, i)) {
            return b.jEX;
        }
        if (o(bArr, i)) {
            return b.jEY;
        }
        return c.jFe;
    }

    private static c k(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.n(bArr, 0, i));
        if (com.facebook.common.g.c.g(bArr, 0)) {
            return b.jEZ;
        }
        if (com.facebook.common.g.c.h(bArr, 0)) {
            return b.jFa;
        }
        if (com.facebook.common.g.c.m(bArr, 0, i)) {
            if (com.facebook.common.g.c.f(bArr, 0)) {
                return b.jFd;
            }
            if (com.facebook.common.g.c.i(bArr, 0)) {
                return b.jFc;
            }
            return b.jFb;
        }
        return c.jFe;
    }

    private static boolean l(byte[] bArr, int i) {
        return i >= jEN.length && e.c(bArr, jEN);
    }

    private static boolean m(byte[] bArr, int i) {
        return i >= jEP.length && e.c(bArr, jEP);
    }

    private static boolean n(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.c(bArr, jER) || e.c(bArr, jES);
    }

    private static boolean o(byte[] bArr, int i) {
        if (i < jET.length) {
            return false;
        }
        return e.c(bArr, jET);
    }
}
