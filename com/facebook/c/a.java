package com.facebook.c;

import com.coremedia.iso.boxes.FileTypeBox;
import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a implements c.a {
    private static final byte[] mPN = {-1, -40, -1};
    private static final int mPO = mPN.length;
    private static final byte[] mPP = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int mPQ = mPP.length;
    private static final byte[] mPR = e.QH("GIF87a");
    private static final byte[] mPS = e.QH("GIF89a");
    private static final byte[] mPT = e.QH("BM");
    private static final int mPU = mPT.length;
    private static final String[] mPV = {"heic", "heix", "hevc", "hevx"};
    private static final int mPW = e.QH(FileTypeBox.TYPE + mPV[0]).length;
    final int mPM = com.facebook.common.internal.e.m(21, 20, mPO, mPQ, 6, mPU, mPW);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.mPM;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c o(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.t(bArr, 0, i)) {
            return p(bArr, i);
        }
        if (q(bArr, i)) {
            return b.mPX;
        }
        if (r(bArr, i)) {
            return b.mPY;
        }
        if (s(bArr, i)) {
            return b.mPZ;
        }
        if (t(bArr, i)) {
            return b.mQa;
        }
        if (u(bArr, i)) {
            return b.mQg;
        }
        return c.mQh;
    }

    private static c p(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.t(bArr, 0, i));
        if (com.facebook.common.g.c.l(bArr, 0)) {
            return b.mQb;
        }
        if (com.facebook.common.g.c.m(bArr, 0)) {
            return b.mQc;
        }
        if (com.facebook.common.g.c.s(bArr, 0, i)) {
            if (com.facebook.common.g.c.k(bArr, 0)) {
                return b.mQf;
            }
            if (com.facebook.common.g.c.n(bArr, 0)) {
                return b.mQe;
            }
            return b.mQd;
        }
        return c.mQh;
    }

    private static boolean q(byte[] bArr, int i) {
        return i >= mPN.length && e.e(bArr, mPN);
    }

    private static boolean r(byte[] bArr, int i) {
        return i >= mPP.length && e.e(bArr, mPP);
    }

    private static boolean s(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.e(bArr, mPR) || e.e(bArr, mPS);
    }

    private static boolean t(byte[] bArr, int i) {
        if (i < mPT.length) {
            return false;
        }
        return e.e(bArr, mPT);
    }

    private static boolean u(byte[] bArr, int i) {
        String[] strArr;
        if (i >= mPW && bArr[3] >= 8) {
            int length = mPV.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (e.c(bArr, bArr.length, e.QH(FileTypeBox.TYPE + strArr[i2]), mPW) > -1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
