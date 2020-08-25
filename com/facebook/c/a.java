package com.facebook.c;

import com.coremedia.iso.boxes.FileTypeBox;
import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class a implements c.a {
    private static final byte[] nrM = {-1, -40, -1};
    private static final int nrN = nrM.length;
    private static final byte[] nrO = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int nrP = nrO.length;
    private static final byte[] nrQ = e.Uw("GIF87a");
    private static final byte[] nrR = e.Uw("GIF89a");
    private static final byte[] nrS = e.Uw("BM");
    private static final int nrT = nrS.length;
    private static final String[] nrU = {"heic", "heix", "hevc", "hevx"};
    private static final int nrV = e.Uw(FileTypeBox.TYPE + nrU[0]).length;
    final int nrL = com.facebook.common.internal.e.n(21, 20, nrN, nrP, 6, nrT, nrV);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.nrL;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c o(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.v(bArr, 0, i)) {
            return p(bArr, i);
        }
        if (q(bArr, i)) {
            return b.nrW;
        }
        if (r(bArr, i)) {
            return b.nrX;
        }
        if (s(bArr, i)) {
            return b.nrY;
        }
        if (t(bArr, i)) {
            return b.nrZ;
        }
        if (u(bArr, i)) {
            return b.nsf;
        }
        return c.nsg;
    }

    private static c p(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.v(bArr, 0, i));
        if (com.facebook.common.g.c.l(bArr, 0)) {
            return b.nsa;
        }
        if (com.facebook.common.g.c.m(bArr, 0)) {
            return b.nsb;
        }
        if (com.facebook.common.g.c.u(bArr, 0, i)) {
            if (com.facebook.common.g.c.k(bArr, 0)) {
                return b.nse;
            }
            if (com.facebook.common.g.c.n(bArr, 0)) {
                return b.nsd;
            }
            return b.nsc;
        }
        return c.nsg;
    }

    private static boolean q(byte[] bArr, int i) {
        return i >= nrM.length && e.e(bArr, nrM);
    }

    private static boolean r(byte[] bArr, int i) {
        return i >= nrO.length && e.e(bArr, nrO);
    }

    private static boolean s(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.e(bArr, nrQ) || e.e(bArr, nrR);
    }

    private static boolean t(byte[] bArr, int i) {
        if (i < nrS.length) {
            return false;
        }
        return e.e(bArr, nrS);
    }

    private static boolean u(byte[] bArr, int i) {
        String[] strArr;
        if (i >= nrV && bArr[3] >= 8) {
            int length = nrU.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (e.c(bArr, bArr.length, e.Uw(FileTypeBox.TYPE + strArr[i2]), nrV) > -1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
