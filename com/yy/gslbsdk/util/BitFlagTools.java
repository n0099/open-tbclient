package com.yy.gslbsdk.util;
/* loaded from: classes9.dex */
public class BitFlagTools {
    public static int setFlag(int i, int i2) {
        return i | i2;
    }

    public static boolean testFlag(int i, int i2) {
        return (i & i2) != 0;
    }

    public static int unsetFlag(int i, int i2) {
        return i & (~i2);
    }
}
