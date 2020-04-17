package com.facebook.c;

import com.coremedia.iso.boxes.FileTypeBox;
import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a implements c.a {
    private static final byte[] lYC = {-1, -40, -1};
    private static final int lYD = lYC.length;
    private static final byte[] lYE = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int lYF = lYE.length;
    private static final byte[] lYG = e.Oc("GIF87a");
    private static final byte[] lYH = e.Oc("GIF89a");
    private static final byte[] lYI = e.Oc("BM");
    private static final int lYJ = lYI.length;
    private static final String[] lYK = {"heic", "heix", "hevc", "hevx"};
    private static final int lYL = e.Oc(FileTypeBox.TYPE + lYK[0]).length;
    final int lYB = com.facebook.common.internal.e.m(21, 20, lYD, lYF, 6, lYJ, lYL);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.lYB;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c n(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.s(bArr, 0, i)) {
            return o(bArr, i);
        }
        if (p(bArr, i)) {
            return b.lYM;
        }
        if (q(bArr, i)) {
            return b.lYN;
        }
        if (r(bArr, i)) {
            return b.lYO;
        }
        if (s(bArr, i)) {
            return b.lYP;
        }
        if (t(bArr, i)) {
            return b.lYV;
        }
        return c.lYW;
    }

    private static c o(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.s(bArr, 0, i));
        if (com.facebook.common.g.c.k(bArr, 0)) {
            return b.lYQ;
        }
        if (com.facebook.common.g.c.l(bArr, 0)) {
            return b.lYR;
        }
        if (com.facebook.common.g.c.r(bArr, 0, i)) {
            if (com.facebook.common.g.c.j(bArr, 0)) {
                return b.lYU;
            }
            if (com.facebook.common.g.c.m(bArr, 0)) {
                return b.lYT;
            }
            return b.lYS;
        }
        return c.lYW;
    }

    private static boolean p(byte[] bArr, int i) {
        return i >= lYC.length && e.d(bArr, lYC);
    }

    private static boolean q(byte[] bArr, int i) {
        return i >= lYE.length && e.d(bArr, lYE);
    }

    private static boolean r(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.d(bArr, lYG) || e.d(bArr, lYH);
    }

    private static boolean s(byte[] bArr, int i) {
        if (i < lYI.length) {
            return false;
        }
        return e.d(bArr, lYI);
    }

    private static boolean t(byte[] bArr, int i) {
        String[] strArr;
        if (i >= lYL && bArr[3] >= 8) {
            int length = lYK.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (e.c(bArr, bArr.length, e.Oc(FileTypeBox.TYPE + strArr[i2]), lYL) > -1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
