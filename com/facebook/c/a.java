package com.facebook.c;

import com.coremedia.iso.boxes.FileTypeBox;
import com.facebook.c.c;
import com.facebook.common.internal.g;
import com.yy.mediaframework.stat.VideoDataStatistic;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class a implements c.a {
    private static final byte[] pFE = {-1, -40, -1};
    private static final int pFF = pFE.length;
    private static final byte[] pFG = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int pFH = pFG.length;
    private static final byte[] pFI = e.Zn("GIF87a");
    private static final byte[] pFJ = e.Zn("GIF89a");
    private static final byte[] pFK = e.Zn("BM");
    private static final int pFL = pFK.length;
    private static final String[] pFM = {"heic", "heix", VideoDataStatistic.AnchorHiidoAssistantStatisticKey.H265SupportInfo, "hevx"};
    private static final int pFN = e.Zn(FileTypeBox.TYPE + pFM[0]).length;
    final int pFD = com.facebook.common.internal.e.s(21, 20, pFF, pFH, 6, pFL, pFN);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.pFD;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c o(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.y(bArr, 0, i)) {
            return p(bArr, i);
        }
        if (q(bArr, i)) {
            return b.pFO;
        }
        if (r(bArr, i)) {
            return b.pFP;
        }
        if (s(bArr, i)) {
            return b.pFQ;
        }
        if (t(bArr, i)) {
            return b.pFR;
        }
        if (u(bArr, i)) {
            return b.pFX;
        }
        return c.pFY;
    }

    private static c p(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.y(bArr, 0, i));
        if (com.facebook.common.g.c.l(bArr, 0)) {
            return b.pFS;
        }
        if (com.facebook.common.g.c.m(bArr, 0)) {
            return b.pFT;
        }
        if (com.facebook.common.g.c.x(bArr, 0, i)) {
            if (com.facebook.common.g.c.k(bArr, 0)) {
                return b.pFW;
            }
            if (com.facebook.common.g.c.n(bArr, 0)) {
                return b.pFV;
            }
            return b.pFU;
        }
        return c.pFY;
    }

    private static boolean q(byte[] bArr, int i) {
        return i >= pFE.length && e.f(bArr, pFE);
    }

    private static boolean r(byte[] bArr, int i) {
        return i >= pFG.length && e.f(bArr, pFG);
    }

    private static boolean s(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.f(bArr, pFI) || e.f(bArr, pFJ);
    }

    private static boolean t(byte[] bArr, int i) {
        if (i < pFK.length) {
            return false;
        }
        return e.f(bArr, pFK);
    }

    private static boolean u(byte[] bArr, int i) {
        String[] strArr;
        if (i >= pFN && bArr[3] >= 8) {
            int length = pFM.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (e.c(bArr, bArr.length, e.Zn(FileTypeBox.TYPE + strArr[i2]), pFN) > -1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
