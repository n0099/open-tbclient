package com.facebook.c;

import com.coremedia.iso.boxes.FileTypeBox;
import com.facebook.c.c;
import com.facebook.common.internal.g;
import com.yy.mediaframework.stat.VideoDataStatistic;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class a implements c.a {
    private static final byte[] pIj = {-1, -40, -1};
    private static final int pIk = pIj.length;
    private static final byte[] pIl = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int pIm = pIl.length;
    private static final byte[] pIn = e.ZF("GIF87a");
    private static final byte[] pIo = e.ZF("GIF89a");
    private static final byte[] pIp = e.ZF("BM");
    private static final int pIq = pIp.length;
    private static final String[] pIr = {"heic", "heix", VideoDataStatistic.AnchorHiidoAssistantStatisticKey.H265SupportInfo, "hevx"};
    private static final int pIs = e.ZF(FileTypeBox.TYPE + pIr[0]).length;
    final int pIi = com.facebook.common.internal.e.s(21, 20, pIk, pIm, 6, pIq, pIs);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.pIi;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c o(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.y(bArr, 0, i)) {
            return p(bArr, i);
        }
        if (q(bArr, i)) {
            return b.pIt;
        }
        if (r(bArr, i)) {
            return b.pIu;
        }
        if (s(bArr, i)) {
            return b.pIv;
        }
        if (t(bArr, i)) {
            return b.pIw;
        }
        if (u(bArr, i)) {
            return b.pIC;
        }
        return c.pID;
    }

    private static c p(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.y(bArr, 0, i));
        if (com.facebook.common.g.c.l(bArr, 0)) {
            return b.pIx;
        }
        if (com.facebook.common.g.c.m(bArr, 0)) {
            return b.pIy;
        }
        if (com.facebook.common.g.c.x(bArr, 0, i)) {
            if (com.facebook.common.g.c.k(bArr, 0)) {
                return b.pIB;
            }
            if (com.facebook.common.g.c.n(bArr, 0)) {
                return b.pIA;
            }
            return b.pIz;
        }
        return c.pID;
    }

    private static boolean q(byte[] bArr, int i) {
        return i >= pIj.length && e.f(bArr, pIj);
    }

    private static boolean r(byte[] bArr, int i) {
        return i >= pIl.length && e.f(bArr, pIl);
    }

    private static boolean s(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.f(bArr, pIn) || e.f(bArr, pIo);
    }

    private static boolean t(byte[] bArr, int i) {
        if (i < pIp.length) {
            return false;
        }
        return e.f(bArr, pIp);
    }

    private static boolean u(byte[] bArr, int i) {
        String[] strArr;
        if (i >= pIs && bArr[3] >= 8) {
            int length = pIr.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (e.c(bArr, bArr.length, e.ZF(FileTypeBox.TYPE + strArr[i2]), pIs) > -1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
