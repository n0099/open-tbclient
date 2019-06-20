package com.facebook.c;

import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements c.a {
    private static final byte[] jWZ = {-1, -40, -1};
    private static final int jXa = jWZ.length;
    private static final byte[] jXb = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int jXc = jXb.length;
    private static final byte[] jXd = e.GQ("GIF87a");
    private static final byte[] jXe = e.GQ("GIF89a");
    private static final byte[] jXf = e.GQ("BM");
    private static final int jXg = jXf.length;
    final int jWY = com.facebook.common.internal.e.l(21, 20, jXa, jXc, 6, jXg);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.jWY;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c l(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.n(bArr, 0, i)) {
            return m(bArr, i);
        }
        if (n(bArr, i)) {
            return b.jXh;
        }
        if (o(bArr, i)) {
            return b.jXi;
        }
        if (p(bArr, i)) {
            return b.jXj;
        }
        if (q(bArr, i)) {
            return b.jXk;
        }
        return c.jXq;
    }

    private static c m(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.n(bArr, 0, i));
        if (com.facebook.common.g.c.i(bArr, 0)) {
            return b.jXl;
        }
        if (com.facebook.common.g.c.j(bArr, 0)) {
            return b.jXm;
        }
        if (com.facebook.common.g.c.m(bArr, 0, i)) {
            if (com.facebook.common.g.c.h(bArr, 0)) {
                return b.jXp;
            }
            if (com.facebook.common.g.c.k(bArr, 0)) {
                return b.jXo;
            }
            return b.jXn;
        }
        return c.jXq;
    }

    private static boolean n(byte[] bArr, int i) {
        return i >= jWZ.length && e.c(bArr, jWZ);
    }

    private static boolean o(byte[] bArr, int i) {
        return i >= jXb.length && e.c(bArr, jXb);
    }

    private static boolean p(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.c(bArr, jXd) || e.c(bArr, jXe);
    }

    private static boolean q(byte[] bArr, int i) {
        if (i < jXf.length) {
            return false;
        }
        return e.c(bArr, jXf);
    }
}
