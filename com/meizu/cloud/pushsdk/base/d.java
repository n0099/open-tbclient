package com.meizu.cloud.pushsdk.base;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f37653a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* renamed from: b  reason: collision with root package name */
    public static final char f37654b = (char) Integer.parseInt("00000011", 2);

    /* renamed from: c  reason: collision with root package name */
    public static final char f37655c = (char) Integer.parseInt("00001111", 2);

    /* renamed from: d  reason: collision with root package name */
    public static final char f37656d = (char) Integer.parseInt("00111111", 2);

    /* renamed from: e  reason: collision with root package name */
    public String f37657e;

    /* renamed from: f  reason: collision with root package name */
    public char[] f37658f;

    /* renamed from: g  reason: collision with root package name */
    public int f37659g = 0;

    public d(String str) {
        this.f37657e = str;
        a();
    }

    private void a() {
        char[] cArr = new char[f37653a.length];
        int i = 0;
        this.f37659g = this.f37657e.charAt(0) % '\r';
        while (true) {
            char[] cArr2 = f37653a;
            if (i >= cArr2.length) {
                this.f37658f = cArr;
                return;
            } else {
                cArr[i] = cArr2[(this.f37659g + i) % cArr2.length];
                i++;
            }
        }
    }

    public String a(byte[] bArr) {
        String str;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder(((bArr.length + 2) / 3) * 4);
        int i = 0;
        int length = bArr.length;
        while (i < length) {
            int i2 = i + 1;
            int i3 = bArr[i] & 255;
            if (i2 == length) {
                sb.append(this.f37658f[i3 >>> 2]);
                sb.append(this.f37658f[(i3 & f37654b) << 4]);
                str = "==";
            } else {
                int i4 = i2 + 1;
                int i5 = bArr[i2] & 255;
                if (i4 == length) {
                    sb.append(this.f37658f[i3 >>> 2]);
                    sb.append(this.f37658f[((i3 & f37654b) << 4) | (i5 >>> 4)]);
                    sb.append(this.f37658f[(f37655c & i5) << 2]);
                    str = "=";
                } else {
                    int i6 = i4 + 1;
                    int i7 = bArr[i4] & 255;
                    sb.append(this.f37658f[i3 >>> 2]);
                    sb.append(this.f37658f[((i3 & f37654b) << 4) | (i5 >>> 4)]);
                    sb.append(this.f37658f[((i5 & f37655c) << 2) | (i7 >>> 6)]);
                    sb.append(this.f37658f[f37656d & i7]);
                    i = i6;
                }
            }
            sb.append(str);
            break;
        }
        return sb.toString();
    }
}
