package com.facebook.c;

import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements c.a {
    private static final byte[] ibE = {-1, -40, -1};
    private static final int ibF = ibE.length;
    private static final byte[] ibG = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int ibH = ibG.length;
    private static final byte[] ibI = e.yz("GIF87a");
    private static final byte[] ibJ = e.yz("GIF89a");
    private static final byte[] ibK = e.yz("BM");
    private static final int ibL = ibK.length;
    final int ibD = com.facebook.common.internal.e.k(21, 20, ibF, ibH, 6, ibL);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.ibD;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c j(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.m(bArr, 0, i)) {
            return k(bArr, i);
        }
        if (l(bArr, i)) {
            return b.ibM;
        }
        if (m(bArr, i)) {
            return b.ibN;
        }
        if (n(bArr, i)) {
            return b.ibO;
        }
        if (o(bArr, i)) {
            return b.ibP;
        }
        return c.ibV;
    }

    private static c k(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.m(bArr, 0, i));
        if (com.facebook.common.g.c.g(bArr, 0)) {
            return b.ibQ;
        }
        if (com.facebook.common.g.c.h(bArr, 0)) {
            return b.ibR;
        }
        if (com.facebook.common.g.c.l(bArr, 0, i)) {
            if (com.facebook.common.g.c.f(bArr, 0)) {
                return b.ibU;
            }
            if (com.facebook.common.g.c.i(bArr, 0)) {
                return b.ibT;
            }
            return b.ibS;
        }
        return c.ibV;
    }

    private static boolean l(byte[] bArr, int i) {
        return i >= ibE.length && e.c(bArr, ibE);
    }

    private static boolean m(byte[] bArr, int i) {
        return i >= ibG.length && e.c(bArr, ibG);
    }

    private static boolean n(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.c(bArr, ibI) || e.c(bArr, ibJ);
    }

    private static boolean o(byte[] bArr, int i) {
        if (i < ibK.length) {
            return false;
        }
        return e.c(bArr, ibK);
    }
}
