package com.facebook.c;

import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements c.a {
    private static final byte[] ioW = {-1, -40, -1};
    private static final int ioX = ioW.length;
    private static final byte[] ioY = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int ioZ = ioY.length;
    private static final byte[] ipa = e.zA("GIF87a");
    private static final byte[] ipb = e.zA("GIF89a");
    private static final byte[] ipc = e.zA("BM");
    private static final int ipd = ipc.length;
    final int ioV = com.facebook.common.internal.e.k(21, 20, ioX, ioZ, 6, ipd);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.ioV;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c j(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.m(bArr, 0, i)) {
            return k(bArr, i);
        }
        if (l(bArr, i)) {
            return b.ipe;
        }
        if (m(bArr, i)) {
            return b.ipf;
        }
        if (n(bArr, i)) {
            return b.ipg;
        }
        if (o(bArr, i)) {
            return b.iph;
        }
        return c.ipn;
    }

    private static c k(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.m(bArr, 0, i));
        if (com.facebook.common.g.c.g(bArr, 0)) {
            return b.ipi;
        }
        if (com.facebook.common.g.c.h(bArr, 0)) {
            return b.ipj;
        }
        if (com.facebook.common.g.c.l(bArr, 0, i)) {
            if (com.facebook.common.g.c.f(bArr, 0)) {
                return b.ipm;
            }
            if (com.facebook.common.g.c.i(bArr, 0)) {
                return b.ipl;
            }
            return b.ipk;
        }
        return c.ipn;
    }

    private static boolean l(byte[] bArr, int i) {
        return i >= ioW.length && e.d(bArr, ioW);
    }

    private static boolean m(byte[] bArr, int i) {
        return i >= ioY.length && e.d(bArr, ioY);
    }

    private static boolean n(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.d(bArr, ipa) || e.d(bArr, ipb);
    }

    private static boolean o(byte[] bArr, int i) {
        if (i < ipc.length) {
            return false;
        }
        return e.d(bArr, ipc);
    }
}
