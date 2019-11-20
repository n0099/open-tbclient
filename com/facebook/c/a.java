package com.facebook.c;

import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements c.a {
    private static final byte[] kfb = {-1, -40, -1};
    private static final int kfc = kfb.length;
    private static final byte[] kfd = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int kfe = kfd.length;
    private static final byte[] kff = e.GC("GIF87a");
    private static final byte[] kfg = e.GC("GIF89a");
    private static final byte[] kfh = e.GC("BM");
    private static final int kfi = kfh.length;
    final int kfa = com.facebook.common.internal.e.h(21, 20, kfc, kfe, 6, kfi);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.kfa;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c l(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.k(bArr, 0, i)) {
            return m(bArr, i);
        }
        if (n(bArr, i)) {
            return b.kfj;
        }
        if (o(bArr, i)) {
            return b.kfk;
        }
        if (p(bArr, i)) {
            return b.kfl;
        }
        if (q(bArr, i)) {
            return b.kfm;
        }
        return c.kfs;
    }

    private static c m(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.k(bArr, 0, i));
        if (com.facebook.common.g.c.i(bArr, 0)) {
            return b.kfn;
        }
        if (com.facebook.common.g.c.j(bArr, 0)) {
            return b.kfo;
        }
        if (com.facebook.common.g.c.j(bArr, 0, i)) {
            if (com.facebook.common.g.c.h(bArr, 0)) {
                return b.kfr;
            }
            if (com.facebook.common.g.c.k(bArr, 0)) {
                return b.kfq;
            }
            return b.kfp;
        }
        return c.kfs;
    }

    private static boolean n(byte[] bArr, int i) {
        return i >= kfb.length && e.c(bArr, kfb);
    }

    private static boolean o(byte[] bArr, int i) {
        return i >= kfd.length && e.c(bArr, kfd);
    }

    private static boolean p(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.c(bArr, kff) || e.c(bArr, kfg);
    }

    private static boolean q(byte[] bArr, int i) {
        if (i < kfh.length) {
            return false;
        }
        return e.c(bArr, kfh);
    }
}
