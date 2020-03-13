package com.facebook.c;

import com.coremedia.iso.boxes.FileTypeBox;
import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a implements c.a {
    final int lPq = com.facebook.common.internal.e.k(21, 20, lPs, lPu, 6, lPy, lPA);
    private static final byte[] lPr = {-1, -40, -1};
    private static final int lPs = lPr.length;
    private static final byte[] lPt = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int lPu = lPt.length;
    private static final byte[] lPv = e.OV("GIF87a");
    private static final byte[] lPw = e.OV("GIF89a");
    private static final byte[] lPx = e.OV("BM");
    private static final int lPy = lPx.length;
    private static final String[] lPz = {"heic", "heix", "hevc", "hevx"};
    private static final int lPA = e.OV(FileTypeBox.TYPE + lPz[0]).length;

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.lPq;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c r(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.r(bArr, 0, i)) {
            return s(bArr, i);
        }
        if (t(bArr, i)) {
            return b.lPB;
        }
        if (u(bArr, i)) {
            return b.lPC;
        }
        if (v(bArr, i)) {
            return b.lPD;
        }
        if (w(bArr, i)) {
            return b.lPE;
        }
        if (x(bArr, i)) {
            return b.lPK;
        }
        return c.lPL;
    }

    private static c s(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.r(bArr, 0, i));
        if (com.facebook.common.g.c.o(bArr, 0)) {
            return b.lPF;
        }
        if (com.facebook.common.g.c.p(bArr, 0)) {
            return b.lPG;
        }
        if (com.facebook.common.g.c.q(bArr, 0, i)) {
            if (com.facebook.common.g.c.n(bArr, 0)) {
                return b.lPJ;
            }
            if (com.facebook.common.g.c.q(bArr, 0)) {
                return b.lPI;
            }
            return b.lPH;
        }
        return c.lPL;
    }

    private static boolean t(byte[] bArr, int i) {
        return i >= lPr.length && e.d(bArr, lPr);
    }

    private static boolean u(byte[] bArr, int i) {
        return i >= lPt.length && e.d(bArr, lPt);
    }

    private static boolean v(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.d(bArr, lPv) || e.d(bArr, lPw);
    }

    private static boolean w(byte[] bArr, int i) {
        if (i < lPx.length) {
            return false;
        }
        return e.d(bArr, lPx);
    }

    private static boolean x(byte[] bArr, int i) {
        String[] strArr;
        if (i >= lPA && bArr[3] >= 8) {
            int length = lPz.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (e.c(bArr, bArr.length, e.OV(FileTypeBox.TYPE + strArr[i2]), lPA) > -1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
