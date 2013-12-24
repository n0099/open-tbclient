package com.google.protobuf;
/* loaded from: classes.dex */
final class Utf8 {
    public static final int COMPLETE = 0;
    public static final int MALFORMED = -1;

    private Utf8() {
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return isValidUtf8(bArr, 0, bArr.length);
    }

    public static boolean isValidUtf8(byte[] bArr, int i, int i2) {
        return partialIsValidUtf8(bArr, i, i2) == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0042, code lost:
        if (r8[r2] > (-65)) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x007d, code lost:
        if (r8[r2] > (-65)) goto L52;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int partialIsValidUtf8(int i, byte[] bArr, int i2, int i3) {
        byte b;
        int i4;
        int i5;
        int i6;
        if (i != 0) {
            if (i2 < i3) {
                byte b2 = (byte) i;
                if (b2 < -32) {
                    if (b2 >= -62) {
                        int i7 = i2 + 1;
                        if (bArr[i2] <= -65) {
                            i2 = i7;
                        }
                    }
                    return -1;
                } else if (b2 < -16) {
                    byte b3 = (byte) ((i >> 8) ^ (-1));
                    if (b3 == 0) {
                        i6 = i2 + 1;
                        b3 = bArr[i2];
                        if (i6 >= i3) {
                            return incompleteStateFor(b2, b3);
                        }
                    } else {
                        i6 = i2;
                    }
                    if (b3 <= -65 && ((b2 != -32 || b3 >= -96) && (b2 != -19 || b3 < -96))) {
                        i2 = i6 + 1;
                    }
                    return -1;
                } else {
                    byte b4 = (byte) ((i >> 8) ^ (-1));
                    byte b5 = 0;
                    if (b4 == 0) {
                        i4 = i2 + 1;
                        byte b6 = bArr[i2];
                        if (i4 >= i3) {
                            return incompleteStateFor(b2, b6);
                        }
                        b = b6;
                    } else {
                        b5 = (byte) (i >> 16);
                        b = b4;
                        i4 = i2;
                    }
                    if (b5 == 0) {
                        i5 = i4 + 1;
                        b5 = bArr[i4];
                        if (i5 >= i3) {
                            return incompleteStateFor(b2, b, b5);
                        }
                    } else {
                        i5 = i4;
                    }
                    if (b <= -65 && (((b2 << 28) + (b + 112)) >> 30) == 0 && b5 <= -65) {
                        i2 = i5 + 1;
                    }
                    return -1;
                }
            }
            return i;
        }
        return partialIsValidUtf8(bArr, i2, i3);
    }

    public static int partialIsValidUtf8(byte[] bArr, int i, int i2) {
        while (i < i2 && bArr[i] >= 0) {
            i++;
        }
        if (i >= i2) {
            return 0;
        }
        return partialIsValidUtf8NonAscii(bArr, i, i2);
    }

    private static int partialIsValidUtf8NonAscii(byte[] bArr, int i, int i2) {
        int i3;
        while (i < i2) {
            int i4 = i + 1;
            byte b = bArr[i];
            if (b < 0) {
                if (b < -32) {
                    if (i4 < i2) {
                        if (b >= -62) {
                            i3 = i4 + 1;
                            if (bArr[i4] > -65) {
                            }
                        }
                        return -1;
                    }
                    return b;
                } else if (b < -16) {
                    if (i4 >= i2 - 1) {
                        return incompleteStateFor(bArr, i4, i2);
                    }
                    int i5 = i4 + 1;
                    byte b2 = bArr[i4];
                    if (b2 <= -65 && ((b != -32 || b2 >= -96) && (b != -19 || b2 < -96))) {
                        i3 = i5 + 1;
                        if (bArr[i5] > -65) {
                        }
                    }
                    return -1;
                } else if (i4 >= i2 - 2) {
                    return incompleteStateFor(bArr, i4, i2);
                } else {
                    int i6 = i4 + 1;
                    byte b3 = bArr[i4];
                    if (b3 <= -65 && (((b << 28) + (b3 + 112)) >> 30) == 0) {
                        int i7 = i6 + 1;
                        if (bArr[i6] <= -65) {
                            i3 = i7 + 1;
                            if (bArr[i7] > -65) {
                            }
                        }
                    }
                    return -1;
                }
                i = i3;
            } else {
                i = i4;
            }
        }
        return 0;
    }

    private static int incompleteStateFor(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    private static int incompleteStateFor(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return (i2 << 8) ^ i;
    }

    private static int incompleteStateFor(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return ((i2 << 8) ^ i) ^ (i3 << 16);
    }

    private static int incompleteStateFor(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        switch (i2 - i) {
            case 0:
                return incompleteStateFor(b);
            case 1:
                return incompleteStateFor(b, bArr[i]);
            case 2:
                return incompleteStateFor(b, bArr[i], bArr[i + 1]);
            default:
                throw new AssertionError();
        }
    }
}
