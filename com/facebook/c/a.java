package com.facebook.c;

import com.coremedia.iso.boxes.FileTypeBox;
import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class a implements c.a {
    final int pvu = com.facebook.common.internal.e.s(21, 20, pvw, pvy, 6, pvC, pvE);
    private static final byte[] pvv = {-1, -40, -1};
    private static final int pvw = pvv.length;
    private static final byte[] pvx = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int pvy = pvx.length;
    private static final byte[] pvz = e.Yl("GIF87a");
    private static final byte[] pvA = e.Yl("GIF89a");
    private static final byte[] pvB = e.Yl("BM");
    private static final int pvC = pvB.length;
    private static final String[] pvD = {"heic", "heix", "hevc", "hevx"};
    private static final int pvE = e.Yl(FileTypeBox.TYPE + pvD[0]).length;

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.pvu;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c p(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.y(bArr, 0, i)) {
            return q(bArr, i);
        }
        if (r(bArr, i)) {
            return b.pvF;
        }
        if (s(bArr, i)) {
            return b.pvG;
        }
        if (t(bArr, i)) {
            return b.pvH;
        }
        if (u(bArr, i)) {
            return b.pvI;
        }
        if (v(bArr, i)) {
            return b.pvO;
        }
        return c.pvP;
    }

    private static c q(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.y(bArr, 0, i));
        if (com.facebook.common.g.c.m(bArr, 0)) {
            return b.pvJ;
        }
        if (com.facebook.common.g.c.n(bArr, 0)) {
            return b.pvK;
        }
        if (com.facebook.common.g.c.x(bArr, 0, i)) {
            if (com.facebook.common.g.c.l(bArr, 0)) {
                return b.pvN;
            }
            if (com.facebook.common.g.c.o(bArr, 0)) {
                return b.pvM;
            }
            return b.pvL;
        }
        return c.pvP;
    }

    private static boolean r(byte[] bArr, int i) {
        return i >= pvv.length && e.f(bArr, pvv);
    }

    private static boolean s(byte[] bArr, int i) {
        return i >= pvx.length && e.f(bArr, pvx);
    }

    private static boolean t(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.f(bArr, pvz) || e.f(bArr, pvA);
    }

    private static boolean u(byte[] bArr, int i) {
        if (i < pvB.length) {
            return false;
        }
        return e.f(bArr, pvB);
    }

    private static boolean v(byte[] bArr, int i) {
        String[] strArr;
        if (i >= pvE && bArr[3] >= 8) {
            int length = pvD.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (e.c(bArr, bArr.length, e.Yl(FileTypeBox.TYPE + strArr[i2]), pvE) > -1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
