package com.facebook.c;

import com.coremedia.iso.boxes.FileTypeBox;
import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a implements c.a {
    private static final byte[] lYG = {-1, -40, -1};
    private static final int lYH = lYG.length;
    private static final byte[] lYI = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int lYJ = lYI.length;
    private static final byte[] lYK = e.Of("GIF87a");
    private static final byte[] lYL = e.Of("GIF89a");
    private static final byte[] lYM = e.Of("BM");
    private static final int lYN = lYM.length;
    private static final String[] lYO = {"heic", "heix", "hevc", "hevx"};
    private static final int lYP = e.Of(FileTypeBox.TYPE + lYO[0]).length;
    final int lYF = com.facebook.common.internal.e.m(21, 20, lYH, lYJ, 6, lYN, lYP);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.lYF;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c n(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.s(bArr, 0, i)) {
            return o(bArr, i);
        }
        if (p(bArr, i)) {
            return b.lYQ;
        }
        if (q(bArr, i)) {
            return b.lYR;
        }
        if (r(bArr, i)) {
            return b.lYS;
        }
        if (s(bArr, i)) {
            return b.lYT;
        }
        if (t(bArr, i)) {
            return b.lYZ;
        }
        return c.lZa;
    }

    private static c o(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.s(bArr, 0, i));
        if (com.facebook.common.g.c.k(bArr, 0)) {
            return b.lYU;
        }
        if (com.facebook.common.g.c.l(bArr, 0)) {
            return b.lYV;
        }
        if (com.facebook.common.g.c.r(bArr, 0, i)) {
            if (com.facebook.common.g.c.j(bArr, 0)) {
                return b.lYY;
            }
            if (com.facebook.common.g.c.m(bArr, 0)) {
                return b.lYX;
            }
            return b.lYW;
        }
        return c.lZa;
    }

    private static boolean p(byte[] bArr, int i) {
        return i >= lYG.length && e.d(bArr, lYG);
    }

    private static boolean q(byte[] bArr, int i) {
        return i >= lYI.length && e.d(bArr, lYI);
    }

    private static boolean r(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.d(bArr, lYK) || e.d(bArr, lYL);
    }

    private static boolean s(byte[] bArr, int i) {
        if (i < lYM.length) {
            return false;
        }
        return e.d(bArr, lYM);
    }

    private static boolean t(byte[] bArr, int i) {
        String[] strArr;
        if (i >= lYP && bArr[3] >= 8) {
            int length = lYO.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (e.c(bArr, bArr.length, e.Of(FileTypeBox.TYPE + strArr[i2]), lYP) > -1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
