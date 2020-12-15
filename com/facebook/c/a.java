package com.facebook.c;

import com.coremedia.iso.boxes.FileTypeBox;
import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class a implements c.a {
    private static final byte[] piK = {-1, -40, -1};
    private static final int piL = piK.length;
    private static final byte[] piM = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int piN = piM.length;
    private static final byte[] piO = e.Zj("GIF87a");
    private static final byte[] piP = e.Zj("GIF89a");
    private static final byte[] piQ = e.Zj("BM");
    private static final int piR = piQ.length;
    private static final String[] piS = {"heic", "heix", "hevc", "hevx"};
    private static final int piT = e.Zj(FileTypeBox.TYPE + piS[0]).length;
    final int piJ = com.facebook.common.internal.e.r(21, 20, piL, piN, 6, piR, piT);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.piJ;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c q(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.x(bArr, 0, i)) {
            return r(bArr, i);
        }
        if (s(bArr, i)) {
            return b.piU;
        }
        if (t(bArr, i)) {
            return b.piV;
        }
        if (u(bArr, i)) {
            return b.piW;
        }
        if (v(bArr, i)) {
            return b.piX;
        }
        if (w(bArr, i)) {
            return b.pjd;
        }
        return c.pje;
    }

    private static c r(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.x(bArr, 0, i));
        if (com.facebook.common.g.c.n(bArr, 0)) {
            return b.piY;
        }
        if (com.facebook.common.g.c.o(bArr, 0)) {
            return b.piZ;
        }
        if (com.facebook.common.g.c.w(bArr, 0, i)) {
            if (com.facebook.common.g.c.m(bArr, 0)) {
                return b.pjc;
            }
            if (com.facebook.common.g.c.p(bArr, 0)) {
                return b.pjb;
            }
            return b.pja;
        }
        return c.pje;
    }

    private static boolean s(byte[] bArr, int i) {
        return i >= piK.length && e.e(bArr, piK);
    }

    private static boolean t(byte[] bArr, int i) {
        return i >= piM.length && e.e(bArr, piM);
    }

    private static boolean u(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.e(bArr, piO) || e.e(bArr, piP);
    }

    private static boolean v(byte[] bArr, int i) {
        if (i < piQ.length) {
            return false;
        }
        return e.e(bArr, piQ);
    }

    private static boolean w(byte[] bArr, int i) {
        String[] strArr;
        if (i >= piT && bArr[3] >= 8) {
            int length = piS.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (e.c(bArr, bArr.length, e.Zj(FileTypeBox.TYPE + strArr[i2]), piT) > -1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
