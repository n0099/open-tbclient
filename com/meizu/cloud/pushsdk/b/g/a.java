package com.meizu.cloud.pushsdk.b.g;

import com.baidu.android.imsdk.internal.Constants;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f11190a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f11191b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    public static byte[] a(String str) {
        int i;
        int i2;
        int length = str.length();
        while (length > 0) {
            char charAt = str.charAt(length - 1);
            if (charAt != '=' && charAt != '\n' && charAt != '\r' && charAt != ' ' && charAt != '\t') {
                break;
            }
            length--;
        }
        byte[] bArr = new byte[(int) ((length * 6) / 8)];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i3 < length) {
            char charAt2 = str.charAt(i3);
            if (charAt2 >= 'A' && charAt2 <= 'Z') {
                i = charAt2 - 'A';
            } else if (charAt2 >= 'a' && charAt2 <= 'z') {
                i = charAt2 - 'G';
            } else if (charAt2 >= '0' && charAt2 <= '9') {
                i = charAt2 + 4;
            } else if (charAt2 == '+' || charAt2 == '-') {
                i = 62;
            } else if (charAt2 == '/' || charAt2 == '_') {
                i = 63;
            } else {
                if (charAt2 == '\n' || charAt2 == '\r' || charAt2 == ' ') {
                    i2 = i4;
                } else if (charAt2 != '\t') {
                    return null;
                } else {
                    i2 = i4;
                }
                i3++;
                i4 = i2;
            }
            i2 = ((byte) i) | (i4 << 6);
            int i7 = i5 + 1;
            if (i7 % 4 == 0) {
                int i8 = i6 + 1;
                bArr[i6] = (byte) (i2 >> 16);
                int i9 = i8 + 1;
                bArr[i8] = (byte) (i2 >> 8);
                i6 = i9 + 1;
                bArr[i9] = (byte) i2;
            }
            i5 = i7;
            i3++;
            i4 = i2;
        }
        int i10 = i5 % 4;
        if (i10 == 1) {
            return null;
        }
        if (i10 == 2) {
            bArr[i6] = (byte) ((i4 << 12) >> 16);
            i6++;
        } else if (i10 == 3) {
            int i11 = i4 << 6;
            int i12 = i6 + 1;
            bArr[i6] = (byte) (i11 >> 16);
            i6 = i12 + 1;
            bArr[i12] = (byte) (i11 >> 8);
        }
        if (i6 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i6];
        System.arraycopy(bArr, 0, bArr2, 0, i6);
        return bArr2;
    }
}
