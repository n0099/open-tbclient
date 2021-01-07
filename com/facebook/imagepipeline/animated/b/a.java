package com.facebook.imagepipeline.animated.b;
/* loaded from: classes5.dex */
public class a {
    public void fixFrameDurations(int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] < 11) {
                iArr[i] = 100;
            }
        }
    }

    public int t(int[] iArr) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < iArr.length) {
                i = iArr[i2] + i3;
                i2++;
            } else {
                return i3;
            }
        }
    }

    public int[] u(int[] iArr) {
        int i = 0;
        int[] iArr2 = new int[iArr.length];
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < iArr.length) {
                iArr2[i2] = i3;
                i = iArr[i2] + i3;
                i2++;
            } else {
                return iArr2;
            }
        }
    }
}
