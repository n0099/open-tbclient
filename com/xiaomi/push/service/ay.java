package com.xiaomi.push.service;

import com.baidu.webkit.internal.ETAG;
/* loaded from: classes9.dex */
public class ay {
    private static int a = 8;
    private int d = -666;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f876a = new byte[256];
    private int c = 0;
    private int b = 0;

    public static int a(byte b) {
        return b >= 0 ? b : b + 256;
    }

    private void a() {
        this.c = 0;
        this.b = 0;
    }

    private void a(int i, byte[] bArr, boolean z) {
        int length = bArr.length;
        for (int i2 = 0; i2 < 256; i2++) {
            this.f876a[i2] = (byte) i2;
        }
        this.c = 0;
        this.b = 0;
        while (this.b < i) {
            this.c = ((this.c + a(this.f876a[this.b])) + a(bArr[this.b % length])) % 256;
            a(this.f876a, this.b, this.c);
            this.b++;
        }
        if (i != 256) {
            this.d = ((this.c + a(this.f876a[i])) + a(bArr[i % length])) % 256;
        }
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append("S_").append(i - 1).append(":");
            for (int i3 = 0; i3 <= i; i3++) {
                sb.append(" ").append(a(this.f876a[i3]));
            }
            sb.append("   j_").append(i - 1).append(ETAG.EQUAL).append(this.c);
            sb.append("   j_").append(i).append(ETAG.EQUAL).append(this.d);
            sb.append("   S_").append(i - 1).append("[j_").append(i - 1).append("]=").append(a(this.f876a[this.c]));
            sb.append("   S_").append(i - 1).append("[j_").append(i).append("]=").append(a(this.f876a[this.d]));
            if (this.f876a[1] != 0) {
                sb.append("   S[1]!=0");
            }
            com.xiaomi.channel.commonutils.logger.b.m49a(sb.toString());
        }
    }

    private void a(byte[] bArr) {
        a(256, bArr, false);
    }

    private static void a(byte[] bArr, int i, int i2) {
        byte b = bArr[i];
        bArr[i] = bArr[i2];
        bArr[i2] = b;
    }

    public static byte[] a(String str, String str2) {
        byte[] m157a = com.xiaomi.push.bc.m157a(str);
        byte[] bytes = str2.getBytes();
        byte[] bArr = new byte[m157a.length + 1 + bytes.length];
        for (int i = 0; i < m157a.length; i++) {
            bArr[i] = m157a[i];
        }
        bArr[m157a.length] = 95;
        for (int i2 = 0; i2 < bytes.length; i2++) {
            bArr[m157a.length + 1 + i2] = bytes[i2];
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr, String str) {
        return a(bArr, com.xiaomi.push.bc.m157a(str));
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr2.length];
        ay ayVar = new ay();
        ayVar.a(bArr);
        ayVar.a();
        for (int i = 0; i < bArr2.length; i++) {
            bArr3[i] = (byte) (bArr2[i] ^ ayVar.m549a());
        }
        return bArr3;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z, int i, int i2) {
        byte[] bArr3;
        int i3;
        if (i < 0 || i > bArr2.length || i + i2 > bArr2.length) {
            throw new IllegalArgumentException("start = " + i + " len = " + i2);
        }
        if (z) {
            bArr3 = bArr2;
            i3 = i;
        } else {
            bArr3 = new byte[i2];
            i3 = 0;
        }
        ay ayVar = new ay();
        ayVar.a(bArr);
        ayVar.a();
        for (int i4 = 0; i4 < i2; i4++) {
            bArr3[i3 + i4] = (byte) (bArr2[i + i4] ^ ayVar.m549a());
        }
        return bArr3;
    }

    /* renamed from: a  reason: collision with other method in class */
    byte m549a() {
        this.b = (this.b + 1) % 256;
        this.c = (this.c + a(this.f876a[this.b])) % 256;
        a(this.f876a, this.b, this.c);
        return this.f876a[(a(this.f876a[this.b]) + a(this.f876a[this.c])) % 256];
    }
}
