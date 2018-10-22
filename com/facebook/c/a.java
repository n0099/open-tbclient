package com.facebook.c;

import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements c.a {
    private static final byte[] ibF = {-1, -40, -1};
    private static final int ibG = ibF.length;
    private static final byte[] ibH = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int ibI = ibH.length;
    private static final byte[] ibJ = e.yz("GIF87a");
    private static final byte[] ibK = e.yz("GIF89a");
    private static final byte[] ibL = e.yz("BM");
    private static final int ibM = ibL.length;
    final int ibE = com.facebook.common.internal.e.k(21, 20, ibG, ibI, 6, ibM);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.ibE;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c j(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.m(bArr, 0, i)) {
            return k(bArr, i);
        }
        if (l(bArr, i)) {
            return b.ibN;
        }
        if (m(bArr, i)) {
            return b.ibO;
        }
        if (n(bArr, i)) {
            return b.ibP;
        }
        if (o(bArr, i)) {
            return b.ibQ;
        }
        return c.ibW;
    }

    private static c k(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.m(bArr, 0, i));
        if (com.facebook.common.g.c.g(bArr, 0)) {
            return b.ibR;
        }
        if (com.facebook.common.g.c.h(bArr, 0)) {
            return b.ibS;
        }
        if (com.facebook.common.g.c.l(bArr, 0, i)) {
            if (com.facebook.common.g.c.f(bArr, 0)) {
                return b.ibV;
            }
            if (com.facebook.common.g.c.i(bArr, 0)) {
                return b.ibU;
            }
            return b.ibT;
        }
        return c.ibW;
    }

    private static boolean l(byte[] bArr, int i) {
        return i >= ibF.length && e.c(bArr, ibF);
    }

    private static boolean m(byte[] bArr, int i) {
        return i >= ibH.length && e.c(bArr, ibH);
    }

    private static boolean n(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.c(bArr, ibJ) || e.c(bArr, ibK);
    }

    private static boolean o(byte[] bArr, int i) {
        if (i < ibL.length) {
            return false;
        }
        return e.c(bArr, ibL);
    }
}
