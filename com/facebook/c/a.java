package com.facebook.c;

import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements c.a {
    private static final byte[] jEV = {-1, -40, -1};
    private static final int jEW = jEV.length;
    private static final byte[] jEX = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int jEY = jEX.length;
    private static final byte[] jEZ = e.FF("GIF87a");
    private static final byte[] jFa = e.FF("GIF89a");
    private static final byte[] jFb = e.FF("BM");
    private static final int jFc = jFb.length;
    final int jEU = com.facebook.common.internal.e.l(21, 20, jEW, jEY, 6, jFc);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.jEU;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c j(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.n(bArr, 0, i)) {
            return k(bArr, i);
        }
        if (l(bArr, i)) {
            return b.jFd;
        }
        if (m(bArr, i)) {
            return b.jFe;
        }
        if (n(bArr, i)) {
            return b.jFf;
        }
        if (o(bArr, i)) {
            return b.jFg;
        }
        return c.jFm;
    }

    private static c k(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.n(bArr, 0, i));
        if (com.facebook.common.g.c.g(bArr, 0)) {
            return b.jFh;
        }
        if (com.facebook.common.g.c.h(bArr, 0)) {
            return b.jFi;
        }
        if (com.facebook.common.g.c.m(bArr, 0, i)) {
            if (com.facebook.common.g.c.f(bArr, 0)) {
                return b.jFl;
            }
            if (com.facebook.common.g.c.i(bArr, 0)) {
                return b.jFk;
            }
            return b.jFj;
        }
        return c.jFm;
    }

    private static boolean l(byte[] bArr, int i) {
        return i >= jEV.length && e.c(bArr, jEV);
    }

    private static boolean m(byte[] bArr, int i) {
        return i >= jEX.length && e.c(bArr, jEX);
    }

    private static boolean n(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.c(bArr, jEZ) || e.c(bArr, jFa);
    }

    private static boolean o(byte[] bArr, int i) {
        if (i < jFb.length) {
            return false;
        }
        return e.c(bArr, jFb);
    }
}
