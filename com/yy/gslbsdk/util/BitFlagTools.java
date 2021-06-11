package com.yy.gslbsdk.util;
/* loaded from: classes7.dex */
public class BitFlagTools {
    public static int setFlag(int i2, int i3) {
        return i2 | i3;
    }

    public static boolean testFlag(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    public static int unsetFlag(int i2, int i3) {
        return i2 & (~i3);
    }
}
