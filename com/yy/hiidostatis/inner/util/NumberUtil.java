package com.yy.hiidostatis.inner.util;

import androidx.recyclerview.widget.ItemTouchHelper;
/* loaded from: classes7.dex */
public class NumberUtil {
    public static byte[] getBytes(char c2) {
        return new byte[]{(byte) c2, (byte) (c2 >> '\b')};
    }

    public static byte[] getBytes(float f2) {
        return getBytes(Float.floatToIntBits(f2));
    }

    public static byte[] getBytes(int i2) {
        return new byte[]{(byte) (i2 & 255), (byte) ((65280 & i2) >> 8), (byte) ((16711680 & i2) >> 16), (byte) ((i2 & (-16777216)) >> 24)};
    }

    public static byte[] getBytes(long j) {
        return new byte[]{(byte) (j & 255), (byte) ((j >> 8) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 56) & 255)};
    }

    public static char getChar(byte[] bArr, int i2) {
        return (char) (((bArr[i2 + 1] << 8) & 65280) | (bArr[i2 + 0] & 255));
    }

    public static double getDouble(byte[] bArr) {
        return getDouble(bArr, 0);
    }

    public static float getFloat(byte[] bArr) {
        return getFloat(bArr, 0);
    }

    public static int getInt(byte[] bArr) {
        return ((bArr[3] << 24) & (-16777216)) | (bArr[0] & 255) | ((bArr[1] << 8) & 65280) | ((bArr[2] << 16) & ItemTouchHelper.ACTION_MODE_DRAG_MASK);
    }

    public static long getLong(byte[] bArr) {
        return (bArr[0] & 255) | ((bArr[1] << 8) & 65280) | ((bArr[2] << 16) & 16711680) | ((bArr[3] << 24) & 4278190080L) | ((bArr[4] << 32) & 1095216660480L) | ((bArr[5] << 40) & 280375465082880L) | ((bArr[6] << 48) & 71776119061217280L) | ((bArr[7] << 56) & (-72057594037927936L));
    }

    public static short getShort(byte[] bArr, int i2) {
        return (short) (((bArr[i2 + 1] << 8) & 65280) | (bArr[i2 + 0] & 255));
    }

    public static byte[] toBytes(String str) {
        if (str.isEmpty()) {
            return new byte[0];
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) Integer.parseInt(str.substring(i3, i3 + 2), 16);
        }
        return bArr;
    }

    public static String toHex(byte[] bArr) {
        return toHex(bArr, 0, bArr.length);
    }

    public static double getDouble(byte[] bArr, int i2) {
        long j = getLong(bArr, i2);
        System.out.println(j);
        return Double.longBitsToDouble(j);
    }

    public static float getFloat(byte[] bArr, int i2) {
        return Float.intBitsToFloat(getInt(bArr, i2));
    }

    public static int getInt(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] << 24) & (-16777216)) | (bArr[i2 + 0] & 255) | ((bArr[i2 + 1] << 8) & 65280) | ((bArr[i2 + 2] << 16) & ItemTouchHelper.ACTION_MODE_DRAG_MASK);
    }

    public static long getLong(byte[] bArr, int i2) {
        return ((bArr[i2 + 7] << 56) & (-72057594037927936L)) | (bArr[i2 + 0] & 255) | ((bArr[i2 + 1] << 8) & 65280) | ((bArr[i2 + 2] << 16) & 16711680) | ((bArr[i2 + 3] << 24) & 4278190080L) | ((bArr[i2 + 4] << 32) & 1095216660480L) | ((bArr[i2 + 5] << 40) & 280375465082880L) | ((bArr[i2 + 6] << 48) & 71776119061217280L);
    }

    public static String toHex(byte[] bArr, int i2, int i3) {
        StringBuilder sb = new StringBuilder(i3 * 2);
        for (int i4 = 0; i4 < i3; i4++) {
            String hexString = Integer.toHexString(bArr[i2 + i4] & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString().toUpperCase();
    }

    public static byte[] getBytes(double d2) {
        return getBytes(Double.doubleToLongBits(d2));
    }
}
