package com.facebook.c;

import com.coremedia.iso.boxes.FileTypeBox;
import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class a implements c.a {
    private static final byte[] oIN = {-1, -40, -1};
    private static final int oIO = oIN.length;
    private static final byte[] oIP = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int oIQ = oIP.length;
    private static final byte[] oIR = e.Xz("GIF87a");
    private static final byte[] oIS = e.Xz("GIF89a");
    private static final byte[] oIT = e.Xz("BM");
    private static final int oIU = oIT.length;
    private static final String[] oIV = {"heic", "heix", "hevc", "hevx"};
    private static final int oIW = e.Xz(FileTypeBox.TYPE + oIV[0]).length;
    final int oIM = com.facebook.common.internal.e.m(21, 20, oIO, oIQ, 6, oIU, oIW);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.oIM;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c p(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.x(bArr, 0, i)) {
            return q(bArr, i);
        }
        if (r(bArr, i)) {
            return b.oIX;
        }
        if (s(bArr, i)) {
            return b.oIY;
        }
        if (t(bArr, i)) {
            return b.oIZ;
        }
        if (u(bArr, i)) {
            return b.oJa;
        }
        if (v(bArr, i)) {
            return b.oJg;
        }
        return c.oJh;
    }

    private static c q(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.x(bArr, 0, i));
        if (com.facebook.common.g.c.m(bArr, 0)) {
            return b.oJb;
        }
        if (com.facebook.common.g.c.n(bArr, 0)) {
            return b.oJc;
        }
        if (com.facebook.common.g.c.w(bArr, 0, i)) {
            if (com.facebook.common.g.c.l(bArr, 0)) {
                return b.oJf;
            }
            if (com.facebook.common.g.c.o(bArr, 0)) {
                return b.oJe;
            }
            return b.oJd;
        }
        return c.oJh;
    }

    private static boolean r(byte[] bArr, int i) {
        return i >= oIN.length && e.e(bArr, oIN);
    }

    private static boolean s(byte[] bArr, int i) {
        return i >= oIP.length && e.e(bArr, oIP);
    }

    private static boolean t(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.e(bArr, oIR) || e.e(bArr, oIS);
    }

    private static boolean u(byte[] bArr, int i) {
        if (i < oIT.length) {
            return false;
        }
        return e.e(bArr, oIT);
    }

    private static boolean v(byte[] bArr, int i) {
        String[] strArr;
        if (i >= oIW && bArr[3] >= 8) {
            int length = oIV.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (e.c(bArr, bArr.length, e.Xz(FileTypeBox.TYPE + strArr[i2]), oIW) > -1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
