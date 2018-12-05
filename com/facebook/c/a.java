package com.facebook.c;

import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements c.a {
    private static final byte[] ikC = {-1, -40, -1};
    private static final int ikD = ikC.length;
    private static final byte[] ikE = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int ikF = ikE.length;
    private static final byte[] ikG = e.zh("GIF87a");
    private static final byte[] ikH = e.zh("GIF89a");
    private static final byte[] ikI = e.zh("BM");
    private static final int ikJ = ikI.length;
    final int ikB = com.facebook.common.internal.e.k(21, 20, ikD, ikF, 6, ikJ);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.ikB;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c j(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.m(bArr, 0, i)) {
            return k(bArr, i);
        }
        if (l(bArr, i)) {
            return b.ikK;
        }
        if (m(bArr, i)) {
            return b.ikL;
        }
        if (n(bArr, i)) {
            return b.ikM;
        }
        if (o(bArr, i)) {
            return b.ikN;
        }
        return c.ikT;
    }

    private static c k(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.m(bArr, 0, i));
        if (com.facebook.common.g.c.g(bArr, 0)) {
            return b.ikO;
        }
        if (com.facebook.common.g.c.h(bArr, 0)) {
            return b.ikP;
        }
        if (com.facebook.common.g.c.l(bArr, 0, i)) {
            if (com.facebook.common.g.c.f(bArr, 0)) {
                return b.ikS;
            }
            if (com.facebook.common.g.c.i(bArr, 0)) {
                return b.ikR;
            }
            return b.ikQ;
        }
        return c.ikT;
    }

    private static boolean l(byte[] bArr, int i) {
        return i >= ikC.length && e.d(bArr, ikC);
    }

    private static boolean m(byte[] bArr, int i) {
        return i >= ikE.length && e.d(bArr, ikE);
    }

    private static boolean n(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.d(bArr, ikG) || e.d(bArr, ikH);
    }

    private static boolean o(byte[] bArr, int i) {
        if (i < ikI.length) {
            return false;
        }
        return e.d(bArr, ikI);
    }
}
