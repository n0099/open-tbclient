package com.facebook.c;

import com.coremedia.iso.boxes.FileTypeBox;
import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes17.dex */
public class a implements c.a {
    private static final byte[] oTJ = {-1, -40, -1};
    private static final int oTK = oTJ.length;
    private static final byte[] oTL = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int oTM = oTL.length;
    private static final byte[] oTN = e.XO("GIF87a");
    private static final byte[] oTO = e.XO("GIF89a");
    private static final byte[] oTP = e.XO("BM");
    private static final int oTQ = oTP.length;
    private static final String[] oTR = {"heic", "heix", "hevc", "hevx"};
    private static final int oTS = e.XO(FileTypeBox.TYPE + oTR[0]).length;
    final int oTI = com.facebook.common.internal.e.r(21, 20, oTK, oTM, 6, oTQ, oTS);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.oTI;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c p(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.x(bArr, 0, i)) {
            return q(bArr, i);
        }
        if (r(bArr, i)) {
            return b.oTT;
        }
        if (s(bArr, i)) {
            return b.oTU;
        }
        if (t(bArr, i)) {
            return b.oTV;
        }
        if (u(bArr, i)) {
            return b.oTW;
        }
        if (v(bArr, i)) {
            return b.oUc;
        }
        return c.oUd;
    }

    private static c q(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.x(bArr, 0, i));
        if (com.facebook.common.g.c.m(bArr, 0)) {
            return b.oTX;
        }
        if (com.facebook.common.g.c.n(bArr, 0)) {
            return b.oTY;
        }
        if (com.facebook.common.g.c.w(bArr, 0, i)) {
            if (com.facebook.common.g.c.l(bArr, 0)) {
                return b.oUb;
            }
            if (com.facebook.common.g.c.o(bArr, 0)) {
                return b.oUa;
            }
            return b.oTZ;
        }
        return c.oUd;
    }

    private static boolean r(byte[] bArr, int i) {
        return i >= oTJ.length && e.e(bArr, oTJ);
    }

    private static boolean s(byte[] bArr, int i) {
        return i >= oTL.length && e.e(bArr, oTL);
    }

    private static boolean t(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.e(bArr, oTN) || e.e(bArr, oTO);
    }

    private static boolean u(byte[] bArr, int i) {
        if (i < oTP.length) {
            return false;
        }
        return e.e(bArr, oTP);
    }

    private static boolean v(byte[] bArr, int i) {
        String[] strArr;
        if (i >= oTS && bArr[3] >= 8) {
            int length = oTR.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (e.c(bArr, bArr.length, e.XO(FileTypeBox.TYPE + strArr[i2]), oTS) > -1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
