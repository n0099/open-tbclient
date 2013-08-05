package com.tencent.mm.algorithm;

import com.tencent.mm.sdk.platformtools.Util;
/* loaded from: classes.dex */
public final class c {
    public static byte[] a(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2] = (byte) ((i >> (i2 * 8)) & Util.MASK_8BIT);
        }
        return bArr;
    }
}
