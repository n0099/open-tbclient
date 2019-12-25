package com.google.android.exoplayer2.util;
/* loaded from: classes4.dex */
public final class o {
    public static int dW(int i, int i2) {
        int i3 = 1;
        while (true) {
            int i4 = i3;
            if (i4 <= 2) {
                int i5 = (i + i4) % 3;
                if (dX(i5, i2)) {
                    return i5;
                }
                i3 = i4 + 1;
            } else {
                return i;
            }
        }
    }

    public static boolean dX(int i, int i2) {
        switch (i) {
            case 0:
                return true;
            case 1:
                return (i2 & 1) != 0;
            case 2:
                return (i2 & 2) != 0;
            default:
                return false;
        }
    }
}
