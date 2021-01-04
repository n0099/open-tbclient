package com.facebook.c;

import com.coremedia.iso.boxes.FileTypeBox;
import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class a implements c.a {
    private static final byte[] pyL = {-1, -40, -1};
    private static final int pyM = pyL.length;
    private static final byte[] pyN = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int pyO = pyN.length;
    private static final byte[] pyP = e.Zu("GIF87a");
    private static final byte[] pyQ = e.Zu("GIF89a");
    private static final byte[] pyR = e.Zu("BM");
    private static final int pyS = pyR.length;
    private static final String[] pyT = {"heic", "heix", "hevc", "hevx"};
    private static final int pyU = e.Zu(FileTypeBox.TYPE + pyT[0]).length;
    final int pyK = com.facebook.common.internal.e.s(21, 20, pyM, pyO, 6, pyS, pyU);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.pyK;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c p(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.z(bArr, 0, i)) {
            return q(bArr, i);
        }
        if (r(bArr, i)) {
            return b.pyV;
        }
        if (s(bArr, i)) {
            return b.pyW;
        }
        if (t(bArr, i)) {
            return b.pyX;
        }
        if (u(bArr, i)) {
            return b.pyY;
        }
        if (v(bArr, i)) {
            return b.pze;
        }
        return c.pzf;
    }

    private static c q(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.z(bArr, 0, i));
        if (com.facebook.common.g.c.m(bArr, 0)) {
            return b.pyZ;
        }
        if (com.facebook.common.g.c.n(bArr, 0)) {
            return b.pza;
        }
        if (com.facebook.common.g.c.y(bArr, 0, i)) {
            if (com.facebook.common.g.c.l(bArr, 0)) {
                return b.pzd;
            }
            if (com.facebook.common.g.c.o(bArr, 0)) {
                return b.pzc;
            }
            return b.pzb;
        }
        return c.pzf;
    }

    private static boolean r(byte[] bArr, int i) {
        return i >= pyL.length && e.g(bArr, pyL);
    }

    private static boolean s(byte[] bArr, int i) {
        return i >= pyN.length && e.g(bArr, pyN);
    }

    private static boolean t(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.g(bArr, pyP) || e.g(bArr, pyQ);
    }

    private static boolean u(byte[] bArr, int i) {
        if (i < pyR.length) {
            return false;
        }
        return e.g(bArr, pyR);
    }

    private static boolean v(byte[] bArr, int i) {
        String[] strArr;
        if (i >= pyU && bArr[3] >= 8) {
            int length = pyT.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (e.c(bArr, bArr.length, e.Zu(FileTypeBox.TYPE + strArr[i2]), pyU) > -1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
