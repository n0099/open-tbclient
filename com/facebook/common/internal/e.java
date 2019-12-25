package com.facebook.common.internal;
/* loaded from: classes11.dex */
public class e {
    public static int l(int... iArr) {
        g.checkArgument(iArr.length > 0);
        int i = iArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (iArr[i2] > i) {
                i = iArr[i2];
            }
        }
        return i;
    }
}
