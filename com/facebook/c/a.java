package com.facebook.c;

import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements c.a {
    private static final byte[] kfk = {-1, -40, -1};
    private static final int kfl = kfk.length;
    private static final byte[] kfm = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int kfn = kfm.length;
    private static final byte[] kfo = e.HL("GIF87a");
    private static final byte[] kfp = e.HL("GIF89a");
    private static final byte[] kfq = e.HL("BM");
    private static final int kfr = kfq.length;
    final int kfj = com.facebook.common.internal.e.l(21, 20, kfl, kfn, 6, kfr);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.kfj;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c l(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.o(bArr, 0, i)) {
            return m(bArr, i);
        }
        if (n(bArr, i)) {
            return b.kfs;
        }
        if (o(bArr, i)) {
            return b.kft;
        }
        if (p(bArr, i)) {
            return b.kfu;
        }
        if (q(bArr, i)) {
            return b.kfv;
        }
        return c.kfB;
    }

    private static c m(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.o(bArr, 0, i));
        if (com.facebook.common.g.c.i(bArr, 0)) {
            return b.kfw;
        }
        if (com.facebook.common.g.c.j(bArr, 0)) {
            return b.kfx;
        }
        if (com.facebook.common.g.c.n(bArr, 0, i)) {
            if (com.facebook.common.g.c.h(bArr, 0)) {
                return b.kfA;
            }
            if (com.facebook.common.g.c.k(bArr, 0)) {
                return b.kfz;
            }
            return b.kfy;
        }
        return c.kfB;
    }

    private static boolean n(byte[] bArr, int i) {
        return i >= kfk.length && e.c(bArr, kfk);
    }

    private static boolean o(byte[] bArr, int i) {
        return i >= kfm.length && e.c(bArr, kfm);
    }

    private static boolean p(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.c(bArr, kfo) || e.c(bArr, kfp);
    }

    private static boolean q(byte[] bArr, int i) {
        if (i < kfq.length) {
            return false;
        }
        return e.c(bArr, kfq);
    }
}
