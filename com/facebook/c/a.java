package com.facebook.c;

import com.coremedia.iso.boxes.FileTypeBox;
import com.facebook.c.c;
import com.facebook.common.internal.g;
import com.yy.mediaframework.stat.VideoDataStatistic;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class a implements c.a {
    private static final byte[] pGe = {-1, -40, -1};
    private static final int pGf = pGe.length;
    private static final byte[] pGg = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int pGh = pGg.length;
    private static final byte[] pGi = e.Zz("GIF87a");
    private static final byte[] pGj = e.Zz("GIF89a");
    private static final byte[] pGk = e.Zz("BM");
    private static final int pGl = pGk.length;
    private static final String[] pGm = {"heic", "heix", VideoDataStatistic.AnchorHiidoAssistantStatisticKey.H265SupportInfo, "hevx"};
    private static final int pGn = e.Zz(FileTypeBox.TYPE + pGm[0]).length;
    final int pGd = com.facebook.common.internal.e.s(21, 20, pGf, pGh, 6, pGl, pGn);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.pGd;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c o(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.y(bArr, 0, i)) {
            return p(bArr, i);
        }
        if (q(bArr, i)) {
            return b.pGo;
        }
        if (r(bArr, i)) {
            return b.pGp;
        }
        if (s(bArr, i)) {
            return b.pGq;
        }
        if (t(bArr, i)) {
            return b.pGr;
        }
        if (u(bArr, i)) {
            return b.pGx;
        }
        return c.pGy;
    }

    private static c p(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.y(bArr, 0, i));
        if (com.facebook.common.g.c.l(bArr, 0)) {
            return b.pGs;
        }
        if (com.facebook.common.g.c.m(bArr, 0)) {
            return b.pGt;
        }
        if (com.facebook.common.g.c.x(bArr, 0, i)) {
            if (com.facebook.common.g.c.k(bArr, 0)) {
                return b.pGw;
            }
            if (com.facebook.common.g.c.n(bArr, 0)) {
                return b.pGv;
            }
            return b.pGu;
        }
        return c.pGy;
    }

    private static boolean q(byte[] bArr, int i) {
        return i >= pGe.length && e.f(bArr, pGe);
    }

    private static boolean r(byte[] bArr, int i) {
        return i >= pGg.length && e.f(bArr, pGg);
    }

    private static boolean s(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.f(bArr, pGi) || e.f(bArr, pGj);
    }

    private static boolean t(byte[] bArr, int i) {
        if (i < pGk.length) {
            return false;
        }
        return e.f(bArr, pGk);
    }

    private static boolean u(byte[] bArr, int i) {
        String[] strArr;
        if (i >= pGn && bArr[3] >= 8) {
            int length = pGm.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (e.c(bArr, bArr.length, e.Zz(FileTypeBox.TYPE + strArr[i2]), pGn) > -1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
