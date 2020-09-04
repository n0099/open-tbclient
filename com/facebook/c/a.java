package com.facebook.c;

import com.coremedia.iso.boxes.FileTypeBox;
import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class a implements c.a {
    private static final byte[] nse = {-1, -40, -1};
    private static final int nsf = nse.length;
    private static final byte[] nsg = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int nsh = nsg.length;
    private static final byte[] nsi = e.Uw("GIF87a");
    private static final byte[] nsj = e.Uw("GIF89a");
    private static final byte[] nsk = e.Uw("BM");
    private static final int nsl = nsk.length;
    private static final String[] nsm = {"heic", "heix", "hevc", "hevx"};
    private static final int nsn = e.Uw(FileTypeBox.TYPE + nsm[0]).length;
    final int nsd = com.facebook.common.internal.e.n(21, 20, nsf, nsh, 6, nsl, nsn);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.nsd;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c o(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.v(bArr, 0, i)) {
            return p(bArr, i);
        }
        if (q(bArr, i)) {
            return b.nso;
        }
        if (r(bArr, i)) {
            return b.nsp;
        }
        if (s(bArr, i)) {
            return b.nsq;
        }
        if (t(bArr, i)) {
            return b.nsr;
        }
        if (u(bArr, i)) {
            return b.nsx;
        }
        return c.nsy;
    }

    private static c p(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.v(bArr, 0, i));
        if (com.facebook.common.g.c.l(bArr, 0)) {
            return b.nss;
        }
        if (com.facebook.common.g.c.m(bArr, 0)) {
            return b.nst;
        }
        if (com.facebook.common.g.c.u(bArr, 0, i)) {
            if (com.facebook.common.g.c.k(bArr, 0)) {
                return b.nsw;
            }
            if (com.facebook.common.g.c.n(bArr, 0)) {
                return b.nsv;
            }
            return b.nsu;
        }
        return c.nsy;
    }

    private static boolean q(byte[] bArr, int i) {
        return i >= nse.length && e.e(bArr, nse);
    }

    private static boolean r(byte[] bArr, int i) {
        return i >= nsg.length && e.e(bArr, nsg);
    }

    private static boolean s(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.e(bArr, nsi) || e.e(bArr, nsj);
    }

    private static boolean t(byte[] bArr, int i) {
        if (i < nsk.length) {
            return false;
        }
        return e.e(bArr, nsk);
    }

    private static boolean u(byte[] bArr, int i) {
        String[] strArr;
        if (i >= nsn && bArr[3] >= 8) {
            int length = nsm.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (e.c(bArr, bArr.length, e.Uw(FileTypeBox.TYPE + strArr[i2]), nsn) > -1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
