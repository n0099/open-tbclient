package com.facebook.c;

import com.coremedia.iso.boxes.FileTypeBox;
import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class a implements c.a {
    final int pzV = com.facebook.common.internal.e.s(21, 20, pzX, pzZ, 6, pAd, pAf);
    private static final byte[] pzW = {-1, -40, -1};
    private static final int pzX = pzW.length;
    private static final byte[] pzY = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int pzZ = pzY.length;
    private static final byte[] pAa = e.Zt("GIF87a");
    private static final byte[] pAb = e.Zt("GIF89a");
    private static final byte[] pAc = e.Zt("BM");
    private static final int pAd = pAc.length;
    private static final String[] pAe = {"heic", "heix", "hevc", "hevx"};
    private static final int pAf = e.Zt(FileTypeBox.TYPE + pAe[0]).length;

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.pzV;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c p(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.z(bArr, 0, i)) {
            return q(bArr, i);
        }
        if (r(bArr, i)) {
            return b.pAg;
        }
        if (s(bArr, i)) {
            return b.pAh;
        }
        if (t(bArr, i)) {
            return b.pAi;
        }
        if (u(bArr, i)) {
            return b.pAj;
        }
        if (v(bArr, i)) {
            return b.pAp;
        }
        return c.pAq;
    }

    private static c q(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.z(bArr, 0, i));
        if (com.facebook.common.g.c.m(bArr, 0)) {
            return b.pAk;
        }
        if (com.facebook.common.g.c.n(bArr, 0)) {
            return b.pAl;
        }
        if (com.facebook.common.g.c.y(bArr, 0, i)) {
            if (com.facebook.common.g.c.l(bArr, 0)) {
                return b.pAo;
            }
            if (com.facebook.common.g.c.o(bArr, 0)) {
                return b.pAn;
            }
            return b.pAm;
        }
        return c.pAq;
    }

    private static boolean r(byte[] bArr, int i) {
        return i >= pzW.length && e.g(bArr, pzW);
    }

    private static boolean s(byte[] bArr, int i) {
        return i >= pzY.length && e.g(bArr, pzY);
    }

    private static boolean t(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.g(bArr, pAa) || e.g(bArr, pAb);
    }

    private static boolean u(byte[] bArr, int i) {
        if (i < pAc.length) {
            return false;
        }
        return e.g(bArr, pAc);
    }

    private static boolean v(byte[] bArr, int i) {
        String[] strArr;
        if (i >= pAf && bArr[3] >= 8) {
            int length = pAe.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (e.c(bArr, bArr.length, e.Zt(FileTypeBox.TYPE + strArr[i2]), pAf) > -1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
