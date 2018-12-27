package com.facebook.c;

import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements c.a {
    private static final byte[] inO = {-1, -40, -1};
    private static final int inP = inO.length;
    private static final byte[] inQ = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int inR = inQ.length;
    private static final byte[] inS = e.zk("GIF87a");
    private static final byte[] inT = e.zk("GIF89a");
    private static final byte[] inU = e.zk("BM");
    private static final int inV = inU.length;
    final int inN = com.facebook.common.internal.e.k(21, 20, inP, inR, 6, inV);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.inN;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c j(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.m(bArr, 0, i)) {
            return k(bArr, i);
        }
        if (l(bArr, i)) {
            return b.inW;
        }
        if (m(bArr, i)) {
            return b.inX;
        }
        if (n(bArr, i)) {
            return b.inY;
        }
        if (o(bArr, i)) {
            return b.inZ;
        }
        return c.iof;
    }

    private static c k(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.m(bArr, 0, i));
        if (com.facebook.common.g.c.g(bArr, 0)) {
            return b.ioa;
        }
        if (com.facebook.common.g.c.h(bArr, 0)) {
            return b.iob;
        }
        if (com.facebook.common.g.c.l(bArr, 0, i)) {
            if (com.facebook.common.g.c.f(bArr, 0)) {
                return b.ioe;
            }
            if (com.facebook.common.g.c.i(bArr, 0)) {
                return b.iod;
            }
            return b.ioc;
        }
        return c.iof;
    }

    private static boolean l(byte[] bArr, int i) {
        return i >= inO.length && e.d(bArr, inO);
    }

    private static boolean m(byte[] bArr, int i) {
        return i >= inQ.length && e.d(bArr, inQ);
    }

    private static boolean n(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.d(bArr, inS) || e.d(bArr, inT);
    }

    private static boolean o(byte[] bArr, int i) {
        if (i < inU.length) {
            return false;
        }
        return e.d(bArr, inU);
    }
}
