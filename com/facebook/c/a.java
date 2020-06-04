package com.facebook.c;

import com.coremedia.iso.boxes.FileTypeBox;
import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a implements c.a {
    private static final byte[] mtL = {-1, -40, -1};
    private static final int mtM = mtL.length;
    private static final byte[] mtN = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int mtO = mtN.length;
    private static final byte[] mtP = e.PU("GIF87a");
    private static final byte[] mtQ = e.PU("GIF89a");
    private static final byte[] mtR = e.PU("BM");
    private static final int mtS = mtR.length;
    private static final String[] mtT = {"heic", "heix", "hevc", "hevx"};
    private static final int mtU = e.PU(FileTypeBox.TYPE + mtT[0]).length;
    final int mtK = com.facebook.common.internal.e.m(21, 20, mtM, mtO, 6, mtS, mtU);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.mtK;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c o(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.t(bArr, 0, i)) {
            return p(bArr, i);
        }
        if (q(bArr, i)) {
            return b.mtV;
        }
        if (r(bArr, i)) {
            return b.mtW;
        }
        if (s(bArr, i)) {
            return b.mtX;
        }
        if (t(bArr, i)) {
            return b.mtY;
        }
        if (u(bArr, i)) {
            return b.mue;
        }
        return c.muf;
    }

    private static c p(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.t(bArr, 0, i));
        if (com.facebook.common.g.c.l(bArr, 0)) {
            return b.mtZ;
        }
        if (com.facebook.common.g.c.m(bArr, 0)) {
            return b.mua;
        }
        if (com.facebook.common.g.c.s(bArr, 0, i)) {
            if (com.facebook.common.g.c.k(bArr, 0)) {
                return b.mud;
            }
            if (com.facebook.common.g.c.n(bArr, 0)) {
                return b.muc;
            }
            return b.mub;
        }
        return c.muf;
    }

    private static boolean q(byte[] bArr, int i) {
        return i >= mtL.length && e.e(bArr, mtL);
    }

    private static boolean r(byte[] bArr, int i) {
        return i >= mtN.length && e.e(bArr, mtN);
    }

    private static boolean s(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.e(bArr, mtP) || e.e(bArr, mtQ);
    }

    private static boolean t(byte[] bArr, int i) {
        if (i < mtR.length) {
            return false;
        }
        return e.e(bArr, mtR);
    }

    private static boolean u(byte[] bArr, int i) {
        String[] strArr;
        if (i >= mtU && bArr[3] >= 8) {
            int length = mtT.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (e.c(bArr, bArr.length, e.PU(FileTypeBox.TYPE + strArr[i2]), mtU) > -1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
