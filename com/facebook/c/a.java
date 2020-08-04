package com.facebook.c;

import com.coremedia.iso.boxes.FileTypeBox;
import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class a implements c.a {
    private static final byte[] mXX = {-1, -40, -1};
    private static final int mXY = mXX.length;
    private static final byte[] mXZ = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int mYa = mXZ.length;
    private static final byte[] mYb = e.Rs("GIF87a");
    private static final byte[] mYc = e.Rs("GIF89a");
    private static final byte[] mYd = e.Rs("BM");
    private static final int mYe = mYd.length;
    private static final String[] mYf = {"heic", "heix", "hevc", "hevx"};
    private static final int mYg = e.Rs(FileTypeBox.TYPE + mYf[0]).length;
    final int mXW = com.facebook.common.internal.e.m(21, 20, mXY, mYa, 6, mYe, mYg);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.mXW;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c o(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.u(bArr, 0, i)) {
            return p(bArr, i);
        }
        if (q(bArr, i)) {
            return b.mYh;
        }
        if (r(bArr, i)) {
            return b.mYi;
        }
        if (s(bArr, i)) {
            return b.mYj;
        }
        if (t(bArr, i)) {
            return b.mYk;
        }
        if (u(bArr, i)) {
            return b.mYq;
        }
        return c.mYr;
    }

    private static c p(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.u(bArr, 0, i));
        if (com.facebook.common.g.c.l(bArr, 0)) {
            return b.mYl;
        }
        if (com.facebook.common.g.c.m(bArr, 0)) {
            return b.mYm;
        }
        if (com.facebook.common.g.c.t(bArr, 0, i)) {
            if (com.facebook.common.g.c.k(bArr, 0)) {
                return b.mYp;
            }
            if (com.facebook.common.g.c.n(bArr, 0)) {
                return b.mYo;
            }
            return b.mYn;
        }
        return c.mYr;
    }

    private static boolean q(byte[] bArr, int i) {
        return i >= mXX.length && e.e(bArr, mXX);
    }

    private static boolean r(byte[] bArr, int i) {
        return i >= mXZ.length && e.e(bArr, mXZ);
    }

    private static boolean s(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.e(bArr, mYb) || e.e(bArr, mYc);
    }

    private static boolean t(byte[] bArr, int i) {
        if (i < mYd.length) {
            return false;
        }
        return e.e(bArr, mYd);
    }

    private static boolean u(byte[] bArr, int i) {
        String[] strArr;
        if (i >= mYg && bArr[3] >= 8) {
            int length = mYf.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (e.c(bArr, bArr.length, e.Rs(FileTypeBox.TYPE + strArr[i2]), mYg) > -1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
