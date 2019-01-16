package com.facebook.c;

import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements c.a {
    private static final byte[] ioV = {-1, -40, -1};
    private static final int ioW = ioV.length;
    private static final byte[] ioX = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int ioY = ioX.length;
    private static final byte[] ioZ = e.zA("GIF87a");
    private static final byte[] ipa = e.zA("GIF89a");
    private static final byte[] ipb = e.zA("BM");
    private static final int ipc = ipb.length;
    final int ioU = com.facebook.common.internal.e.k(21, 20, ioW, ioY, 6, ipc);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.ioU;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c j(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.m(bArr, 0, i)) {
            return k(bArr, i);
        }
        if (l(bArr, i)) {
            return b.ipd;
        }
        if (m(bArr, i)) {
            return b.ipe;
        }
        if (n(bArr, i)) {
            return b.ipf;
        }
        if (o(bArr, i)) {
            return b.ipg;
        }
        return c.ipm;
    }

    private static c k(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.m(bArr, 0, i));
        if (com.facebook.common.g.c.g(bArr, 0)) {
            return b.iph;
        }
        if (com.facebook.common.g.c.h(bArr, 0)) {
            return b.ipi;
        }
        if (com.facebook.common.g.c.l(bArr, 0, i)) {
            if (com.facebook.common.g.c.f(bArr, 0)) {
                return b.ipl;
            }
            if (com.facebook.common.g.c.i(bArr, 0)) {
                return b.ipk;
            }
            return b.ipj;
        }
        return c.ipm;
    }

    private static boolean l(byte[] bArr, int i) {
        return i >= ioV.length && e.d(bArr, ioV);
    }

    private static boolean m(byte[] bArr, int i) {
        return i >= ioX.length && e.d(bArr, ioX);
    }

    private static boolean n(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.d(bArr, ioZ) || e.d(bArr, ipa);
    }

    private static boolean o(byte[] bArr, int i) {
        if (i < ipb.length) {
            return false;
        }
        return e.d(bArr, ipb);
    }
}
