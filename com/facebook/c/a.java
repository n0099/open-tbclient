package com.facebook.c;

import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements c.a {
    private static final byte[] idq = {-1, -40, -1};
    private static final int idr = idq.length;
    private static final byte[] idu = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int idv = idu.length;
    private static final byte[] idw = e.yE("GIF87a");
    private static final byte[] idx = e.yE("GIF89a");
    private static final byte[] idy = e.yE("BM");
    private static final int idz = idy.length;
    final int idp = com.facebook.common.internal.e.k(21, 20, idr, idv, 6, idz);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.idp;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c j(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.m(bArr, 0, i)) {
            return k(bArr, i);
        }
        if (l(bArr, i)) {
            return b.idA;
        }
        if (m(bArr, i)) {
            return b.idB;
        }
        if (n(bArr, i)) {
            return b.idC;
        }
        if (o(bArr, i)) {
            return b.idD;
        }
        return c.idJ;
    }

    private static c k(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.m(bArr, 0, i));
        if (com.facebook.common.g.c.g(bArr, 0)) {
            return b.idE;
        }
        if (com.facebook.common.g.c.h(bArr, 0)) {
            return b.idF;
        }
        if (com.facebook.common.g.c.l(bArr, 0, i)) {
            if (com.facebook.common.g.c.f(bArr, 0)) {
                return b.idI;
            }
            if (com.facebook.common.g.c.i(bArr, 0)) {
                return b.idH;
            }
            return b.idG;
        }
        return c.idJ;
    }

    private static boolean l(byte[] bArr, int i) {
        return i >= idq.length && e.d(bArr, idq);
    }

    private static boolean m(byte[] bArr, int i) {
        return i >= idu.length && e.d(bArr, idu);
    }

    private static boolean n(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.d(bArr, idw) || e.d(bArr, idx);
    }

    private static boolean o(byte[] bArr, int i) {
        if (i < idy.length) {
            return false;
        }
        return e.d(bArr, idy);
    }
}
