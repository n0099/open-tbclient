package com.facebook.c;

import com.coremedia.iso.boxes.FileTypeBox;
import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class a implements c.a {
    private static final byte[] lKH = {-1, -40, -1};
    private static final int lKI = lKH.length;
    private static final byte[] lKJ = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int lKK = lKJ.length;
    private static final byte[] lKL = e.Ox("GIF87a");
    private static final byte[] lKM = e.Ox("GIF89a");
    private static final byte[] lKN = e.Ox("BM");
    private static final int lKO = lKN.length;
    private static final String[] lKP = {"heic", "heix", "hevc", "hevx"};
    private static final int lKQ = e.Ox(FileTypeBox.TYPE + lKP[0]).length;
    final int lKG = com.facebook.common.internal.e.l(21, 20, lKI, lKK, 6, lKO, lKQ);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.lKG;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c p(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.o(bArr, 0, i)) {
            return q(bArr, i);
        }
        if (r(bArr, i)) {
            return b.lKR;
        }
        if (s(bArr, i)) {
            return b.lKS;
        }
        if (t(bArr, i)) {
            return b.lKT;
        }
        if (u(bArr, i)) {
            return b.lKU;
        }
        if (v(bArr, i)) {
            return b.lLa;
        }
        return c.lLb;
    }

    private static c q(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.o(bArr, 0, i));
        if (com.facebook.common.g.c.m(bArr, 0)) {
            return b.lKV;
        }
        if (com.facebook.common.g.c.n(bArr, 0)) {
            return b.lKW;
        }
        if (com.facebook.common.g.c.n(bArr, 0, i)) {
            if (com.facebook.common.g.c.l(bArr, 0)) {
                return b.lKZ;
            }
            if (com.facebook.common.g.c.o(bArr, 0)) {
                return b.lKY;
            }
            return b.lKX;
        }
        return c.lLb;
    }

    private static boolean r(byte[] bArr, int i) {
        return i >= lKH.length && e.d(bArr, lKH);
    }

    private static boolean s(byte[] bArr, int i) {
        return i >= lKJ.length && e.d(bArr, lKJ);
    }

    private static boolean t(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.d(bArr, lKL) || e.d(bArr, lKM);
    }

    private static boolean u(byte[] bArr, int i) {
        if (i < lKN.length) {
            return false;
        }
        return e.d(bArr, lKN);
    }

    private static boolean v(byte[] bArr, int i) {
        String[] strArr;
        if (i >= lKQ && bArr[3] >= 8) {
            int length = lKP.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (e.a(bArr, bArr.length, e.Ox(FileTypeBox.TYPE + strArr[i2]), lKQ) > -1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
