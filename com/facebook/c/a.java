package com.facebook.c;

import com.coremedia.iso.boxes.FileTypeBox;
import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class a implements c.a {
    final int lOr = com.facebook.common.internal.e.l(21, 20, lOt, lOv, 6, lOz, lOB);
    private static final byte[] lOs = {-1, -40, -1};
    private static final int lOt = lOs.length;
    private static final byte[] lOu = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int lOv = lOu.length;
    private static final byte[] lOw = e.OH("GIF87a");
    private static final byte[] lOx = e.OH("GIF89a");
    private static final byte[] lOy = e.OH("BM");
    private static final int lOz = lOy.length;
    private static final String[] lOA = {"heic", "heix", "hevc", "hevx"};
    private static final int lOB = e.OH(FileTypeBox.TYPE + lOA[0]).length;

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.lOr;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c p(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.n(bArr, 0, i)) {
            return q(bArr, i);
        }
        if (r(bArr, i)) {
            return b.lOC;
        }
        if (s(bArr, i)) {
            return b.lOD;
        }
        if (t(bArr, i)) {
            return b.lOE;
        }
        if (u(bArr, i)) {
            return b.lOF;
        }
        if (v(bArr, i)) {
            return b.lOL;
        }
        return c.lOM;
    }

    private static c q(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.n(bArr, 0, i));
        if (com.facebook.common.g.c.m(bArr, 0)) {
            return b.lOG;
        }
        if (com.facebook.common.g.c.n(bArr, 0)) {
            return b.lOH;
        }
        if (com.facebook.common.g.c.m(bArr, 0, i)) {
            if (com.facebook.common.g.c.l(bArr, 0)) {
                return b.lOK;
            }
            if (com.facebook.common.g.c.o(bArr, 0)) {
                return b.lOJ;
            }
            return b.lOI;
        }
        return c.lOM;
    }

    private static boolean r(byte[] bArr, int i) {
        return i >= lOs.length && e.d(bArr, lOs);
    }

    private static boolean s(byte[] bArr, int i) {
        return i >= lOu.length && e.d(bArr, lOu);
    }

    private static boolean t(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.d(bArr, lOw) || e.d(bArr, lOx);
    }

    private static boolean u(byte[] bArr, int i) {
        if (i < lOy.length) {
            return false;
        }
        return e.d(bArr, lOy);
    }

    private static boolean v(byte[] bArr, int i) {
        String[] strArr;
        if (i >= lOB && bArr[3] >= 8) {
            int length = lOA.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (e.a(bArr, bArr.length, e.OH(FileTypeBox.TYPE + strArr[i2]), lOB) > -1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
