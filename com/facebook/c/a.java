package com.facebook.c;

import com.coremedia.iso.boxes.FileTypeBox;
import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class a implements c.a {
    private static final byte[] nCc = {-1, -40, -1};
    private static final int nCd = nCc.length;
    private static final byte[] nCe = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int nCf = nCe.length;
    private static final byte[] nCg = e.UY("GIF87a");
    private static final byte[] nCh = e.UY("GIF89a");
    private static final byte[] nCi = e.UY("BM");
    private static final int nCj = nCi.length;
    private static final String[] nCk = {"heic", "heix", "hevc", "hevx"};
    private static final int nCl = e.UY(FileTypeBox.TYPE + nCk[0]).length;
    final int nCb = com.facebook.common.internal.e.n(21, 20, nCd, nCf, 6, nCj, nCl);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.nCb;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c n(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.v(bArr, 0, i)) {
            return o(bArr, i);
        }
        if (p(bArr, i)) {
            return b.nCm;
        }
        if (q(bArr, i)) {
            return b.nCn;
        }
        if (r(bArr, i)) {
            return b.nCo;
        }
        if (s(bArr, i)) {
            return b.nCp;
        }
        if (t(bArr, i)) {
            return b.nCv;
        }
        return c.nCw;
    }

    private static c o(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.v(bArr, 0, i));
        if (com.facebook.common.g.c.k(bArr, 0)) {
            return b.nCq;
        }
        if (com.facebook.common.g.c.l(bArr, 0)) {
            return b.nCr;
        }
        if (com.facebook.common.g.c.u(bArr, 0, i)) {
            if (com.facebook.common.g.c.j(bArr, 0)) {
                return b.nCu;
            }
            if (com.facebook.common.g.c.m(bArr, 0)) {
                return b.nCt;
            }
            return b.nCs;
        }
        return c.nCw;
    }

    private static boolean p(byte[] bArr, int i) {
        return i >= nCc.length && e.e(bArr, nCc);
    }

    private static boolean q(byte[] bArr, int i) {
        return i >= nCe.length && e.e(bArr, nCe);
    }

    private static boolean r(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.e(bArr, nCg) || e.e(bArr, nCh);
    }

    private static boolean s(byte[] bArr, int i) {
        if (i < nCi.length) {
            return false;
        }
        return e.e(bArr, nCi);
    }

    private static boolean t(byte[] bArr, int i) {
        String[] strArr;
        if (i >= nCl && bArr[3] >= 8) {
            int length = nCk.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (e.c(bArr, bArr.length, e.UY(FileTypeBox.TYPE + strArr[i2]), nCl) > -1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
