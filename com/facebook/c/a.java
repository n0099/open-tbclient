package com.facebook.c;

import com.coremedia.iso.boxes.FileTypeBox;
import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class a implements c.a {
    final int lOw = com.facebook.common.internal.e.l(21, 20, lOy, lOA, 6, lOE, lOG);
    private static final byte[] lOx = {-1, -40, -1};
    private static final int lOy = lOx.length;
    private static final byte[] lOz = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int lOA = lOz.length;
    private static final byte[] lOB = e.OH("GIF87a");
    private static final byte[] lOC = e.OH("GIF89a");
    private static final byte[] lOD = e.OH("BM");
    private static final int lOE = lOD.length;
    private static final String[] lOF = {"heic", "heix", "hevc", "hevx"};
    private static final int lOG = e.OH(FileTypeBox.TYPE + lOF[0]).length;

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.lOw;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c p(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.n(bArr, 0, i)) {
            return q(bArr, i);
        }
        if (r(bArr, i)) {
            return b.lOH;
        }
        if (s(bArr, i)) {
            return b.lOI;
        }
        if (t(bArr, i)) {
            return b.lOJ;
        }
        if (u(bArr, i)) {
            return b.lOK;
        }
        if (v(bArr, i)) {
            return b.lOQ;
        }
        return c.lOR;
    }

    private static c q(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.n(bArr, 0, i));
        if (com.facebook.common.g.c.m(bArr, 0)) {
            return b.lOL;
        }
        if (com.facebook.common.g.c.n(bArr, 0)) {
            return b.lOM;
        }
        if (com.facebook.common.g.c.m(bArr, 0, i)) {
            if (com.facebook.common.g.c.l(bArr, 0)) {
                return b.lOP;
            }
            if (com.facebook.common.g.c.o(bArr, 0)) {
                return b.lOO;
            }
            return b.lON;
        }
        return c.lOR;
    }

    private static boolean r(byte[] bArr, int i) {
        return i >= lOx.length && e.d(bArr, lOx);
    }

    private static boolean s(byte[] bArr, int i) {
        return i >= lOz.length && e.d(bArr, lOz);
    }

    private static boolean t(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.d(bArr, lOB) || e.d(bArr, lOC);
    }

    private static boolean u(byte[] bArr, int i) {
        if (i < lOD.length) {
            return false;
        }
        return e.d(bArr, lOD);
    }

    private static boolean v(byte[] bArr, int i) {
        String[] strArr;
        if (i >= lOG && bArr[3] >= 8) {
            int length = lOF.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (e.a(bArr, bArr.length, e.OH(FileTypeBox.TYPE + strArr[i2]), lOG) > -1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
