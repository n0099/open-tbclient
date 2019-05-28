package com.facebook.c;

import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements c.a {
    private static final byte[] jWW = {-1, -40, -1};
    private static final int jWX = jWW.length;
    private static final byte[] jWY = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int jWZ = jWY.length;
    private static final byte[] jXa = e.GO("GIF87a");
    private static final byte[] jXb = e.GO("GIF89a");
    private static final byte[] jXc = e.GO("BM");
    private static final int jXd = jXc.length;
    final int jWV = com.facebook.common.internal.e.l(21, 20, jWX, jWZ, 6, jXd);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.jWV;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c l(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.n(bArr, 0, i)) {
            return m(bArr, i);
        }
        if (n(bArr, i)) {
            return b.jXe;
        }
        if (o(bArr, i)) {
            return b.jXf;
        }
        if (p(bArr, i)) {
            return b.jXg;
        }
        if (q(bArr, i)) {
            return b.jXh;
        }
        return c.jXn;
    }

    private static c m(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.n(bArr, 0, i));
        if (com.facebook.common.g.c.i(bArr, 0)) {
            return b.jXi;
        }
        if (com.facebook.common.g.c.j(bArr, 0)) {
            return b.jXj;
        }
        if (com.facebook.common.g.c.m(bArr, 0, i)) {
            if (com.facebook.common.g.c.h(bArr, 0)) {
                return b.jXm;
            }
            if (com.facebook.common.g.c.k(bArr, 0)) {
                return b.jXl;
            }
            return b.jXk;
        }
        return c.jXn;
    }

    private static boolean n(byte[] bArr, int i) {
        return i >= jWW.length && e.c(bArr, jWW);
    }

    private static boolean o(byte[] bArr, int i) {
        return i >= jWY.length && e.c(bArr, jWY);
    }

    private static boolean p(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.c(bArr, jXa) || e.c(bArr, jXb);
    }

    private static boolean q(byte[] bArr, int i) {
        if (i < jXc.length) {
            return false;
        }
        return e.c(bArr, jXc);
    }
}
