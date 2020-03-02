package com.facebook.c;

import com.coremedia.iso.boxes.FileTypeBox;
import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a implements c.a {
    private static final byte[] lPg = {-1, -40, -1};
    private static final int lPh = lPg.length;
    private static final byte[] lPi = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int lPj = lPi.length;
    private static final byte[] lPk = e.OU("GIF87a");
    private static final byte[] lPl = e.OU("GIF89a");
    private static final byte[] lPm = e.OU("BM");
    private static final int lPn = lPm.length;
    private static final String[] lPo = {"heic", "heix", "hevc", "hevx"};
    private static final int lPp = e.OU(FileTypeBox.TYPE + lPo[0]).length;
    final int lPf = com.facebook.common.internal.e.k(21, 20, lPh, lPj, 6, lPn, lPp);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.lPf;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c r(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.r(bArr, 0, i)) {
            return s(bArr, i);
        }
        if (t(bArr, i)) {
            return b.lPq;
        }
        if (u(bArr, i)) {
            return b.lPr;
        }
        if (v(bArr, i)) {
            return b.lPs;
        }
        if (w(bArr, i)) {
            return b.lPt;
        }
        if (x(bArr, i)) {
            return b.lPz;
        }
        return c.lPA;
    }

    private static c s(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.r(bArr, 0, i));
        if (com.facebook.common.g.c.o(bArr, 0)) {
            return b.lPu;
        }
        if (com.facebook.common.g.c.p(bArr, 0)) {
            return b.lPv;
        }
        if (com.facebook.common.g.c.q(bArr, 0, i)) {
            if (com.facebook.common.g.c.n(bArr, 0)) {
                return b.lPy;
            }
            if (com.facebook.common.g.c.q(bArr, 0)) {
                return b.lPx;
            }
            return b.lPw;
        }
        return c.lPA;
    }

    private static boolean t(byte[] bArr, int i) {
        return i >= lPg.length && e.d(bArr, lPg);
    }

    private static boolean u(byte[] bArr, int i) {
        return i >= lPi.length && e.d(bArr, lPi);
    }

    private static boolean v(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.d(bArr, lPk) || e.d(bArr, lPl);
    }

    private static boolean w(byte[] bArr, int i) {
        if (i < lPm.length) {
            return false;
        }
        return e.d(bArr, lPm);
    }

    private static boolean x(byte[] bArr, int i) {
        String[] strArr;
        if (i >= lPp && bArr[3] >= 8) {
            int length = lPo.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (e.c(bArr, bArr.length, e.OU(FileTypeBox.TYPE + strArr[i2]), lPp) > -1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
