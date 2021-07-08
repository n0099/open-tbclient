package com.meizu.cloud.pushsdk.base;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f37317a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* renamed from: b  reason: collision with root package name */
    public static final char f37318b = (char) Integer.parseInt("00000011", 2);

    /* renamed from: c  reason: collision with root package name */
    public static final char f37319c = (char) Integer.parseInt("00001111", 2);

    /* renamed from: d  reason: collision with root package name */
    public static final char f37320d = (char) Integer.parseInt("00111111", 2);

    /* renamed from: e  reason: collision with root package name */
    public String f37321e;

    /* renamed from: f  reason: collision with root package name */
    public char[] f37322f;

    /* renamed from: g  reason: collision with root package name */
    public int f37323g = 0;

    public d(String str) {
        this.f37321e = str;
        a();
    }

    private void a() {
        char[] cArr = new char[f37317a.length];
        int i2 = 0;
        this.f37323g = this.f37321e.charAt(0) % '\r';
        while (true) {
            char[] cArr2 = f37317a;
            if (i2 >= cArr2.length) {
                this.f37322f = cArr;
                return;
            } else {
                cArr[i2] = cArr2[(this.f37323g + i2) % cArr2.length];
                i2++;
            }
        }
    }

    public String a(byte[] bArr) {
        String str;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder(((bArr.length + 2) / 3) * 4);
        int i2 = 0;
        int length = bArr.length;
        while (i2 < length) {
            int i3 = i2 + 1;
            int i4 = bArr[i2] & 255;
            if (i3 == length) {
                sb.append(this.f37322f[i4 >>> 2]);
                sb.append(this.f37322f[(i4 & f37318b) << 4]);
                str = "==";
            } else {
                int i5 = i3 + 1;
                int i6 = bArr[i3] & 255;
                if (i5 == length) {
                    sb.append(this.f37322f[i4 >>> 2]);
                    sb.append(this.f37322f[((i4 & f37318b) << 4) | (i6 >>> 4)]);
                    sb.append(this.f37322f[(f37319c & i6) << 2]);
                    str = "=";
                } else {
                    int i7 = i5 + 1;
                    int i8 = bArr[i5] & 255;
                    sb.append(this.f37322f[i4 >>> 2]);
                    sb.append(this.f37322f[((i4 & f37318b) << 4) | (i6 >>> 4)]);
                    sb.append(this.f37322f[((i6 & f37319c) << 2) | (i8 >>> 6)]);
                    sb.append(this.f37322f[f37320d & i8]);
                    i2 = i7;
                }
            }
            sb.append(str);
            break;
        }
        return sb.toString();
    }
}
