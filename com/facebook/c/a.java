package com.facebook.c;

import com.coremedia.iso.boxes.FileTypeBox;
import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class a implements c.a {
    final int nRu = com.facebook.common.internal.e.m(21, 20, nRw, nRy, 6, nRC, nRE);
    private static final byte[] nRv = {-1, -40, -1};
    private static final int nRw = nRv.length;
    private static final byte[] nRx = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int nRy = nRx.length;
    private static final byte[] nRz = e.VM("GIF87a");
    private static final byte[] nRA = e.VM("GIF89a");
    private static final byte[] nRB = e.VM("BM");
    private static final int nRC = nRB.length;
    private static final String[] nRD = {"heic", "heix", "hevc", "hevx"};
    private static final int nRE = e.VM(FileTypeBox.TYPE + nRD[0]).length;

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.nRu;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c p(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.x(bArr, 0, i)) {
            return q(bArr, i);
        }
        if (r(bArr, i)) {
            return b.nRF;
        }
        if (s(bArr, i)) {
            return b.nRG;
        }
        if (t(bArr, i)) {
            return b.nRH;
        }
        if (u(bArr, i)) {
            return b.nRI;
        }
        if (v(bArr, i)) {
            return b.nRO;
        }
        return c.nRP;
    }

    private static c q(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.x(bArr, 0, i));
        if (com.facebook.common.g.c.m(bArr, 0)) {
            return b.nRJ;
        }
        if (com.facebook.common.g.c.n(bArr, 0)) {
            return b.nRK;
        }
        if (com.facebook.common.g.c.w(bArr, 0, i)) {
            if (com.facebook.common.g.c.l(bArr, 0)) {
                return b.nRN;
            }
            if (com.facebook.common.g.c.o(bArr, 0)) {
                return b.nRM;
            }
            return b.nRL;
        }
        return c.nRP;
    }

    private static boolean r(byte[] bArr, int i) {
        return i >= nRv.length && e.e(bArr, nRv);
    }

    private static boolean s(byte[] bArr, int i) {
        return i >= nRx.length && e.e(bArr, nRx);
    }

    private static boolean t(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.e(bArr, nRz) || e.e(bArr, nRA);
    }

    private static boolean u(byte[] bArr, int i) {
        if (i < nRB.length) {
            return false;
        }
        return e.e(bArr, nRB);
    }

    private static boolean v(byte[] bArr, int i) {
        String[] strArr;
        if (i >= nRE && bArr[3] >= 8) {
            int length = nRD.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (e.c(bArr, bArr.length, e.VM(FileTypeBox.TYPE + strArr[i2]), nRE) > -1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
