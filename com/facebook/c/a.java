package com.facebook.c;

import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements c.a {
    private static final byte[] jEh = {-1, -40, -1};
    private static final int jEi = jEh.length;
    private static final byte[] jEj = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int jEk = jEj.length;
    private static final byte[] jEl = e.Ft("GIF87a");
    private static final byte[] jEm = e.Ft("GIF89a");
    private static final byte[] jEn = e.Ft("BM");
    private static final int jEo = jEn.length;
    final int jEg = com.facebook.common.internal.e.l(21, 20, jEi, jEk, 6, jEo);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.jEg;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c j(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.n(bArr, 0, i)) {
            return k(bArr, i);
        }
        if (l(bArr, i)) {
            return b.jEp;
        }
        if (m(bArr, i)) {
            return b.jEq;
        }
        if (n(bArr, i)) {
            return b.jEr;
        }
        if (o(bArr, i)) {
            return b.jEs;
        }
        return c.jEy;
    }

    private static c k(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.n(bArr, 0, i));
        if (com.facebook.common.g.c.g(bArr, 0)) {
            return b.jEt;
        }
        if (com.facebook.common.g.c.h(bArr, 0)) {
            return b.jEu;
        }
        if (com.facebook.common.g.c.m(bArr, 0, i)) {
            if (com.facebook.common.g.c.f(bArr, 0)) {
                return b.jEx;
            }
            if (com.facebook.common.g.c.i(bArr, 0)) {
                return b.jEw;
            }
            return b.jEv;
        }
        return c.jEy;
    }

    private static boolean l(byte[] bArr, int i) {
        return i >= jEh.length && e.c(bArr, jEh);
    }

    private static boolean m(byte[] bArr, int i) {
        return i >= jEj.length && e.c(bArr, jEj);
    }

    private static boolean n(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.c(bArr, jEl) || e.c(bArr, jEm);
    }

    private static boolean o(byte[] bArr, int i) {
        if (i < jEn.length) {
            return false;
        }
        return e.c(bArr, jEn);
    }
}
