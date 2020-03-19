package com.facebook.c;

import com.coremedia.iso.boxes.FileTypeBox;
import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a implements c.a {
    private static final byte[] lQX = {-1, -40, -1};
    private static final int lQY = lQX.length;
    private static final byte[] lQZ = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int lRa = lQZ.length;
    private static final byte[] lRb = e.OV("GIF87a");
    private static final byte[] lRc = e.OV("GIF89a");
    private static final byte[] lRd = e.OV("BM");
    private static final int lRe = lRd.length;
    private static final String[] lRf = {"heic", "heix", "hevc", "hevx"};
    private static final int lRg = e.OV(FileTypeBox.TYPE + lRf[0]).length;
    final int lQW = com.facebook.common.internal.e.k(21, 20, lQY, lRa, 6, lRe, lRg);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.lQW;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c r(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.r(bArr, 0, i)) {
            return s(bArr, i);
        }
        if (t(bArr, i)) {
            return b.lRh;
        }
        if (u(bArr, i)) {
            return b.lRi;
        }
        if (v(bArr, i)) {
            return b.lRj;
        }
        if (w(bArr, i)) {
            return b.lRk;
        }
        if (x(bArr, i)) {
            return b.lRq;
        }
        return c.lRr;
    }

    private static c s(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.r(bArr, 0, i));
        if (com.facebook.common.g.c.o(bArr, 0)) {
            return b.lRl;
        }
        if (com.facebook.common.g.c.p(bArr, 0)) {
            return b.lRm;
        }
        if (com.facebook.common.g.c.q(bArr, 0, i)) {
            if (com.facebook.common.g.c.n(bArr, 0)) {
                return b.lRp;
            }
            if (com.facebook.common.g.c.q(bArr, 0)) {
                return b.lRo;
            }
            return b.lRn;
        }
        return c.lRr;
    }

    private static boolean t(byte[] bArr, int i) {
        return i >= lQX.length && e.d(bArr, lQX);
    }

    private static boolean u(byte[] bArr, int i) {
        return i >= lQZ.length && e.d(bArr, lQZ);
    }

    private static boolean v(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.d(bArr, lRb) || e.d(bArr, lRc);
    }

    private static boolean w(byte[] bArr, int i) {
        if (i < lRd.length) {
            return false;
        }
        return e.d(bArr, lRd);
    }

    private static boolean x(byte[] bArr, int i) {
        String[] strArr;
        if (i >= lRg && bArr[3] >= 8) {
            int length = lRf.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (e.c(bArr, bArr.length, e.OV(FileTypeBox.TYPE + strArr[i2]), lRg) > -1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
