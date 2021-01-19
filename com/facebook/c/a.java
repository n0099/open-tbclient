package com.facebook.c;

import com.coremedia.iso.boxes.FileTypeBox;
import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class a implements c.a {
    final int pvv = com.facebook.common.internal.e.s(21, 20, pvx, pvz, 6, pvD, pvF);
    private static final byte[] pvw = {-1, -40, -1};
    private static final int pvx = pvw.length;
    private static final byte[] pvy = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int pvz = pvy.length;
    private static final byte[] pvA = e.Ym("GIF87a");
    private static final byte[] pvB = e.Ym("GIF89a");
    private static final byte[] pvC = e.Ym("BM");
    private static final int pvD = pvC.length;
    private static final String[] pvE = {"heic", "heix", "hevc", "hevx"};
    private static final int pvF = e.Ym(FileTypeBox.TYPE + pvE[0]).length;

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.pvv;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c p(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.y(bArr, 0, i)) {
            return q(bArr, i);
        }
        if (r(bArr, i)) {
            return b.pvG;
        }
        if (s(bArr, i)) {
            return b.pvH;
        }
        if (t(bArr, i)) {
            return b.pvI;
        }
        if (u(bArr, i)) {
            return b.pvJ;
        }
        if (v(bArr, i)) {
            return b.pvP;
        }
        return c.pvQ;
    }

    private static c q(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.y(bArr, 0, i));
        if (com.facebook.common.g.c.m(bArr, 0)) {
            return b.pvK;
        }
        if (com.facebook.common.g.c.n(bArr, 0)) {
            return b.pvL;
        }
        if (com.facebook.common.g.c.x(bArr, 0, i)) {
            if (com.facebook.common.g.c.l(bArr, 0)) {
                return b.pvO;
            }
            if (com.facebook.common.g.c.o(bArr, 0)) {
                return b.pvN;
            }
            return b.pvM;
        }
        return c.pvQ;
    }

    private static boolean r(byte[] bArr, int i) {
        return i >= pvw.length && e.f(bArr, pvw);
    }

    private static boolean s(byte[] bArr, int i) {
        return i >= pvy.length && e.f(bArr, pvy);
    }

    private static boolean t(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.f(bArr, pvA) || e.f(bArr, pvB);
    }

    private static boolean u(byte[] bArr, int i) {
        if (i < pvC.length) {
            return false;
        }
        return e.f(bArr, pvC);
    }

    private static boolean v(byte[] bArr, int i) {
        String[] strArr;
        if (i >= pvF && bArr[3] >= 8) {
            int length = pvE.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (e.c(bArr, bArr.length, e.Ym(FileTypeBox.TYPE + strArr[i2]), pvF) > -1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
