package com.facebook.c;

import com.coremedia.iso.boxes.FileTypeBox;
import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a implements c.a {
    private static final byte[] msB = {-1, -40, -1};
    private static final int msC = msB.length;
    private static final byte[] msD = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int msE = msD.length;
    private static final byte[] msF = e.PT("GIF87a");
    private static final byte[] msG = e.PT("GIF89a");
    private static final byte[] msH = e.PT("BM");
    private static final int msI = msH.length;
    private static final String[] msJ = {"heic", "heix", "hevc", "hevx"};
    private static final int msK = e.PT(FileTypeBox.TYPE + msJ[0]).length;
    final int msA = com.facebook.common.internal.e.m(21, 20, msC, msE, 6, msI, msK);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.msA;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c o(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.t(bArr, 0, i)) {
            return p(bArr, i);
        }
        if (q(bArr, i)) {
            return b.msL;
        }
        if (r(bArr, i)) {
            return b.msM;
        }
        if (s(bArr, i)) {
            return b.msN;
        }
        if (t(bArr, i)) {
            return b.msO;
        }
        if (u(bArr, i)) {
            return b.msU;
        }
        return c.msV;
    }

    private static c p(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.t(bArr, 0, i));
        if (com.facebook.common.g.c.l(bArr, 0)) {
            return b.msP;
        }
        if (com.facebook.common.g.c.m(bArr, 0)) {
            return b.msQ;
        }
        if (com.facebook.common.g.c.s(bArr, 0, i)) {
            if (com.facebook.common.g.c.k(bArr, 0)) {
                return b.msT;
            }
            if (com.facebook.common.g.c.n(bArr, 0)) {
                return b.msS;
            }
            return b.msR;
        }
        return c.msV;
    }

    private static boolean q(byte[] bArr, int i) {
        return i >= msB.length && e.e(bArr, msB);
    }

    private static boolean r(byte[] bArr, int i) {
        return i >= msD.length && e.e(bArr, msD);
    }

    private static boolean s(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.e(bArr, msF) || e.e(bArr, msG);
    }

    private static boolean t(byte[] bArr, int i) {
        if (i < msH.length) {
            return false;
        }
        return e.e(bArr, msH);
    }

    private static boolean u(byte[] bArr, int i) {
        String[] strArr;
        if (i >= msK && bArr[3] >= 8) {
            int length = msJ.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (e.c(bArr, bArr.length, e.PT(FileTypeBox.TYPE + strArr[i2]), msK) > -1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
