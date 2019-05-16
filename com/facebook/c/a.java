package com.facebook.c;

import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements c.a {
    private static final byte[] jWV = {-1, -40, -1};
    private static final int jWW = jWV.length;
    private static final byte[] jWX = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int jWY = jWX.length;
    private static final byte[] jWZ = e.GO("GIF87a");
    private static final byte[] jXa = e.GO("GIF89a");
    private static final byte[] jXb = e.GO("BM");
    private static final int jXc = jXb.length;
    final int jWU = com.facebook.common.internal.e.l(21, 20, jWW, jWY, 6, jXc);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.jWU;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c l(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.n(bArr, 0, i)) {
            return m(bArr, i);
        }
        if (n(bArr, i)) {
            return b.jXd;
        }
        if (o(bArr, i)) {
            return b.jXe;
        }
        if (p(bArr, i)) {
            return b.jXf;
        }
        if (q(bArr, i)) {
            return b.jXg;
        }
        return c.jXm;
    }

    private static c m(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.n(bArr, 0, i));
        if (com.facebook.common.g.c.i(bArr, 0)) {
            return b.jXh;
        }
        if (com.facebook.common.g.c.j(bArr, 0)) {
            return b.jXi;
        }
        if (com.facebook.common.g.c.m(bArr, 0, i)) {
            if (com.facebook.common.g.c.h(bArr, 0)) {
                return b.jXl;
            }
            if (com.facebook.common.g.c.k(bArr, 0)) {
                return b.jXk;
            }
            return b.jXj;
        }
        return c.jXm;
    }

    private static boolean n(byte[] bArr, int i) {
        return i >= jWV.length && e.c(bArr, jWV);
    }

    private static boolean o(byte[] bArr, int i) {
        return i >= jWX.length && e.c(bArr, jWX);
    }

    private static boolean p(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.c(bArr, jWZ) || e.c(bArr, jXa);
    }

    private static boolean q(byte[] bArr, int i) {
        if (i < jXb.length) {
            return false;
        }
        return e.c(bArr, jXb);
    }
}
