package com.facebook.c;

import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements c.a {
    private static final byte[] kfS = {-1, -40, -1};
    private static final int kfT = kfS.length;
    private static final byte[] kfU = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int kfV = kfU.length;
    private static final byte[] kfW = e.GC("GIF87a");
    private static final byte[] kfX = e.GC("GIF89a");
    private static final byte[] kfY = e.GC("BM");
    private static final int kfZ = kfY.length;
    final int kfR = com.facebook.common.internal.e.h(21, 20, kfT, kfV, 6, kfZ);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.kfR;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c l(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.m(bArr, 0, i)) {
            return m(bArr, i);
        }
        if (n(bArr, i)) {
            return b.kga;
        }
        if (o(bArr, i)) {
            return b.kgb;
        }
        if (p(bArr, i)) {
            return b.kgc;
        }
        if (q(bArr, i)) {
            return b.kgd;
        }
        return c.kgj;
    }

    private static c m(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.m(bArr, 0, i));
        if (com.facebook.common.g.c.i(bArr, 0)) {
            return b.kge;
        }
        if (com.facebook.common.g.c.j(bArr, 0)) {
            return b.kgf;
        }
        if (com.facebook.common.g.c.l(bArr, 0, i)) {
            if (com.facebook.common.g.c.h(bArr, 0)) {
                return b.kgi;
            }
            if (com.facebook.common.g.c.k(bArr, 0)) {
                return b.kgh;
            }
            return b.kgg;
        }
        return c.kgj;
    }

    private static boolean n(byte[] bArr, int i) {
        return i >= kfS.length && e.c(bArr, kfS);
    }

    private static boolean o(byte[] bArr, int i) {
        return i >= kfU.length && e.c(bArr, kfU);
    }

    private static boolean p(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.c(bArr, kfW) || e.c(bArr, kfX);
    }

    private static boolean q(byte[] bArr, int i) {
        if (i < kfY.length) {
            return false;
        }
        return e.c(bArr, kfY);
    }
}
