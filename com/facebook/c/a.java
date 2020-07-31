package com.facebook.c;

import com.coremedia.iso.boxes.FileTypeBox;
import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class a implements c.a {
    private static final byte[] mXV = {-1, -40, -1};
    private static final int mXW = mXV.length;
    private static final byte[] mXX = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int mXY = mXX.length;
    private static final byte[] mXZ = e.Rs("GIF87a");
    private static final byte[] mYa = e.Rs("GIF89a");
    private static final byte[] mYb = e.Rs("BM");
    private static final int mYc = mYb.length;
    private static final String[] mYd = {"heic", "heix", "hevc", "hevx"};
    private static final int mYe = e.Rs(FileTypeBox.TYPE + mYd[0]).length;
    final int mXU = com.facebook.common.internal.e.m(21, 20, mXW, mXY, 6, mYc, mYe);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.mXU;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c o(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.u(bArr, 0, i)) {
            return p(bArr, i);
        }
        if (q(bArr, i)) {
            return b.mYf;
        }
        if (r(bArr, i)) {
            return b.mYg;
        }
        if (s(bArr, i)) {
            return b.mYh;
        }
        if (t(bArr, i)) {
            return b.mYi;
        }
        if (u(bArr, i)) {
            return b.mYo;
        }
        return c.mYp;
    }

    private static c p(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.u(bArr, 0, i));
        if (com.facebook.common.g.c.l(bArr, 0)) {
            return b.mYj;
        }
        if (com.facebook.common.g.c.m(bArr, 0)) {
            return b.mYk;
        }
        if (com.facebook.common.g.c.t(bArr, 0, i)) {
            if (com.facebook.common.g.c.k(bArr, 0)) {
                return b.mYn;
            }
            if (com.facebook.common.g.c.n(bArr, 0)) {
                return b.mYm;
            }
            return b.mYl;
        }
        return c.mYp;
    }

    private static boolean q(byte[] bArr, int i) {
        return i >= mXV.length && e.e(bArr, mXV);
    }

    private static boolean r(byte[] bArr, int i) {
        return i >= mXX.length && e.e(bArr, mXX);
    }

    private static boolean s(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.e(bArr, mXZ) || e.e(bArr, mYa);
    }

    private static boolean t(byte[] bArr, int i) {
        if (i < mYb.length) {
            return false;
        }
        return e.e(bArr, mYb);
    }

    private static boolean u(byte[] bArr, int i) {
        String[] strArr;
        if (i >= mYe && bArr[3] >= 8) {
            int length = mYd.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (e.c(bArr, bArr.length, e.Rs(FileTypeBox.TYPE + strArr[i2]), mYe) > -1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
