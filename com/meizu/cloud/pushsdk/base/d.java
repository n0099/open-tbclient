package com.meizu.cloud.pushsdk.base;

import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
/* loaded from: classes7.dex */
public class d {
    public static final char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', WebvttCueParser.CHAR_SLASH};

    /* renamed from: b  reason: collision with root package name */
    public static final char f42047b = (char) Integer.parseInt("00000011", 2);

    /* renamed from: c  reason: collision with root package name */
    public static final char f42048c = (char) Integer.parseInt("00001111", 2);

    /* renamed from: d  reason: collision with root package name */
    public static final char f42049d = (char) Integer.parseInt("00111111", 2);

    /* renamed from: e  reason: collision with root package name */
    public String f42050e;

    /* renamed from: f  reason: collision with root package name */
    public char[] f42051f;

    /* renamed from: g  reason: collision with root package name */
    public int f42052g = 0;

    public d(String str) {
        this.f42050e = str;
        a();
    }

    private void a() {
        char[] cArr = new char[a.length];
        int i = 0;
        this.f42052g = this.f42050e.charAt(0) % '\r';
        while (true) {
            char[] cArr2 = a;
            if (i >= cArr2.length) {
                this.f42051f = cArr;
                return;
            } else {
                cArr[i] = cArr2[(this.f42052g + i) % cArr2.length];
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
                sb.append(this.f42051f[i3 >>> 2]);
                sb.append(this.f42051f[(i3 & f42047b) << 4]);
                str = "==";
            } else {
                int i4 = i2 + 1;
                int i5 = bArr[i2] & 255;
                if (i4 == length) {
                    sb.append(this.f42051f[i3 >>> 2]);
                    sb.append(this.f42051f[((i3 & f42047b) << 4) | (i5 >>> 4)]);
                    sb.append(this.f42051f[(f42048c & i5) << 2]);
                    str = "=";
                } else {
                    int i6 = i4 + 1;
                    int i7 = bArr[i4] & 255;
                    sb.append(this.f42051f[i3 >>> 2]);
                    sb.append(this.f42051f[((i3 & f42047b) << 4) | (i5 >>> 4)]);
                    sb.append(this.f42051f[((i5 & f42048c) << 2) | (i7 >>> 6)]);
                    sb.append(this.f42051f[f42049d & i7]);
                    i = i6;
                }
            }
            sb.append(str);
            break;
        }
        return sb.toString();
    }
}
