package com.yy.hiidostatis.inner.util;
/* loaded from: classes2.dex */
public class NumberUtil {
    public static byte[] getBytes(char c) {
        return new byte[]{(byte) c, (byte) (c >> '\b')};
    }

    public static byte[] getBytes(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((65280 & i) >> 8), (byte) ((16711680 & i) >> 16), (byte) ((i & (-16777216)) >> 24)};
    }

    public static byte[] getBytes(long j) {
        return new byte[]{(byte) (j & 255), (byte) ((j >> 8) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 56) & 255)};
    }

    public static byte[] getBytes(double d) {
        return getBytes(Double.doubleToLongBits(d));
    }

    public static double getDouble(byte[] bArr) {
        return getDouble(bArr, 0);
    }

    public static float getFloat(byte[] bArr) {
        return getFloat(bArr, 0);
    }

    public static int getInt(byte[] bArr) {
        return ((bArr[3] << 24) & (-16777216)) | (bArr[0] & 255) | ((bArr[1] << 8) & 65280) | ((bArr[2] << 16) & 16711680);
    }

    public static byte[] toBytes(String str) {
        if (str.isEmpty()) {
            return new byte[0];
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) Integer.parseInt(str.substring(i2, i2 + 2), 16);
        }
        return bArr;
    }

    public static String toHex(byte[] bArr) {
        return toHex(bArr, 0, bArr.length);
    }

    public static byte[] getBytes(float f) {
        return getBytes(Float.floatToIntBits(f));
    }

    public static char getChar(byte[] bArr, int i) {
        return (char) (((bArr[i + 1] << 8) & 65280) | (bArr[i + 0] & 255));
    }

    public static double getDouble(byte[] bArr, int i) {
        long j = getLong(bArr, i);
        System.out.println(j);
        return Double.longBitsToDouble(j);
    }

    public static float getFloat(byte[] bArr, int i) {
        return Float.intBitsToFloat(getInt(bArr, i));
    }

    public static int getInt(byte[] bArr, int i) {
        return ((bArr[i + 3] << 24) & (-16777216)) | (bArr[i + 0] & 255) | ((bArr[i + 1] << 8) & 65280) | ((bArr[i + 2] << 16) & 16711680);
    }

    public static short getShort(byte[] bArr, int i) {
        return (short) (((bArr[i + 1] << 8) & 65280) | (bArr[i + 0] & 255));
    }

    public static long getLong(byte[] bArr) {
        return (bArr[0] & 255) | ((bArr[1] << 8) & 65280) | ((bArr[2] << 16) & 16711680) | ((bArr[3] << 24) & 4278190080L) | ((bArr[4] << 32) & 1095216660480L) | ((bArr[5] << 40) & 280375465082880L) | ((bArr[6] << 48) & 71776119061217280L) | ((bArr[7] << 56) & (-72057594037927936L));
    }

    public static long getLong(byte[] bArr, int i) {
        return ((bArr[i + 7] << 56) & (-72057594037927936L)) | (bArr[i + 0] & 255) | ((bArr[i + 1] << 8) & 65280) | ((bArr[i + 2] << 16) & 16711680) | ((bArr[i + 3] << 24) & 4278190080L) | ((bArr[i + 4] << 32) & 1095216660480L) | ((bArr[i + 5] << 40) & 280375465082880L) | ((bArr[i + 6] << 48) & 71776119061217280L);
    }

    public static String toHex(byte[] bArr, int i, int i2) {
        StringBuilder sb = new StringBuilder(i2 * 2);
        for (int i3 = 0; i3 < i2; i3++) {
            String hexString = Integer.toHexString(bArr[i + i3] & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString().toUpperCase();
    }
}
