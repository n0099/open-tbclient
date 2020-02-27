package com.facebook.c;

import com.coremedia.iso.boxes.FileTypeBox;
import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a implements c.a {
    private static final byte[] lPe = {-1, -40, -1};
    private static final int lPf = lPe.length;
    private static final byte[] lPg = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int lPh = lPg.length;
    private static final byte[] lPi = e.OU("GIF87a");
    private static final byte[] lPj = e.OU("GIF89a");
    private static final byte[] lPk = e.OU("BM");
    private static final int lPl = lPk.length;
    private static final String[] lPm = {"heic", "heix", "hevc", "hevx"};
    private static final int lPn = e.OU(FileTypeBox.TYPE + lPm[0]).length;
    final int lPd = com.facebook.common.internal.e.k(21, 20, lPf, lPh, 6, lPl, lPn);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.lPd;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c r(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.r(bArr, 0, i)) {
            return s(bArr, i);
        }
        if (t(bArr, i)) {
            return b.lPo;
        }
        if (u(bArr, i)) {
            return b.lPp;
        }
        if (v(bArr, i)) {
            return b.lPq;
        }
        if (w(bArr, i)) {
            return b.lPr;
        }
        if (x(bArr, i)) {
            return b.lPx;
        }
        return c.lPy;
    }

    private static c s(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.r(bArr, 0, i));
        if (com.facebook.common.g.c.o(bArr, 0)) {
            return b.lPs;
        }
        if (com.facebook.common.g.c.p(bArr, 0)) {
            return b.lPt;
        }
        if (com.facebook.common.g.c.q(bArr, 0, i)) {
            if (com.facebook.common.g.c.n(bArr, 0)) {
                return b.lPw;
            }
            if (com.facebook.common.g.c.q(bArr, 0)) {
                return b.lPv;
            }
            return b.lPu;
        }
        return c.lPy;
    }

    private static boolean t(byte[] bArr, int i) {
        return i >= lPe.length && e.d(bArr, lPe);
    }

    private static boolean u(byte[] bArr, int i) {
        return i >= lPg.length && e.d(bArr, lPg);
    }

    private static boolean v(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.d(bArr, lPi) || e.d(bArr, lPj);
    }

    private static boolean w(byte[] bArr, int i) {
        if (i < lPk.length) {
            return false;
        }
        return e.d(bArr, lPk);
    }

    private static boolean x(byte[] bArr, int i) {
        String[] strArr;
        if (i >= lPn && bArr[3] >= 8) {
            int length = lPm.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (e.c(bArr, bArr.length, e.OU(FileTypeBox.TYPE + strArr[i2]), lPn) > -1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
