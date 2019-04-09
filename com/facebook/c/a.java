package com.facebook.c;

import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements c.a {
    private static final byte[] jEi = {-1, -40, -1};
    private static final int jEj = jEi.length;
    private static final byte[] jEk = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int jEl = jEk.length;
    private static final byte[] jEm = e.Ft("GIF87a");
    private static final byte[] jEn = e.Ft("GIF89a");
    private static final byte[] jEo = e.Ft("BM");
    private static final int jEp = jEo.length;
    final int jEh = com.facebook.common.internal.e.l(21, 20, jEj, jEl, 6, jEp);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.jEh;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c j(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.n(bArr, 0, i)) {
            return k(bArr, i);
        }
        if (l(bArr, i)) {
            return b.jEq;
        }
        if (m(bArr, i)) {
            return b.jEr;
        }
        if (n(bArr, i)) {
            return b.jEs;
        }
        if (o(bArr, i)) {
            return b.jEt;
        }
        return c.jEz;
    }

    private static c k(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.n(bArr, 0, i));
        if (com.facebook.common.g.c.g(bArr, 0)) {
            return b.jEu;
        }
        if (com.facebook.common.g.c.h(bArr, 0)) {
            return b.jEv;
        }
        if (com.facebook.common.g.c.m(bArr, 0, i)) {
            if (com.facebook.common.g.c.f(bArr, 0)) {
                return b.jEy;
            }
            if (com.facebook.common.g.c.i(bArr, 0)) {
                return b.jEx;
            }
            return b.jEw;
        }
        return c.jEz;
    }

    private static boolean l(byte[] bArr, int i) {
        return i >= jEi.length && e.c(bArr, jEi);
    }

    private static boolean m(byte[] bArr, int i) {
        return i >= jEk.length && e.c(bArr, jEk);
    }

    private static boolean n(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.c(bArr, jEm) || e.c(bArr, jEn);
    }

    private static boolean o(byte[] bArr, int i) {
        if (i < jEo.length) {
            return false;
        }
        return e.c(bArr, jEo);
    }
}
