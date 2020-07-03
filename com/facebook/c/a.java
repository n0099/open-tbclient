package com.facebook.c;

import com.coremedia.iso.boxes.FileTypeBox;
import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a implements c.a {
    private static final byte[] mPK = {-1, -40, -1};
    private static final int mPL = mPK.length;
    private static final byte[] mPM = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int mPN = mPM.length;
    private static final byte[] mPO = e.QG("GIF87a");
    private static final byte[] mPP = e.QG("GIF89a");
    private static final byte[] mPQ = e.QG("BM");
    private static final int mPR = mPQ.length;
    private static final String[] mPS = {"heic", "heix", "hevc", "hevx"};
    private static final int mPT = e.QG(FileTypeBox.TYPE + mPS[0]).length;
    final int mPJ = com.facebook.common.internal.e.m(21, 20, mPL, mPN, 6, mPR, mPT);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.mPJ;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c o(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.t(bArr, 0, i)) {
            return p(bArr, i);
        }
        if (q(bArr, i)) {
            return b.mPU;
        }
        if (r(bArr, i)) {
            return b.mPV;
        }
        if (s(bArr, i)) {
            return b.mPW;
        }
        if (t(bArr, i)) {
            return b.mPX;
        }
        if (u(bArr, i)) {
            return b.mQd;
        }
        return c.mQe;
    }

    private static c p(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.t(bArr, 0, i));
        if (com.facebook.common.g.c.l(bArr, 0)) {
            return b.mPY;
        }
        if (com.facebook.common.g.c.m(bArr, 0)) {
            return b.mPZ;
        }
        if (com.facebook.common.g.c.s(bArr, 0, i)) {
            if (com.facebook.common.g.c.k(bArr, 0)) {
                return b.mQc;
            }
            if (com.facebook.common.g.c.n(bArr, 0)) {
                return b.mQb;
            }
            return b.mQa;
        }
        return c.mQe;
    }

    private static boolean q(byte[] bArr, int i) {
        return i >= mPK.length && e.e(bArr, mPK);
    }

    private static boolean r(byte[] bArr, int i) {
        return i >= mPM.length && e.e(bArr, mPM);
    }

    private static boolean s(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.e(bArr, mPO) || e.e(bArr, mPP);
    }

    private static boolean t(byte[] bArr, int i) {
        if (i < mPQ.length) {
            return false;
        }
        return e.e(bArr, mPQ);
    }

    private static boolean u(byte[] bArr, int i) {
        String[] strArr;
        if (i >= mPT && bArr[3] >= 8) {
            int length = mPS.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (e.c(bArr, bArr.length, e.QG(FileTypeBox.TYPE + strArr[i2]), mPT) > -1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
