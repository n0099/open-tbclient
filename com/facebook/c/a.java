package com.facebook.c;

import com.coremedia.iso.boxes.FileTypeBox;
import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class a implements c.a {
    private static final byte[] piI = {-1, -40, -1};
    private static final int piJ = piI.length;
    private static final byte[] piK = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int piL = piK.length;
    private static final byte[] piM = e.Zj("GIF87a");
    private static final byte[] piN = e.Zj("GIF89a");
    private static final byte[] piO = e.Zj("BM");
    private static final int piP = piO.length;
    private static final String[] piQ = {"heic", "heix", "hevc", "hevx"};
    private static final int piR = e.Zj(FileTypeBox.TYPE + piQ[0]).length;
    final int piH = com.facebook.common.internal.e.r(21, 20, piJ, piL, 6, piP, piR);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.piH;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c q(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.x(bArr, 0, i)) {
            return r(bArr, i);
        }
        if (s(bArr, i)) {
            return b.piS;
        }
        if (t(bArr, i)) {
            return b.piT;
        }
        if (u(bArr, i)) {
            return b.piU;
        }
        if (v(bArr, i)) {
            return b.piV;
        }
        if (w(bArr, i)) {
            return b.pjb;
        }
        return c.pjc;
    }

    private static c r(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.x(bArr, 0, i));
        if (com.facebook.common.g.c.n(bArr, 0)) {
            return b.piW;
        }
        if (com.facebook.common.g.c.o(bArr, 0)) {
            return b.piX;
        }
        if (com.facebook.common.g.c.w(bArr, 0, i)) {
            if (com.facebook.common.g.c.m(bArr, 0)) {
                return b.pja;
            }
            if (com.facebook.common.g.c.p(bArr, 0)) {
                return b.piZ;
            }
            return b.piY;
        }
        return c.pjc;
    }

    private static boolean s(byte[] bArr, int i) {
        return i >= piI.length && e.e(bArr, piI);
    }

    private static boolean t(byte[] bArr, int i) {
        return i >= piK.length && e.e(bArr, piK);
    }

    private static boolean u(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.e(bArr, piM) || e.e(bArr, piN);
    }

    private static boolean v(byte[] bArr, int i) {
        if (i < piO.length) {
            return false;
        }
        return e.e(bArr, piO);
    }

    private static boolean w(byte[] bArr, int i) {
        String[] strArr;
        if (i >= piR && bArr[3] >= 8) {
            int length = piQ.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (e.c(bArr, bArr.length, e.Zj(FileTypeBox.TYPE + strArr[i2]), piR) > -1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
