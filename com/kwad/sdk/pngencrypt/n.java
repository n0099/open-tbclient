package com.kwad.sdk.pngencrypt;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
/* loaded from: classes6.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static Charset f33539a = Charset.forName("ISO-8859-1");

    /* renamed from: b  reason: collision with root package name */
    public static Charset f33540b = Charset.forName("UTF-8");

    /* renamed from: c  reason: collision with root package name */
    public static ThreadLocal<Boolean> f33541c = new ThreadLocal<Boolean>() { // from class: com.kwad.sdk.pngencrypt.n.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public Boolean initialValue() {
            return Boolean.FALSE;
        }
    };

    public static double a(int i2) {
        return i2 / 100000.0d;
    }

    public static final int a(int i2, int i3, int i4) {
        int i5 = (i2 + i3) - i4;
        int i6 = i5 >= i2 ? i5 - i2 : i2 - i5;
        int i7 = i5 >= i3 ? i5 - i3 : i3 - i5;
        int i8 = i5 >= i4 ? i5 - i4 : i4 - i5;
        return (i6 > i7 || i6 > i8) ? i7 <= i8 ? i3 : i4 : i2;
    }

    public static int a(InputStream inputStream) {
        try {
            return inputStream.read();
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.a(e2);
            return -1;
        }
    }

    public static int a(byte[] bArr, int i2) {
        return bArr[i2] & 255;
    }

    public static byte[] a() {
        return new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
    }

    public static int b(InputStream inputStream) {
        try {
            int read = inputStream.read();
            int read2 = inputStream.read();
            int read3 = inputStream.read();
            int read4 = inputStream.read();
            if (read == -1 || read2 == -1 || read3 == -1 || read4 == -1) {
                return -1;
            }
            return (read << 24) | (read2 << 16) | ((read3 << 8) + read4);
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.a(e2);
            return -1;
        }
    }

    public static int b(byte[] bArr, int i2) {
        return (bArr[i2 + 1] & 255) | ((bArr[i2] & 255) << 8);
    }

    public static final int c(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 255) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
    }
}
