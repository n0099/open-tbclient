package com.facebook.c;

import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements c.a {
    private static final byte[] khH = {-1, -40, -1};
    private static final int khI = khH.length;
    private static final byte[] khJ = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int khK = khJ.length;
    private static final byte[] khL = e.Il("GIF87a");
    private static final byte[] khM = e.Il("GIF89a");
    private static final byte[] khN = e.Il("BM");
    private static final int khO = khN.length;
    final int khG = com.facebook.common.internal.e.l(21, 20, khI, khK, 6, khO);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.khG;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c l(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.o(bArr, 0, i)) {
            return m(bArr, i);
        }
        if (n(bArr, i)) {
            return b.khP;
        }
        if (o(bArr, i)) {
            return b.khQ;
        }
        if (p(bArr, i)) {
            return b.khR;
        }
        if (q(bArr, i)) {
            return b.khS;
        }
        return c.khY;
    }

    private static c m(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.o(bArr, 0, i));
        if (com.facebook.common.g.c.i(bArr, 0)) {
            return b.khT;
        }
        if (com.facebook.common.g.c.j(bArr, 0)) {
            return b.khU;
        }
        if (com.facebook.common.g.c.n(bArr, 0, i)) {
            if (com.facebook.common.g.c.h(bArr, 0)) {
                return b.khX;
            }
            if (com.facebook.common.g.c.k(bArr, 0)) {
                return b.khW;
            }
            return b.khV;
        }
        return c.khY;
    }

    private static boolean n(byte[] bArr, int i) {
        return i >= khH.length && e.c(bArr, khH);
    }

    private static boolean o(byte[] bArr, int i) {
        return i >= khJ.length && e.c(bArr, khJ);
    }

    private static boolean p(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.c(bArr, khL) || e.c(bArr, khM);
    }

    private static boolean q(byte[] bArr, int i) {
        if (i < khN.length) {
            return false;
        }
        return e.c(bArr, khN);
    }
}
