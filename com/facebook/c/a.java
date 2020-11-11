package com.facebook.c;

import com.coremedia.iso.boxes.FileTypeBox;
import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class a implements c.a {
    private static final byte[] oSg = {-1, -40, -1};
    private static final int oSh = oSg.length;
    private static final byte[] oSi = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int oSj = oSi.length;
    private static final byte[] oSk = e.Yd("GIF87a");
    private static final byte[] oSl = e.Yd("GIF89a");
    private static final byte[] oSm = e.Yd("BM");
    private static final int oSn = oSm.length;
    private static final String[] oSo = {"heic", "heix", "hevc", "hevx"};
    private static final int oSp = e.Yd(FileTypeBox.TYPE + oSo[0]).length;
    final int oSf = com.facebook.common.internal.e.o(21, 20, oSh, oSj, 6, oSn, oSp);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.oSf;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c p(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.x(bArr, 0, i)) {
            return q(bArr, i);
        }
        if (r(bArr, i)) {
            return b.oSq;
        }
        if (s(bArr, i)) {
            return b.oSr;
        }
        if (t(bArr, i)) {
            return b.oSs;
        }
        if (u(bArr, i)) {
            return b.oSt;
        }
        if (v(bArr, i)) {
            return b.oSz;
        }
        return c.oSA;
    }

    private static c q(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.x(bArr, 0, i));
        if (com.facebook.common.g.c.m(bArr, 0)) {
            return b.oSu;
        }
        if (com.facebook.common.g.c.n(bArr, 0)) {
            return b.oSv;
        }
        if (com.facebook.common.g.c.w(bArr, 0, i)) {
            if (com.facebook.common.g.c.l(bArr, 0)) {
                return b.oSy;
            }
            if (com.facebook.common.g.c.o(bArr, 0)) {
                return b.oSx;
            }
            return b.oSw;
        }
        return c.oSA;
    }

    private static boolean r(byte[] bArr, int i) {
        return i >= oSg.length && e.e(bArr, oSg);
    }

    private static boolean s(byte[] bArr, int i) {
        return i >= oSi.length && e.e(bArr, oSi);
    }

    private static boolean t(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.e(bArr, oSk) || e.e(bArr, oSl);
    }

    private static boolean u(byte[] bArr, int i) {
        if (i < oSm.length) {
            return false;
        }
        return e.e(bArr, oSm);
    }

    private static boolean v(byte[] bArr, int i) {
        String[] strArr;
        if (i >= oSp && bArr[3] >= 8) {
            int length = oSo.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (e.c(bArr, bArr.length, e.Yd(FileTypeBox.TYPE + strArr[i2]), oSp) > -1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
